package until;

import java.util.Scanner;

public class interfaceUsuario {

    private Scanner scanner = new Scanner(System.in);


    public int pedirValorimovel() {

        while (true) {
            System.out.print("Digite o valor do imóvel: ");
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();

                if (valor > 0 && valor < 999999999) {
                    return valor;
                } else {
                    System.out.println("ERRO: O valor está fora do intervalo permitido. Tente novamente.");
                }
            } else {
                System.out.println("ERRO: Entrada inválida. Por favor, digite somente números.");
                scanner.next();
            }

        }

    }

    public int pedirPrazoFinancimento() {
        while (true) {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            if (scanner.hasNextInt()) {
                int prazo = scanner.nextInt();

                if (prazo > 0 && prazo <= 30) {
                    return prazo;
                } else {
                    System.out.println("ERRO: Prazo fora do permitido (deve ser entre 1 e 30 anos).");
                }
            } else {
                System.out.println("ERRO: Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }

        }
    }

    public double pedirtaxaJuros() {
        while (true) {
            System.out.print("Digite a taxa de juros anual (ex: 9.5): ");

            if (scanner.hasNextDouble()) {
                double taxa = scanner.nextDouble();

                if (taxa > 0 && taxa <= 11.49) {
                    return taxa;
                } else {
                    System.out.println("ERRO: A taxa deve ser maior que 0 e no máximo 11.49.");
                }
            } else {
                System.out.println("ERRO: Entrada inválida. Por favor, digite um número (use virgula para decimais).");
                scanner.next();
            }

        }
    }

    public Boolean zonaResidecial() {
        System.out.print("é residencial?");
        return scanner.nextBoolean();
    }

    public Boolean zonaComercial() {
        System.out.print("È coomercial?");
        return scanner.nextBoolean();
    }
}
