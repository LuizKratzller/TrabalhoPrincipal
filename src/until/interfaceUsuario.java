package until;

import java.util.Scanner;

// Classe para interagir com o usuário
public class interfaceUsuario {

    public Scanner scanner = new Scanner(System.in);


    // Solicita o tipo de imóvel ao usuário
    public String tipoImovel() {
        while (true) {
            try {
                System.out.print("Escolha o tipo de imóvel (Casa, Apartamento ou Terreno): ");
                String tipo = scanner.nextLine();
                if (tipo.equalsIgnoreCase("Casa") || tipo.equalsIgnoreCase("Apartamento") || tipo.equalsIgnoreCase("Terreno")) {
                    return tipo;
                } else {
                    System.out.println("ERRO: Tipo inválido. Digite 'Casa', 'Apartamento' ou 'Terreno'.");
                }
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    // Solicita o valor do imóvel ao usuário
    public int pedirValorimovel() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ex: 250000: ");
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
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }

    // Solicita o prazo do financiamento em anos
    public int pedirPrazoFinancimento() {
        while (true) {
            try {
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
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }

    // Solicita a taxa de juros anual
    public double pedirtaxaJuros() {
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual (ex: 9,5): ");
                if (scanner.hasNextDouble()) {
                    double taxa = scanner.nextDouble();
                    if (taxa > 0 && taxa <= 12) {
                        return taxa;
                    } else {
                        System.out.println("ERRO: A taxa deve ser maior que 0 e no máximo 12.");
                    }
                } else {
                    System.out.println("ERRO: Entrada inválida. Por favor, digite apenas números.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }

    // Pergunta se a zona é residencial ou comercial
    public String zonaTerreno() {
        while (true) {
            try {
                System.out.print("Digite a zona do terreno (Residencial ou Comercial): ");
                String zona = scanner.nextLine();
                if (zona.equalsIgnoreCase("Residencial") || zona.equalsIgnoreCase("Comercial")) {
                    return zona;
                } else {
                    System.out.println("ERRO: Zona inválida. Digite 'Residencial' ou 'Comercial'.");
                }
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    // Solicita a área construída ao usuário
    public double pedirAreaConstruida() {
        while (true) {
            try {
                System.out.print("Digite a área construída: ");
                if (scanner.hasNextDouble()) {
                    double area = scanner.nextDouble();
                    if (area > 0) {
                        return area;
                    } else {
                        System.out.println("ERRO: A área deve ser maior que 0.");
                    }
                } else {
                    System.out.println("ERRO: Entrada inválida. Digite um número.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }

    // Solicita a área do terreno ao usuário
    public double pedirAreaTerreno() {
        while (true) {
            try {
                System.out.print("Digite a área do terreno: ");
                if (scanner.hasNextDouble()) {
                    double area = scanner.nextDouble();
                    if (area > 0) {
                        return area;
                    } else {
                        System.out.println("ERRO: A área deve ser maior que 0.");
                    }
                } else {
                    System.out.println("ERRO: Entrada inválida. Digite um número.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }

    // Solicita o número de vagas ao usuário
    public int pedirNumeroVagas() {
        while (true) {
            try {
                System.out.print("Digite o número de vagas: ");
                if (scanner.hasNextInt()) {
                    int vagas = scanner.nextInt();
                    if (vagas >= 0) {
                        return vagas;
                    } else {
                        System.out.println("ERRO: O número de vagas não pode ser negativo.");
                    }
                } else {
                    System.out.println("ERRO: Entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }

    // Solicita o número do andar ao usuário
    public int pedirNumeroAndar() {
        while (true) {
            try {
                System.out.print("Digite o número do andar: ");
                if (scanner.hasNextInt()) {
                    int andar = scanner.nextInt();
                    if (andar >= 0) {
                        return andar;
                    } else {
                        System.out.println("ERRO: O número do andar não pode ser negativo.");
                    }
                } else {
                    System.out.println("ERRO: Entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("ERRO: Ocorreu um erro inesperado. Tente novamente.");
                scanner.next();
            }
        }
    }
}
