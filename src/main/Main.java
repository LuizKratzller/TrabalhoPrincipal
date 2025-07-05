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
        // Cria uma instância da interface de usuário e uma lista para armazenar os financiamentos
        interfaceUsuario interfaceUsuario = new interfaceUsuario();
        List<Financiamento> ListaDEfinanciamento = new ArrayList<Financiamento>();

        // Adiciona alguns financiamentos pré-cadastrados
        ListaDEfinanciamento.add(new Casa(200000, 30, 0.08, 220000,50,65));
        ListaDEfinanciamento.add(new Casa(300000, 25, 0.075, 380000,39,60));
        ListaDEfinanciamento.add(new Apartamento(150000, 20, 0.09, 155000,20,10));
        ListaDEfinanciamento.add(new Apartamento(250000, 35, 0.082, 275000,15,8));
        ListaDEfinanciamento.add(new Terreno(250000, 35, 0.082, 275000,"Comercial"));

        // Solicita ao usuário os dados do novo financiamento
        String tipoImovel = interfaceUsuario.tipoImovel();
        double valorImovelNovo = interfaceUsuario.pedirValorimovel();
        double taxaJurosNova = interfaceUsuario.pedirtaxaJuros();
        int prazoFinanciamentoNovo = interfaceUsuario.pedirPrazoFinancimento();
        double valorFinanciamentoNovo = valorImovelNovo;

        // Limpa o buffer antes de usar nextLine() novamente
        interfaceUsuario.scanner.nextLine();

        if (tipoImovel.equalsIgnoreCase("Terreno")) {
            String zonaTerreno = interfaceUsuario.zonaTerreno();
            ListaDEfinanciamento.add(new Terreno(valorImovelNovo, prazoFinanciamentoNovo, taxaJurosNova, valorFinanciamentoNovo, zonaTerreno));
        } else if (tipoImovel.equalsIgnoreCase("Casa")) {
            System.out.print("Digite a área construída: ");
            double areaConstruida = interfaceUsuario.scanner.nextDouble();
            System.out.print("Digite a área do terreno: ");
            double areaTerreno = interfaceUsuario.scanner.nextDouble();
            ListaDEfinanciamento.add(new Casa(valorImovelNovo, prazoFinanciamentoNovo, taxaJurosNova, valorFinanciamentoNovo, areaConstruida, areaTerreno));
        } else if (tipoImovel.equalsIgnoreCase("Apartamento")) {
            System.out.print("Digite o numero de vagas: ");
            int vagasGaragem = (int) interfaceUsuario.scanner.nextDouble();
            System.out.print("Digite o número do andar: ");
            int numeroAndar = (int) interfaceUsuario.scanner.nextDouble();
            ListaDEfinanciamento.add(new Apartamento(valorImovelNovo, prazoFinanciamentoNovo, taxaJurosNova, valorFinanciamentoNovo, vagasGaragem, numeroAndar));
        }

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