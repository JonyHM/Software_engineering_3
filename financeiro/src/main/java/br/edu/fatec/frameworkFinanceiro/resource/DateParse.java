package br.edu.fatec.frameworkFinanceiro.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.fatec.frameworkFinanceiro.service.Month;
import br.edu.fatec.frameworkFinanceiro.service.Year;

public abstract class DateParse {

    protected SimpleDateFormat formatter;

    public abstract String parse(Date date);

    protected String getTimeDifference(Date date, boolean BR) {
        Date now = new Date();

        String message = getTime(now.getTime() - date.getTime(), BR);

        return " (" + message + ")";
    }

    private String getTime(long time, boolean BR) {
    	return new Year().isBR(BR).calculateTimeDifference(time, new Month());
    }
}
