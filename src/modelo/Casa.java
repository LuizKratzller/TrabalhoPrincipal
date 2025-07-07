package modelo;

import java.io.Serializable; // Importe, se necessário
import java.util.Locale;

public class Casa extends Financiamento implements Serializable { // A interface já é herdada, mas ser explícito é ok

    private static final long serialVersionUID = 1L; // Adicione aqui também

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double valorFinanciamento, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual, valorFinanciamento);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    // Getters...

    @Override
    public String toString() {
        return "[CASA] " + super.toString() + String.format(Locale.forLanguageTag("pt-BR"),
                " | Área Construída: %.1f m² | Área do Terreno: %.1f m²", this.areaConstruida, this.areaTerreno);
    }


}