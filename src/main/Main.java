package main;
import java.util.ArrayList;
import java.util.List;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import until.interfaceUsuario;

public class Main {
    public static void main(String[] args) {

        interfaceUsuario interfaceUsuario = new interfaceUsuario();
        List<Financiamento> ListaDEfinanciamento = new ArrayList<Financiamento>();


        ListaDEfinanciamento.add(new Casa(200000, 30, 0.08, 220000,50,65));
        ListaDEfinanciamento.add(new Casa(300000, 25, 0.075, 380000,39,60));
        ListaDEfinanciamento.add(new Apartamento(150000, 20, 0.09, 155000,20,10));
        ListaDEfinanciamento.add(new Apartamento(250000, 35, 0.082, 275000,15,8));
        ListaDEfinanciamento.add(new Terreno(250000, 35, 0.082, 275000,true,false));


        double valorImovelNovo = interfaceUsuario.pedirValorimovel();
        double taxaJurosNova = interfaceUsuario.pedirtaxaJuros();
        int prazoFinanciamentoNovo = interfaceUsuario.pedirPrazoFinancimento();
        boolean zonaResidencial = interfaceUsuario.zonaResidecial();
        boolean zonaComercial = interfaceUsuario.zonaComercial()
                ;


        double valorFinanciamentoNovo = valorImovelNovo;

        // Adiciona o novo financiamento à lista com todos os seus dados
        ListaDEfinanciamento.add(new Terreno(valorImovelNovo, prazoFinanciamentoNovo, taxaJurosNova, valorFinanciamentoNovo,zonaResidencial,zonaComercial));


        System.out.println("\n--- Seus Financiamentos Cadastrados ---");
        double totalGeralFinanciamentos = 0;

        // Loop

        for (int i = 0; i < ListaDEfinanciamento.size(); i++) {
            Financiamento f = ListaDEfinanciamento.get(i);
            System.out.println((i + 1) + ". " + f.toString() +
                    " | Pagamento Mensal Estimado: R$ " + String.format("%.2f", f.calcularPagamentoMensal()));
            totalGeralFinanciamentos += f.getValorFinanciamento();
        }

        // Imprime o valor total de todos os financiamentos.
        System.out.println("---------------------------------------");
        System.out.println("TOTAL GERAL FINANCIADO: R$ " + String.format("%.2f", totalGeralFinanciamentos));
        System.out.println("---------------------------------------");
    }
}