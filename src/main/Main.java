package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File; // Importado para uso em lerFinanciamentos
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
        String nomeDoArquivo = "financiamentos.ser"; // Arquivo binário para objetos serializados

        // Carrega os financiamentos salvos anteriormente
        List<Financiamento> ListaDEfinanciamento = lerFinanciamentos(nomeDoArquivo);

        // Se o arquivo não existia, a lista estará vazia. Adiciona dados iniciais.
        if (ListaDEfinanciamento.isEmpty()) {
            System.out.println("Nenhum financiamento encontrado. Adicionando dados iniciais.");
            ListaDEfinanciamento.add(new Casa(200000, 30, 0.08, 220000, 50, 65));
            ListaDEfinanciamento.add(new Casa(300000, 25, 0.075, 380000, 39, 60));
            ListaDEfinanciamento.add(new Apartamento(150000, 20, 0.09, 155000, 20, 10));
            ListaDEfinanciamento.add(new Apartamento(250000, 35, 0.082, 275000, 15, 8));
            ListaDEfinanciamento.add(new Terreno(250000, 35, 0.082, 275000, "Comercial"));
        }

        // Solicita os dados de um novo financiamento ao usuário
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

        // Mostra a lista completa (dados antigos + o novo)
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

        // Salva a lista inteira e atualizada, sobrescrevendo o arquivo antigo
        salvarFinanciamentos(ListaDEfinanciamento, nomeDoArquivo);
    }

    // Salva a lista de objetos em um arquivo usando serialização
    public static void salvarFinanciamentos(List<Financiamento> listaFinanciamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaFinanciamentos);
            System.out.println("Dados serializados e salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao serializar os dados: " + e.getMessage());
        }
    }

    // Lê uma lista de objetos de um arquivo usando desserialização
    @SuppressWarnings("unchecked") // Suprime o aviso de cast não verificado, que é esperado aqui.
    public static List<Financiamento> lerFinanciamentos(String nomeArquivo) {
        List<Financiamento> financiamentosLidos = new ArrayList<>();
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            return financiamentosLidos; // Retorna lista vazia se o arquivo não existe
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            financiamentosLidos = (List<Financiamento>) ois.readObject();
            System.out.println("Dados desserializados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar os dados: " + e.getMessage());
        }
        return financiamentosLidos;
    }
}