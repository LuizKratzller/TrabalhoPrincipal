package modelo;

public class Terreno extends Financiamento {

    public boolean zonaResidencial;
    public boolean zonaComercial;

    public boolean getzonaResidecial() {
        return this.zonaResidencial;
    }
    public boolean getzonaComercial() {
        return this.zonaComercial;
    }

    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double valorDoFinanciamento, boolean zonaResidencial, boolean zonaComercial){
        super(valorDesejadoImovel, prazoFinanciamentoEmAnos, taxaJurosAnual, valorDoFinanciamento);
        this.zonaResidencial = zonaResidencial;
        this.zonaComercial = zonaComercial;
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
}
