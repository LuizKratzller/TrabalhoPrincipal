package modelo;

public class Casa extends Financiamento{

    private double areaConstruida;
    public double areaTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinanciamentoEmAnos, double taxaJurosAnual, double valorDoFinanciamento, double areaConstruida, double areaTerreno){
        super(valorDesejadoImovel, prazoFinanciamentoEmAnos, taxaJurosAnual, valorDoFinanciamento);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }



    public double calcularPagamentoMensal() {
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        int totalMeses = this.prazoFinanciamento * 12;

        // Evita divisão por zero se o prazo for 0
        if (totalMeses == 0) {
            return 0;

        }
        return taxaJurosMensal + 80;
    }
}
