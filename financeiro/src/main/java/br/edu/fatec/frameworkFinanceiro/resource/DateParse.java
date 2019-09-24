package br.edu.fatec.frameworkFinanceiro.resource;

import br.com.fatec.estacionamento.resource.MiliParaHora;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateParse {

    protected SimpleDateFormat formatter;

    public abstract String parse(Date date);

    protected String getTimeDifference(Date date, boolean BR) {
        Date now = new Date();

        String message = getTime(now.getTime() - date.getTime(), BR);

        return " (" + message + ")";
    }

    private String getTime(long time, boolean BR) {
        long days = MiliParaHora.transformarDias(time);

        if(BR) {
            return days < 1 ? MiliParaHora.transformarHoras(time) + " hora(s) atrás" :
                days >= 365 ? days / 365 + " ano(s) atrás":
                    days > 30 ? days / 30 + " mese(s) atrás"
                        : days + " dia(s) atrás";
        } else {
            return days < 1 ? MiliParaHora.transformarHoras(time) + " hour(s) ago" :
                    days >= 365 ? days / 365 + " year(s) ago":
                            days > 30 ? days / 30 + " month(s) ago"
                                    : days + " day(s) ago";
        }
    }
}
