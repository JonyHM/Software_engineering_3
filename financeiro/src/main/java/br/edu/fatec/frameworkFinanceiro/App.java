package br.edu.fatec.frameworkFinanceiro;

import br.edu.fatec.frameworkFinanceiro.resource.BR;
import br.edu.fatec.frameworkFinanceiro.resource.DateParse;
import br.edu.fatec.frameworkFinanceiro.resource.USA;
import com.external.Conta;
import com.external.Transacao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main( String[] args ) {

        Conta c = new Conta(new Date(), "Santander", "52310");

        Date date = new GregorianCalendar(2018, Calendar.SEPTEMBER, 24).getTime();
        Transacao t = new Transacao(date, c, 2500);

        DateParse parser = new BR();
        System.out.println(parser.parse(t.getData()));

        DateParse USParser = new USA();
        System.out.println(USParser.parse(t.getData()));
    }
}
