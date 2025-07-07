package modelo;

import java.io.Serializable;
import java.util.Locale;

public class Apartamento extends Financiamento implements Serializable {


    private static final long serialVersionUID = 1L;

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double valorFinanciamento, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual, valorFinanciamento);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    // Getters para os atributos específicos
    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public String toString() {
        return "[APARTAMENTO] " + super.toString() + String.format(" | Vagas: %d | Andar: %d", this.vagasGaragem, this.numeroAndar);
    }


}