package com.ytkl.mzwwz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @since Feb 20, 2012
 */
public class DateUtils {
	public static final String YYYY = "yyyy";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String EEE_MMM_DD_HH_MM_SS_ZZZ_YYYY = "EEE MMM dd HH:mm:ss zzz yyyy";
	private StringBuffer buffer = new StringBuffer();
	private static String ZERO = "0";
	private static DateUtils date;
	public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	public static Date parse(String dateStr) {
		if ("".equals(dateStr) || null == dateStr) {
			return null;
		}
		dateStr = dateStr.trim();
		Date date = null;
		if (dateStr.length() == YYYY.length()) {
			date = parse(dateStr, YYYY);
		} else if (dateStr.length() == YYYY_MM.length()) {
			date = parse(dateStr, YYYY_MM);
		} else if (dateStr.length() == YYYY_MM_DD.length()) {
			date = parse(dateStr, YYYY_MM_DD);
		} else if (dateStr.length() == YYYY_MM_DD_HH_MM.length()) {
			date = parse(dateStr, YYYY_MM_DD_HH_MM);
		} else if (dateStr.length() == YYYY_MM_DD_HH_MM_SS.length()) {
			date = parse(dateStr, YYYY_MM_DD_HH_MM_SS);
		} else {
			date = parseCST(dateStr);
		}
		return date;
	}

	public static Date parseCST(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(EEE_MMM_DD_HH_MM_SS_ZZZ_YYYY, Locale.US);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return parse(dateStr, YYYY_MM_DD_HH_MM_SS);
		}
	}

	public static Date parse(String dateStr, String pattern) {
		SimpleDateFormat fmt = new SimpleDateFormat();
		Date date = null;
		try {
			fmt.applyPattern(pattern);
			date = fmt.parse(dateStr);
		} catch (ParseException e) {
			try {
				fmt.applyPattern(YYYY_MM_DD_HH_MM);
				date = fmt.parse(dateStr);
			} catch (ParseException e1) {
				fmt.applyPattern(YYYY_MM_DD);
				try {
					date = fmt.parse(dateStr);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		}
		return date;
	}

	public static String formatTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	public static String formatTear(Date date) {
		return format(date, YYYY);
	}

	public static String formatDate(Date date) {
		return format(date, YYYY_MM_DD);
	}

	public static String formatDateTime(Date date) {
		return format(date, YYYY_MM_DD_HH_MM_SS);
	}

	public static String format(String pattern) {
		return format(new Date(), pattern);
	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat fmt = new SimpleDateFormat();
		fmt.applyPattern(pattern);
		return fmt.format(date);
	}

	public static Long parseLong() {
		return parseLong(new Date());
	}

	public static Long parseLong(Date date) {
		return date.getTime();
	}

	public static DateUtils getDateInstance() {
		if (date == null) {
			date = new DateUtils();
		}
		return date;
	}

	private static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 得到当前日期 格式为 八位例如：20130510
	 * 
	 * @return
	 */
	public String getNowDate() {
		Calendar calendar = getCalendar();
		buffer.delete(0, buffer.capacity());
		buffer.append(calendar.get(Calendar.YEAR));
		int monday = calendar.get(Calendar.MONDAY) + 1;
		if (monday < 10) {
			buffer.append(ZERO);
		}
		buffer.append(monday);
		int day = calendar.get(Calendar.DATE);
		if (day < 10) {
			buffer.append(ZERO);
		}
		buffer.append(day);

		return buffer.toString();
	}

	/**
	 * 得到指定日期前后的日期 参数传负数即可
	 * 
	 * @param flag
	 *            标志：年/月/日：Y/M/D
	 * @param num
	 *            数字，整数往后推,负数往前移动
	 * @param date
	 *            日期yyyy-MM-dd，默认今天
	 * @return
	 */
	public static String getDate(String flag, int num, String date) {
		Calendar c = Calendar.getInstance();// 获得一个日历的实例
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new Date();
		if (date != null && date != "") {
			try {
				dd = sdf.parse(date);
			} catch (Exception e) {

			}
		}
		c.setTime(dd);// 设置日历时间
		if ("Y".equals(flag)) {
			c.add(Calendar.YEAR, num);
		} else if ("M".equals(flag)) {
			c.add(Calendar.MONTH, num);
		} else if ("N".equals(flag)) {
			c.add(Calendar.DATE, num);
		}
		String strDate = sdf.format(c.getTime());// 的到你想要得6个月后的日期
		return strDate;

	}

	public static void main(String[] args) {
		Date nowDate = new Date();
		String date = DateUtils.formatDate(nowDate);
		int year = Integer.parseInt(DateUtils.formatTear(nowDate).toString()) - 18;
		System.out.println(year + date.substring(4));
	}
}
