package com.ytkl.mzwwz.timer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ytkl.mzwwz.criteria.CityInfoCriteria;
import com.ytkl.mzwwz.domain.CityInfo;
import com.ytkl.mzwwz.domain.CityWeather;
import com.ytkl.mzwwz.service.CityInfoService;
import com.ytkl.mzwwz.util.DataDownUtil;
import com.ytkl.mzwwz.util.JDBCUtil;

@Component
public class WeatherDataDownTimer {

	@Autowired
	private CityInfoService cityInfoService;

	//@Scheduled(cron = "0 * * * * *")
	//@Scheduled(fixedRate = 1000*30) 
	public void AutoWeatherDataDown() {
		
		// 查询数据库中城市信息
		List<CityInfo> cityInfoList = cityInfoService.list(new CityInfoCriteria());
		
		if(cityInfoList.size() != 0){
			// 抓取各城市气象信息
			List<CityWeather> cityWeatherList = DataDownUtil.downWeatherData(cityInfoList);
			// 将获取的各城市气象信息组织成插入sql语句
			List<String> insertSql = JDBCUtil.insertSql(cityWeatherList);
			// 数据录入：先将流数据删除，再将新数据录入
			String result = JDBCUtil.weatherJDBC(insertSql,JDBCUtil.deleteSql(cityWeatherList));
			
			System.out.println(result);
		}
		
	}

}
