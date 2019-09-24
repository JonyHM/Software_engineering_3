package br.edu.fatec.frameworkFinanceiro.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BR extends DateParse {

    @Override
    public String parse(Date date) {
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        return this.formatter.format(date).concat(this.getTimeDifference(date, true));
    }

}
