package Ex04;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {
        LinkedList<No> lista = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n1. Cadastrar nome");
            System.out.println("2. Selecionar todos os nomes");
            System.out.println("3. Alterar nome");
            System.out.println("4. Remover nome");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNome(lista, scanner);
                    break;
                case 2:
                    selecionarTodosNomes(lista);
                    break;
                case 3:
                    alterarNome(lista, scanner);
                    break;
                case 4:
                    removerNome(lista, scanner);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    private static void cadastrarNome(LinkedList<No> lista, Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        No novoNo = new No(nome);
        lista.add(novoNo);
        System.out.println("Nome cadastrado com sucesso!");
    }

    private static void selecionarTodosNomes(LinkedList<No> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum nome cadastrado.");
        } else {
            System.out.println("Nomes:");
            for (No no : lista) {
                System.out.println(no.getNome());
            }
        }
    }

    private static void alterarNome(LinkedList<No> lista, Scanner scanner) {
        System.out.print("Digite o nome que deseja alterar: ");
        String nomeAntigo = scanner.nextLine();

        No noParaAlterar = encontrarNoPorNome(lista, nomeAntigo);

        if (noParaAlterar != null) {
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            noParaAlterar.setNome(novoNome);

            System.out.println("Nome alterado com sucesso!");
        } else {
            System.out.println("Nome não encontrado. Não é possível alterar.");
        }
    }

    private static void removerNome(LinkedList<No> lista, Scanner scanner) {
        System.out.print("Digite o nome que deseja remover: ");
        String nomeRemover = scanner.nextLine();

        No noParaRemover = encontrarNoPorNome(lista, nomeRemover);

        if (noParaRemover != null) {
            lista.remove(noParaRemover);
            System.out.println("Nome removido com sucesso!");
        } else {
            System.out.println("Nome não encontrado. Não é possível remover.");
        }
    }

    private static No encontrarNoPorNome(LinkedList<No> lista, String nome) {
        for (No no : lista) {
            if (no.getNome().equals(nome)) {
                return no;
            }
        }
        return null;
    }
}

