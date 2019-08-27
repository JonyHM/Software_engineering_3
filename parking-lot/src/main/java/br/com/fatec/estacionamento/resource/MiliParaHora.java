package br.com.fatec.estacionamento.resource;

import br.com.fatec.estacionamento.model.tempo.Dia;
import br.com.fatec.estacionamento.model.tempo.Hora;
import br.com.fatec.estacionamento.model.tempo.MedidasTempo;
import br.com.fatec.estacionamento.model.tempo.Minuto;
import br.com.fatec.estacionamento.model.tempo.Segundo;

public class MiliParaHora {
	
	private static MedidasTempo dias = new Dia();
	private static MedidasTempo horas = new Hora();
	private static MedidasTempo minutos = new Minuto();
	private static MedidasTempo segundos = new Segundo();

	public static long transformarDias(long horasTotais) {
		return horasTotais >= dias.getUnidade() 
            ? dias.calcularTempo(horasTotais) 
            : 0;
    }
    
    public static long transformarHoras(long horasTotais) {
        return horasTotais >= horas.getUnidade()
            ? horas.calcularTempo(horasTotais)
            : 0;
    }

    public static long transformarMinutos(long horasTotais) {
        return horasTotais >= minutos.getUnidade()
            ? minutos.calcularTempo(horasTotais)
            : 0;
    }

    public static long transformarSegundos(long horasTotais) {
        return horasTotais >= segundos.getUnidade()
            ? segundos.calcularTempo(horasTotais)
            : 0;
    }
}
