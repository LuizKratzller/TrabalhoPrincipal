package modelo;

import java.io.Serializable;
import java.util.Locale;

public class Terreno extends Financiamento implements Serializable {

    // Adiciona o ID de versão para a serialização
    private static final long serialVersionUID = 1L;

    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double valorFinanciamento, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual, valorFinanciamento);
        this.tipoZona = tipoZona;
    }

    // Getter para o atributo específico
    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public String toString() {
        return "[TERRENO] " + super.toString() + " | Zona: " + this.tipoZona;
    }


}