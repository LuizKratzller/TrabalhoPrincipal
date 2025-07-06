package modelo;

import java.util.Locale;

public class Casa extends Financiamento{

    public double areaConstruida;
    public double areaTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double valorDoFinanciamento, double areaConstruida, double areaTerreno){
        super(valorDesejadoImovel, prazoFinanciamentoEmAnos, taxaJurosAnual, valorDoFinanciamento);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida(){
        return this.areaConstruida;
    }
    public double getAreaTerreno(){
        return this.areaTerreno;
    }

    public double calcularPagamentoMensal() {
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        int totalMeses = this.prazoFinanciamento * 12;

        // Evita divisão por zero se o prazo for 0
        if (totalMeses == 0) {
            return 0;
        }

        double valorJuros = taxaJurosMensal * this.valorFinanciamento;
        double metadeJuros = valorJuros / 2.0;
        double acrescimo = 80.0;
        try {
            if (acrescimo > metadeJuros) {
                acrescimo = metadeJuros;
                throw new until.AumentoMaiorDoQueJurosException("O acréscimo foi ajustado para não ser maior que a metade do valor dos juros da mensalidade.");
            }
        } catch (until.AumentoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
        }
        return valorJuros + acrescimo;
    }

    @Override
    public String toString() {
        return "Casa: R$ " + String.format("%.2f", valorImovel) +
                " | Financiamento: R$ " + String.format("%.2f", valorFinanciamento) +
                " | Prazo: " + prazoFinanciamento + " anos" +
                " | Taxa Juros: " + String.format("%.2f", taxaJurosAnual * 100) + "% a.a." +
                " | Área construída: " + areaConstruida + "m²" +
                " | Área terreno: " + areaTerreno + " m²";
    }
    public String paraFormatoArquivo() {
        // Ordem: tipo;valorImovel;prazo;taxa;valorFinanciamento;areaConstruida;areaTerreno
        String formato = "CASA;%.2f;%d;%.4f;%.2f;%.2f;%.2f";
        return String.format(Locale.US, formato,
                this.getValorImovel(),
                this.getPrazoFinanciamento(),
                this.getTaxaJurosAnual(),
                this.getValorFinanciamento(),
                this.getAreaConstruida(),
                this.getAreaTerreno());
    }
}
