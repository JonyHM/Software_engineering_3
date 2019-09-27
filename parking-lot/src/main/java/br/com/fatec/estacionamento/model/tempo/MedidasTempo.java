package br.com.fatec.estacionamento.model.tempo;

public abstract class MedidasTempo {

    protected long unidade;
    protected long tempo;

    public long getTempo() {
        return tempo;
    }

    public long getUnidade() {
        return unidade;
    }

    public long calcularTempo(long tempo) {
        this.tempo = tempo / this.unidade;

        return this.tempo;
    }
}