import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GerenciadorTarefas {
    private Queue<String> filaTarefas;
    private Scanner teclado;

    public GerenciadorTarefas() {
        this.filaTarefas = new LinkedList<>();
        this.teclado = new Scanner(System.in);
    }

    public void adicionarTarefa(String tarefa) {
        filaTarefas.offer(tarefa);
        System.out.println("Tarefa adicionada: " + tarefa);
    }

    public void concluirTarefa() {
        if (!filaTarefas.isEmpty()) {
            String tarefaConcluida = filaTarefas.poll();
            System.out.println("Tarefa concluída: " + tarefaConcluida);
        } else {
            System.out.println("Não há tarefas a serem concluídas.");
        }
    }

    public String getProximaTarefa() {
        if (!filaTarefas.isEmpty()) {
            return filaTarefas.peek();
        } else {
            return "Não há tarefas pendentes.";
        }
    }

    public void modoInterativo() {
        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Concluir Próxima Tarefa");
            System.out.println("3. Visualizar Próxima Tarefa");
            System.out.println("4. Sair");

            try {
                int escolha = teclado.nextInt();
                teclado.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.print("Digite a tarefa a ser adicionada: ");
                        String tarefaAdicionar = teclado.nextLine();
                        adicionarTarefa(tarefaAdicionar);
                        break;
                    case 2:
                        concluirTarefa();
                        break;
                    case 3:
                        System.out.println("Próxima Tarefa: " + getProximaTarefa());
                        break;
                    case 4:
                        executando = false;
                        System.out.println("Saindo do programa. Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao processar a entrada. Por favor, tente novamente.");
                teclado.nextLine();
            }
        }
        teclado.close();
    }

    public static void main(String[] args) {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.modoInterativo();
    }
}
