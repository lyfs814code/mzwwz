package com.ytkl.mzwwz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ytkl.mzwwz.domain.CityInfo;
import com.ytkl.mzwwz.domain.CityWeather;

/**
 * 中国气象网各城市气象信息数据抓取
 * @author LiYafei
 * @date   2016年12月14日
 */
public class DataDownUtil {

	/**
	 * 读取网站源码信息工具类
	 * 
	 * @author hackxhao
	 * @param url
	 *            请求链接
	 * @param encoding
	 *            编码集
	 * @return buffer
	 */
	public static String getHtmlResourceByUrl(String url, String encoding) {
		// 存储源代码容器
		StringBuffer buffer = new StringBuffer();
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;

		try {
			// 建立网络连接
			urlObj = new URL(url);
			// 打开网络连接
			uc = urlObj.openConnection();
			// 建立文件写入流
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			// 建立缓存流写入流
			reader = new BufferedReader(isr);
			// 建立临时文件
			String temp = null;
			while ((temp = reader.readLine()) != null) {
				buffer.append(temp + "\n"); // 追加内容（一边读一边写）
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
			System.out.println("没有联网,检查设置");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("打开网络连接失败，请稍后重试");
		} finally {
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return buffer.toString();
	}

	/**
	 * 根据各城市编码抓取气象数据
	 * @param cityInfoList
	 * @return
	 */
	public static List<CityWeather> downWeatherData(List<CityInfo> cityInfoList){
		
		// 获取的城市天气数据
		List<CityWeather> cityWeathers = new ArrayList<CityWeather>();
		
		if(cityInfoList.size() != 0){
			for(CityInfo cityInfo : cityInfoList){
				System.out.println(cityInfo.getCountyName());
				if(cityInfo.getCityCode().equals("101021300") || cityInfo.getCityCode().equals("101030800")|| cityInfo.getCityCode().equals("101031200")){
					System.out.println("浦东");
				}else{
					
					String url = "http://www.weather.com.cn/weather/"+cityInfo.getCityCode()+".shtml";
					String encoding = "UTF-8";
					String html = getHtmlResourceByUrl(url, encoding);
					
					// 解析网页源代码
					Document document = Jsoup.parse(html);
					
					// 获取7天的天气情况
					Elements weatherElements = document.select("ul.t.clearfix > li");
					for (Element weatherElement : weatherElements) {
						
						// 每个城市天气信息
						CityWeather cityWeather = new CityWeather();
						cityWeather.setCityCode(cityInfo.getCityCode());// 城市编码
						
						// 日期
						Element dataElement = weatherElement.child(0);
						String data = dataElement.text();
						cityWeather.setForecastDate(data);
						
						// 天气情况
						Element weaElement = weatherElement.child(3);
						String wea = weaElement.text();
						cityWeather.setWeatherInfo(wea);
						
						// 温度情况
						Elements temperatureElements = weatherElement.child(4).children();
						String temperature = "";
						for(Element temperatureElement : temperatureElements){
							temperature += temperatureElement.text()+"/";
						}
						temperature = temperature.substring(0, temperature.length()-1);
						cityWeather.setTemperature(temperature);
						
						// 风力情况
						Elements windElements = weatherElement.child(5).children();
						String wind = windElements.get(1).text();
						cityWeather.setWindDirection(wind);
						
						cityWeathers.add(cityWeather);
					}
				}

				
			}
		}
		
		return cityWeathers;
		
	}
        

}
