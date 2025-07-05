package modelo;

public class Terreno extends Financiamento {

    public String zonaTerreno;


    public String getZonaTerreno() {
        return this.zonaTerreno;
    }


    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double valorDoFinanciamento, String zonaTerreno){
        super(valorDesejadoImovel, prazoFinanciamentoEmAnos, taxaJurosAnual, valorDoFinanciamento);
        this.zonaTerreno = zonaTerreno;
    }

    public double calcularPagamentoMensal() {

        double valorFinanciamentoComAcrecimo = this.valorFinanciamento * 1.02;

        double taxaJurosMensal = (this.taxaJurosAnual / 100) / 12;
        int totalMeses = this.prazoFinanciamento * 12;

        if (totalMeses == 0) {
            return 0;
        }

        if (taxaJurosMensal == 0) {
            return valorFinanciamentoComAcrecimo / totalMeses;
        }

        double fator = Math.pow(1 + taxaJurosMensal, totalMeses);
        double parcelaCalculada = valorFinanciamentoComAcrecimo * (taxaJurosMensal * fator) / (fator - 1);

        return parcelaCalculada;
    }

    @Override
    public String toString() {
        return "Terreno: R$ " + String.format("%.2f", valorImovel) +
                " | Financiamento: R$ " + String.format("%.2f", valorFinanciamento) +
                " | Prazo: " + prazoFinanciamento + " anos" +
                " | Taxa Juros: " + String.format("%.2f", taxaJurosAnual * 100) + "% a.a." +
                " | Zona: " + zonaTerreno;
    }
}
