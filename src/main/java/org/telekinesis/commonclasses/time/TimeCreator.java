package org.telekinesis.commonclasses.time;

import java.util.Calendar;

public class TimeCreator {
	private TimeCreator(){}
	
	public static long createDate(int year, int month, int day){
		return createDatetime(year, month, day, 0, 0, 0);
	}
	
	public static long createTime(int hour, int minute, int second){
		return createDatetime(1970, 0, 1, hour, minute, second);
	}
	
	public static long createDatetime(int year, int month, int day, int hour, int minute, int second){
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, day, hour, minute, second);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}
	
	public static long combineDateWithTime(long date, long time){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		c.setTimeInMillis(date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		return c.getTimeInMillis();
	}
	
	public static long extractTimeFromDateTime(long dateTime){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(dateTime);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		return createTime(hour, minute, second);
	}
	
	public static long extractDateFromDateTime(long dateTime){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(dateTime);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		return createDate(year, month + 1, day);
	}
}
