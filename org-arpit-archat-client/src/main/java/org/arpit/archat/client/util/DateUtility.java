/**
 * 
 */
package org.arpit.archat.client.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author arpit
 *
 */
public abstract class DateUtility {
	private final static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static String convertDate(Date date) {
		return dateFormat.format(date); 
	}
}
