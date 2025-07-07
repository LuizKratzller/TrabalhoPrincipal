package modelo;

import java.io.Serializable;
import java.util.Locale;

//  Declare a classe Financiamento como abstrata e implemente Serializable
public abstract class Financiamento implements Serializable {

    //  Declare a constante serialVersionUID
    private static final long serialVersionUID = 1L;

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    protected double valorFinanciamento;

    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double valorFinanciamento) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.valorFinanciamento = valorFinanciamento;
    }

    // Getters
    public double getValorImovel() { return valorImovel; }
    public int getPrazoFinanciamento() { return prazoFinanciamento; }
    public double getTaxaJurosAnual() { return taxaJurosAnual; }
    public double getValorFinanciamento() { return valorFinanciamento; }

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pt-BR"),
                "Valor do Imóvel: R$ %,.2f | Prazo: %d anos | Taxa de Juros: %.2f%% a.a.",
                this.valorImovel, this.prazoFinanciamento, (this.taxaJurosAnual * 100));
    }


}