package br.com.huetech.controleimoveis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public String getFormatDate(Date date, String format) {
	    SimpleDateFormat sdfDate = new SimpleDateFormat(format);
	    String strDate = sdfDate.format(date);
	    return strDate;
	}
}
