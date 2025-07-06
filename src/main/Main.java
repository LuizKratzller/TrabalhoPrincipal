package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        String nomeDoArquivo = "financiamentos_salvos.txt";

        List<Financiamento> ListaDEfinanciamento = lerFinanciamentos(nomeDoArquivo);

        if (ListaDEfinanciamento.isEmpty()) {
            System.out.println("Nenhum financiamento encontrado. Adicionando dados iniciais.");
            ListaDEfinanciamento.add(new Casa(200000, 30, 0.08, 220000, 50, 65));
            ListaDEfinanciamento.add(new Casa(300000, 25, 0.075, 380000, 39, 60));
            ListaDEfinanciamento.add(new Apartamento(150000, 20, 0.09, 155000, 20, 10));
            ListaDEfinanciamento.add(new Apartamento(250000, 35, 0.082, 275000, 15, 8));
            ListaDEfinanciamento.add(new Terreno(250000, 35, 0.082, 275000, "Comercial"));
        }

        System.out.println("\n--- Adicionar Novo Financiamento ---");
        String tipoImovel = interfaceUsuario.tipoImovel();
        double valorImovelNovo = interfaceUsuario.pedirValorimovel();
        double taxaJurosNova = interfaceUsuario.pedirtaxaJuros();
        int prazoFinanciamentoNovo = interfaceUsuario.pedirPrazoFinancimento();
        double valorFinanciamentoNovo = valorImovelNovo;

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

        for (int i = 0; i < ListaDEfinanciamento.size(); i++) {
            Financiamento f = ListaDEfinanciamento.get(i);
            System.out.println((i + 1) + ". " + f.toString());
            totalGeralFinanciamentos += f.getValorFinanciamento();
        }

        System.out.println("---------------------------------------");
        System.out.println("TOTAL GERAL FINANCIADO: R$ " + String.format("%.2f", totalGeralFinanciamentos));
        System.out.println("---------------------------------------");

        salvarFinanciamentos(ListaDEfinanciamento, nomeDoArquivo);
    }

    public static void salvarFinanciamentos(List<Financiamento> listaFinanciamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, StandardCharsets.UTF_8))) {
            for (Financiamento fin : listaFinanciamentos) {
                writer.write(fin.paraFormatoArquivo());
                writer.newLine();
            }
            System.out.println("Dados atualizados e salvos com sucesso no arquivo '" + nomeArquivo + "'!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static List<Financiamento> lerFinanciamentos(String nomeArquivo) {
        List<Financiamento> financiamentosLidos = new ArrayList<>();
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            return financiamentosLidos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo, StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(";");
                String tipoImovel = partes[0];

                double valorImovel = Double.parseDouble(partes[1]);
                int prazo = Integer.parseInt(partes[2]);
                double taxaJuros = Double.parseDouble(partes[3]);
                double valorFinanciamento = Double.parseDouble(partes[4]);

                switch (tipoImovel) {
                    case "CASA":
                        double areaConstruida = Double.parseDouble(partes[5]);
                        double areaTerreno = Double.parseDouble(partes[6]);
                        financiamentosLidos.add(new Casa(valorImovel, prazo, taxaJuros, valorFinanciamento, areaConstruida, areaTerreno));
                        break;
                    case "APARTAMENTO":
                        int vagasGaragem = Integer.parseInt(partes[5]);
                        int numeroAndar = Integer.parseInt(partes[6]);
                        financiamentosLidos.add(new Apartamento(valorImovel, prazo, taxaJuros, valorFinanciamento, vagasGaragem, numeroAndar));
                        break;
                    case "TERRENO":
                        String zona = partes[5];
                        financiamentosLidos.add(new Terreno(valorImovel, prazo, taxaJuros, valorFinanciamento, zona));
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro ao ler ou processar o arquivo: " + e.getMessage());
        }
        return financiamentosLidos;
    }
}