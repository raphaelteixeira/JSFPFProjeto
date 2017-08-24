package teste.junit;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import br.com.project.report.util.DateUtils;

public class TesteData {

	@Test
	public void testData() {
		try {
			assertEquals("23082017", DateUtils.getDateAtualReportName());
			assertEquals("'2017-08-23'",
					DateUtils.formatDateSql(Calendar.getInstance().getTime()));
			assertEquals("2017-08-23", DateUtils.formatDateSqlSimple(Calendar
					.getInstance().getTime()));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
