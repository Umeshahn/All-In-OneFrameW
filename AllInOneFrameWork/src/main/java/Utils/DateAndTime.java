package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;


/**
 * 
 * @author hnum
 * 
 * This class includes all Date and Time Re-usable methods
 *
 */
public class DateAndTime {
	
	public static String getCurrentTime(String timeformat, String timezone) {
		
		try {
		Date date = new Date();
		
		TimeZone timeZone = TimeZone.getTimeZone(timezone);
		
		/* Specifying the format */
		DateFormat dateFormat = new SimpleDateFormat(timeformat);
		
		/* Setting the Timezone */
		dateFormat.setTimeZone(timeZone);
		
		 /* Picking the date value in the required Format */
		String time = dateFormat.format(date);
		return time;
		
		}catch (Exception e) {
			Log.message("The error message is "+e.getMessage());
		}
		
		return null;
		
	}
	
	public static String getCurrentDate(String dateformat, String timezone) {
		try {
			Date date = new Date();
			
			TimeZone timeZone = TimeZone.getTimeZone(timezone);
			
			DateFormat dateFormat = new SimpleDateFormat(dateformat);
			
			dateFormat.setTimeZone(timeZone);
			
			String currentdate = dateFormat.format(date);
			return currentdate;
			
		}catch(Exception e) {
			Log.message("The error message is "+e.getMessage());
		}
		return null;
	}
	
	public static String getPreviousDate(String dateformat, String timezone) {
		try {
			Date date = DateUtils.addDays(new Date(), -1);
			
			TimeZone timeZone = TimeZone.getTimeZone(timezone);
			
			DateFormat dateFormat = new SimpleDateFormat(dateformat);
			
			dateFormat.setTimeZone(timeZone);
			
			String previousdate = dateFormat.format(date);
			return previousdate;
			
		}catch(Exception e) {
			Log.message("The error message is "+e.getMessage());
		}
		return null;
	}
	
	public static String getNextDate(String dateformat, String timezone) {
		try {
			Date date = DateUtils.addDays(new Date(), +1);
			
			TimeZone timeZone = TimeZone.getTimeZone(timezone);
			
			DateFormat dateFormat = new SimpleDateFormat(dateformat);
			
			dateFormat.setTimeZone(timeZone);
			
			String nextdate = dateFormat.format(date);
			return nextdate;
			
		}catch(Exception e) {
			Log.message("The error message is "+e.getMessage());
		}
		return null;
	}
	
	public static String getDate(String dateformat, String timezone, int day) {
		try {
			Date date = DateUtils.addDays(new Date(), day);
			
			TimeZone timeZone = TimeZone.getTimeZone(timezone);
			
			DateFormat dateFormat = new SimpleDateFormat(dateformat);
			
			dateFormat.setTimeZone(timeZone);
			
			return dateFormat.format(date);
			
		}catch(Exception e) {
			Log.message("The error message is "+e.getMessage());
		}
		return null;
	}
	
	public static String getDateTimeStamp(String timezone) {
		
		try {
			Calendar  calendar = Calendar.getInstance();
			
			TimeZone fromTimeZone = calendar.getTimeZone();
			
			TimeZone toTimeZone = TimeZone.getTimeZone(timezone);
			
			calendar.setTimeZone(fromTimeZone);
			
			calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
			
			if(fromTimeZone.inDaylightTime(calendar.getTime()))
			{
				calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
			}
			
			calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
	        if (toTimeZone.inDaylightTime(calendar.getTime())) {
	            calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
	        }
	        
	     return calendar.getTime().toString();
			
		}catch(Exception e) {
			Log.message("The error message is "+ e.getMessage());
		}
		
		return null;
		
	}
	

}
