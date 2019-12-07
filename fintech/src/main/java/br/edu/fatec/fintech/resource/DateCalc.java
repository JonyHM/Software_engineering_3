package br.edu.fatec.fintech.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DateCalc {

	public Date calc(String date, String pattern) {
		DateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;

		try {
			dataNascInput= sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return dataNascInput;
	}
}
