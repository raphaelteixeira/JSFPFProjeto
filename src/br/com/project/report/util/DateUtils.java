package br.com.project.report.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String getDateAtualReportName() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		return dateFormat.format(Calendar.getInstance().getTime());
	}

	public static String formatDateSql(Date data) {
		StringBuffer sb = new StringBuffer();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("'").append(df.format(data)).append("'");
		return sb.toString();
	}

	public static String formatDateSqlSimple(Date data) {
		StringBuffer sb = new StringBuffer();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		sb.append(df.format(data));
		return sb.toString();
	}

}
