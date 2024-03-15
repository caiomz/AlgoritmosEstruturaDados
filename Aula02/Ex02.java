package Ex02;
import java.util.Scanner;
import java.util.Vector;

public class Ex02 {

    public static void main(String[] args) {
        Vector<String> registros = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n1. Cadastrar");
            System.out.println("2. Selecionar todos os registros");
            System.out.println("3. Pesquisar por termo");
            System.out.println("4. Alterar dados");
            System.out.println("5. Remover registro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarRegistro(registros, scanner);
                    break;
                case 2:
                    selecionarTodosRegistros(registros);
                    break;
                case 3:
                    pesquisarPorTermo(registros, scanner);
                    break;
                case 4:
                    alterarDados(registros, scanner);
                    break;
                case 5:
                    removerRegistro(registros, scanner);
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }

    private static void cadastrarRegistro(Vector<String> registros, Scanner scanner) {
        System.out.print("Digite o novo registro: ");
        String novoRegistro = scanner.nextLine();

        if (!registros.contains(novoRegistro)) {
            registros.add(novoRegistro);
            System.out.println("Registro cadastrado com sucesso!");
        } else {
            System.out.println("Este registro já existe. Não é possível cadastrar registros iguais.");
        }
    }

    private static void selecionarTodosRegistros(Vector<String> registros) {
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
        } else {
            System.out.println("\nRegistros:\n");
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }

    private static void pesquisarPorTermo(Vector<String> registros, Scanner scanner) {
        System.out.print("Digite o termo de pesquisa: ");
        String termo = scanner.nextLine().toLowerCase();

        System.out.println("Registros encontrados:");
        for (String registro : registros) {
            if (registro.toLowerCase().contains(termo)) {
                System.out.println(registro);
            }
        }
    }

    private static void alterarDados(Vector<String> registros, Scanner scanner) {
        System.out.print("Digite o registro que deseja alterar: ");
        String registroAntigo = scanner.nextLine();

        if (registros.contains(registroAntigo)) {
            System.out.print("Digite o novo valor para o registro: ");
            String novoRegistro = scanner.nextLine();

            registros.set(registros.indexOf(registroAntigo), novoRegistro);
            System.out.println("Registro alterado com sucesso!");
        } else {
            System.out.println("Registro não encontrado. Não é possível alterar.");
        }
    }

    private static void removerRegistro(Vector<String> registros, Scanner scanner) {
        System.out.print("Digite o registro que deseja remover: ");
        String registroRemover = scanner.nextLine();

        if (registros.contains(registroRemover)) {
            registros.remove(registroRemover);
            System.out.println("Registro removido com sucesso!");
        } else {
            System.out.println("Registro não encontrado. Não é possível remover.");
        }
    }
}
