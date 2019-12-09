package br.edu.fatec.salao.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgeCalcResource {

	public static int calc(String birth, String pattern) {
		DateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;

		try {
			dataNascInput= sdf.parse(birth);
		} catch (Exception e) {
			e.printStackTrace();
		}			 

		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);

		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {
			age--;
		}

		return age;
	}
	
	public static int calc(Date birth) {
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(birth);
	
		Calendar today = Calendar.getInstance();
		
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);
	
		if (today.before(dateOfBirth)) {
			age--;
		}
	
		return age;
	}
}
