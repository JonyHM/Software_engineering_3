package br.edu.fatec.fintech.resource;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import br.edu.fatec.fintech.model.entity.Movimentacao;
import br.edu.fatec.fintech.model.enums.Classificacao;

public class Relatorio {

	/**
	 * Gera um relatório de movimentações de acordo com o mês base, indicado por um valor inteiro. 
	 * 	O front-end deve enviar o número que representa o mês do ano - EX.: Março = 3
	 * @param mes - Mês base
	 * @param todasMovimentacoes - Todas as movimentações do usuário
	 */
	public void mensal(int mes, List<Movimentacao> todasMovimentacoes) {
		List<Movimentacao> movimentacoes = new ArrayList<>();
		
		for (Movimentacao movimentacao : todasMovimentacoes) {
			int mesMov = mesToInt(movimentacao.getData());			
			if (mesMov == mes) {
				movimentacoes.add(movimentacao);
			}
		}
		
		imprimir(movimentacoes);
	}
	
	/**
	 * Gera um relatório de movimentações de acordo com a semana indicada do mês base, ambos indicados por um valor inteiro. 
	 * 	O front-end deve enviar o número que representa a semana do mês e outro com o mês do ano - EX.: 1ª semana de Março = 1, 3
	 * @param semana - Semana do mês desejado
	 * @param mes - Mês desejado
	 * @param todasMovimentacoes - Todas as movimentações do usuário
	 */
	public void semanal(int semana, int mes, List<Movimentacao> todasMovimentacoes) {
		List<Movimentacao> movimentacoes = new ArrayList<>();
		List<Movimentacao> movFinal = new ArrayList<>();
		
		for (Movimentacao movimentacao : todasMovimentacoes) {
			int mesMov = mesToInt(movimentacao.getData());			
			if (mesMov == mes) {
				movimentacoes.add(movimentacao);
			}
		}
		
		for (Movimentacao movimentacao : movimentacoes) {
			int semanaCalc = numeroDaSemana(mes, movimentacao.getData());
			if (semana == semanaCalc) {
				movFinal.add(movimentacao);
			}
		}
		
		imprimir(movFinal);
	}

	/**
	 * Recebe a data da movimentação e retorna o mês em formato inteiro
	 * @param data
	 * @return Valor inteiro correspondente ao mês da movimentação
	 */
	private int mesToInt(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String strData = dateFormat.format(data);
        String[] componentes = strData.split("-");
        int mesInt = Integer.parseInt(componentes[1]);
		return mesInt;
	}

	/**
	 * Descobre a semana do mês correspondente a data informada.
	 * @param mes - Mês a ser calculado.
	 * @param data - Data para que seja possível descobrir o número da semana.
	 * @return Número da semana correspondente a data.
	 */
	private int numeroDaSemana(int mes, Date data) {
		DateFormat formatter = new SimpleDateFormat("MM-yyyy");
		int semana = 0;
		
        Date date;
		try {
			date = (Date) formatter.parse(String.valueOf(mes) + "-2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}

        int mesCalc = mes;
        int ano = 2019;
        Calendar cal = new GregorianCalendar();

        String ultimoDiaDoMes = String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String[] DIA_SEMANA_EXTENSO = new DateFormatSymbols(new Locale("pt", "BR")).getWeekdays(); 
        List<String> listaDosDias = new ArrayList<>();
        
        for (int i = 1; i <= Integer.parseInt(ultimoDiaDoMes); i++) {
            String dia;
            dia = String.valueOf(i) + "-" + String.valueOf(mesCalc) + "-" + String.valueOf(ano);
            
            try {
				date = df.parse(dia);
			} catch (ParseException e) {
				e.printStackTrace();
				date = new Date();
			}
            
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            String diaDaSemana = DIA_SEMANA_EXTENSO[c.get(Calendar.DAY_OF_WEEK)];
            
            if (diaDaSemana == "Segunda-feira") {
            	listaDosDias.add(dia + ";" + diaDaSemana);
            } else if (diaDaSemana == "Sexta-feira") {
            	listaDosDias.add(dia + ";" + diaDaSemana);
            }
        }
        
        for (String d : listaDosDias) {
        	String datas[] = d.split(";");
        	Date dia = new Date();
        	String diaDaSemana = datas[1];
        	int semanas = 0;
        	
        	try {
				dia = df.parse(datas[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}

        	if (diaDaSemana.equals("Sexta-feira")) {
        		semanas ++;
        		if (data.before(dia) || data.equals(dia)) {
        			semana = semanas;
        		}
        	}
        }
        return semana;
	}
	
	/**
	 * Imprime o relatório de movimentações
	 * @param movimentacoes - Movimentações a serem impressas
	 */
	private void imprimir(List<Movimentacao> movimentacoes) {
		Double positivo = 0.0, negativo = 0.0, total = 0.0;
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getClassificacao().toString() + ": "
					+ movimentacao.getTipo().toString());
			System.out.println("Valor: " + movimentacao.getValor());
			
			if (movimentacao.getClassificacao() == Classificacao.ENTRADA) {
				positivo += movimentacao.getValor();
			} else {
				negativo += movimentacao.getValor();
			}
		}
		total = positivo - negativo;
		System.out.println("Saldo final no período: R$" + total);
	}
}
