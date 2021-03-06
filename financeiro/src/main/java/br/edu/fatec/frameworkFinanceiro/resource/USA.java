package br.edu.fatec.frameworkFinanceiro.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class USA extends DateParse {

    @Override
    public String parse(Date date) {
        this.formatter = new SimpleDateFormat("yyyy/MM/dd");

        return this.formatter.format(date).concat(this.getTimeDifference(date, false));
    }
}
