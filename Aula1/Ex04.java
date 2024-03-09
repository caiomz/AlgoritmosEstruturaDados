/**
 * Este projeto utiliza uma fila (Queue) para gerenciar os atendimentos em ordem de chegada.
 * A escolha da fila é apropriada para lidar com a ordem de chegada, pois os elementos são
 * processados na ordem em que foram inseridos (FIFO - First In, First Out).
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Queue<String> filaAtendimento = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar atendimento");
            System.out.println("2 - Remover atendimento");
            System.out.println("3 - Finalizar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAtendimento(filaAtendimento, scanner);
                    break;
                case 2:
                    removerAtendimento(filaAtendimento);
                    break;
                case 3:
                    System.out.println("Sistema de atendimento encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void cadastrarAtendimento(Queue<String> filaAtendimento, Scanner scanner) {
        System.out.println("Digite o nome da pessoa para atendimento:");
        String nome = scanner.next();
        filaAtendimento.add(nome);
        System.out.println("Atendimento cadastrado com sucesso.");
    }

    private static void removerAtendimento(Queue<String> filaAtendimento) {
        if (!filaAtendimento.isEmpty()) {
            String pessoaAtendida = filaAtendimento.poll();
            System.out.println("Atendimento removido: " + pessoaAtendida);
        } else {
            System.out.println("Não há atendimentos na fila.");
        }
    }
}
