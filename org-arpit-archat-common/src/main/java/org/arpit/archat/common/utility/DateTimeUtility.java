/**
 * 
 */
package org.arpit.archat.common.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arpit.Rathore
 *
 */
public class DateTimeUtility {

	private final static DateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyy");
	private final static DateFormat timeFormat = new SimpleDateFormat(
			"hh:mm");
	
	private final static DateFormat dateFormatWithTime = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

	public static String convertDateToString(final Date date) {
		return dateFormat.format(date);
	}

	public static Date convertStringToDate(final String string) {
		try {
			return dateFormat.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String convertToTime(final Date date) {
		return timeFormat.format(date);
	}
	
	public static String convertDateTimeToString(final Date date) {
		if(date == null){
			return null;
		}
		return dateFormatWithTime.format(date);
	}
	
	public static Date convertStringToDateTime(final String date) {
		if(date == null){
			return null;
		}
		try {
			return dateFormatWithTime.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
