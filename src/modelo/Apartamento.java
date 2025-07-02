package modelo;

public class Apartamento extends Financiamento{

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double valorDoFinanciamento, int vagasGaragem, int numeroAndar){
        super(valorDesejadoImovel, prazoFinanciamentoEmAnos, taxaJurosAnual, valorDoFinanciamento);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int meses = this.prazoFinanciamento * 12;

        if (meses == 0){
            return 0;
        }
        double numerador = this.valorFinanciamento * Math.pow(1 + taxaMensal, meses) * taxaMensal;
        double denominador = Math.pow(1+ taxaMensal, meses) - 1;

        if (denominador == 0){
            return 0;
        }
        return numerador / denominador;
    }

}
