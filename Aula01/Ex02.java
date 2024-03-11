import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[10];

        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos os nomes");
            System.out.println("3 - Alterar");
            System.out.println("4 - Remover");
            System.out.println("5 - Finalizar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNome(nomes, scanner);
                    break;
                case 2:
                    listarNomes(nomes);
                    break;
                case 3:
                    alterarNome(nomes, scanner);
                    break;
                case 4:
                    removerNome(nomes, scanner);
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarNome(String[] nomes, Scanner scanner) {
        System.out.println("Digite o nome a ser cadastrado:");
        String nome = scanner.next();

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] == null) {
                nomes[i] = nome;
                System.out.println("Nome cadastrado com sucesso.");
                break;
            }
        }
    }

    private static void listarNomes(String[] nomes) {
        System.out.println("Lista de nomes cadastrados:");
        for (String nome : nomes) {
            if (nome != null) {
                System.out.println(nome);
            }
        }
    }

    private static void alterarNome(String[] nomes, Scanner scanner) {
        System.out.println("Digite o nome a ser alterado:");
        String nomeAntigo = scanner.next();

        System.out.println("Digite o novo nome:");
        String novoNome = scanner.next();

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null && nomes[i].equals(nomeAntigo)) {
                nomes[i] = novoNome;
                System.out.println("Nome alterado com sucesso.");
                break;
            }
        }
    }

    private static void removerNome(String[] nomes, Scanner scanner) {
        System.out.println("Digite o nome a ser removido:");
        String nomeRemover = scanner.next();

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null && nomes[i].equals(nomeRemover)) {
                nomes[i] = null;
                System.out.println("Nome removido com sucesso.");
                break;
            }
        }
    }
}
