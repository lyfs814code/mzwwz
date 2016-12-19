package com.ytkl.mzwwz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ytkl.mzwwz.domain.CityWeather;

/**
 * JDBC连接数据库相关操作
 * @author LiYafei
 * @date   2016年12月14日
 */
public class JDBCUtil {

	static Connection conn = null;// 数据库连接对象
	static PreparedStatement ps = null;// 预编译SQL语句对象
	
	/**
	 * 创建数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		
		String driver = "com.mysql.jdbc.Driver"; // Mysql驱动
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
		String url = "jdbc:mysql://127.0.0.1:3306/mzwwz?"
	               + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		
		/* 1、加载JDBC驱动程序：在连接数据库之前，首先要加载想要连接的数据库的驱动到JVM（Java虚拟机），   
	     *    这通过java.lang.Class类的静态方法forName(String  className)实现，
         *    也可以通过初始化来驱动起来，下面三种形式都可以。
         *    成功加载后，会将Driver类的实例注册到DriverManager类中。
		 */    
		try{
			Class.forName(driver);// 动态加载mysql驱动
			// or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();
		}catch(ClassNotFoundException e){
			System.out.println("找不到驱动程序类 ，加载驱动失败！");   
		    e.printStackTrace() ;
		}
        
        System.out.println("成功加载驱动程序");
        
        /* 2、创建数据库链接，要连接数据库，需要向java.sql.DriverManager请求并获得Connection对象，该对象就代表一个数据库的连接。   
         *    使用DriverManager的getConnectin(String url , String username ,String password )方法   
         *    传入指定的欲连接的数据库的路径、数据库的用户名和密码来获得。
         */
        try {
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);//关闭自动提交模式
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}
        
        System.out.println("连接数据库成功");
		
		return conn;
	}
	
	/**
	 * 关闭jdbc对象
	 */
	public static void colse(){
		/* 关闭JDBC对象    
         *   操作完成以后要把所有使用的JDBC对象全都关闭，以释放JDBC资源，   
         *   关闭顺序和声明顺序相反：   
         *       1、关闭记录集   
         *       2、关闭声明 
         *       3、关闭连接对象  
         */       
		if(ps != null){
			try {
				ps.close();// 关闭声明
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();// 关闭连接对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 天气数据录入到数据库，并将之前数据清除
	 * 
	 * @param sqlList 录入数据SQL语句
	 * @param cityCodes 城市编码，用于删除之前城市天气数据
	 */
	public static String weatherJDBC(List<String> insertSql,String deleteSql){
		
		String result = "城市天气数据更新成功";// 执行结果
		
		conn = getConnection();// 创建数据库连接
		
		try {
			// 删除原有城市天气数据
			ps = conn.prepareStatement(deleteSql);
			int resultDel = ps.executeUpdate();
			
			// 重新录入城市天气数据
			int resultIns = 0;
			for(String sql : insertSql){
				ps = conn.prepareStatement(sql);
				resultIns += ps.executeUpdate();// 执行SQL语句
			}
			
			conn.commit();// 提交更改（此方法只应该在已禁用自动提交模式时使用）
			
			System.out.println("成功删除"+resultDel+"条数据");
			System.out.println("成功插入"+resultIns+"条数据");
			
		} catch (SQLException e) {
			 e.printStackTrace();
	            try {
					conn.rollback();// 取消更改
				} catch (SQLException e1) {
					System.out.println("操作数据库失败，请检查");
					result = "城市天气数据更新失败";
					e1.printStackTrace();
				}
		} finally {
			colse();// 关闭连接
		}
		
		return result;
		
	}
	
	/**
	 * 获取数据录入SQL
	 * 
	 * @param CityWeathers
	 * 				城市天气数据
	 * @return
	 */
	public static List<String> insertSql(List<CityWeather> CityWeathers){
		
		List<String> sqlList = new ArrayList<String>();
		
		if(CityWeathers.size() != 0){
			StringBuffer sqlHead = new StringBuffer();
			sqlHead.append("insert into cityweather(ForecastDate,CityCode,WeatherInfo,Temperature,WindDirection,UpdateTime) values") ;
			
			StringBuffer sqlValue = new StringBuffer();
			for(CityWeather cityWeather : CityWeathers){
					
				sqlValue.append("('"+cityWeather.getForecastDate()+"','"+cityWeather.getCityCode()+"','"+cityWeather.getWeatherInfo()+"','"+cityWeather.getTemperature()+"','"+cityWeather.getWindDirection()+"',SYSDATE()),");
			}
			
			sqlValue = sqlValue.delete(sqlValue.toString().length()-1, sqlValue.toString().length()).append(";");
				
			sqlList.add(sqlHead.toString() + sqlValue.toString());
			
		}
		
		return sqlList;
	}
	
	/**
	 * 获取数据删除SQL
	 * @param cityWeatherList
	 * 				抓取的各城市天气数据，根据cityCode删除原有气象数据
	 * 这里传入的是抓取成功的各城市天气数据中的城市编码，如果某些城市没有抓取，那么它的原有数据将不会被删除。
	 * @return
	 */
	public static String deleteSql(List<CityWeather> cityWeatherList){
		
		StringBuffer deleteSql = new StringBuffer();
		if(cityWeatherList.size() != 0){
			deleteSql.append("delete from cityweather where CityCode in (");
			for(CityWeather cityWeather : cityWeatherList){
				deleteSql.append("'"+cityWeather.getCityCode()+"',");
			}
			deleteSql.delete(deleteSql.toString().length()-1, deleteSql.toString().length()).append(");");
		}
		
		return deleteSql.toString();
		
	}
}
