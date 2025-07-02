package modelo;

public abstract class Financiamento {

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    protected double valorFinanciamento;


    //Métodos Getters:


    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public double getValorFinanciamento() {
        return this.valorFinanciamento;
    }


     //Construtor da classe Financiamento:

    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double valorDoFinanciamento) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoEmAnos;
        this.taxaJurosAnual = taxaJurosAnual;
        this.valorFinanciamento = valorDoFinanciamento;
    }

     //Métodos de Cálculo:


    public abstract double calcularPagamentoMensal();


    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "Imóvel: R$ " + String.format("%.2f", valorImovel) +
                " | Financiamento: R$ " + String.format("%.2f", valorFinanciamento) +
                " | Prazo: " + prazoFinanciamento + " anos" +
                " | Taxa Juros: " + String.format("%.2f", taxaJurosAnual * 100) + "% a.a.";
    }
}