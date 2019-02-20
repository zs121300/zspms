package com.zs.pms.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * @author DELL
 *时间工具类
 */
public class DateUtil {
	/**
	 * 获得当前时间的方法（字符串）
	 * @return返回当前时间字符串
	 */
	public static String getStrDate(Date date1) {
		//获得日历对象
		Calendar cal = Calendar.getInstance();
		//当前的年
		int year = cal.get(Calendar.YEAR);
		//当前的月(月份从0开始)
		int month = cal.get(Calendar.MONTH)+1;
		//当前的日
		int date = cal.get(Calendar.DAY_OF_MONTH);
		//当前的小时
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//当前的分
		int minute = cal.get(Calendar.MINUTE);
		//当前的秒
		int second = cal.get(Calendar.SECOND);
		//通过获得的当前小时来判断是上午还是下午
		String string="";
		if (hour>=6&&hour<=11) {
			string="上午好";
		}else if (hour>11&&hour<=14) {
			string="中午好";
		}else if (hour>14&&hour<=18) {
			string="下午好";
		}else if (hour>18&&hour<24) {
			string="晚上好";
		}else {
			string="玩你妹玩，快轱辘去睡觉";
		}
		return year+"-"+month+"-"+date+""+string;
	}
	/**
	 * 字符串转时间方法
	 * @param time字符串
	 * @param pattern输入的字符串时间格式
	 * @return date的时间
	 * @throws ParseException
	 * 
	 */
	public static Date getStrToDate(String time,String pattern) throws ParseException {
		//获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//返回格式化好的时间
		return sdf.parse(time);
	}
	/**
	 * 时间转字符串方法
	 * @param time要转的时间
	 * @param pattern输入的字符串时间格式
	 * @return String的时间
	 */
	public static String getDateToStr(Date time,String pattern) {
		//获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//返回格式化好的对象
		return sdf.format(time);
		
	}

}
