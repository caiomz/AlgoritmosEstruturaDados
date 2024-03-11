import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Listagem");
            System.out.println("3 - Pesquisa");
            System.out.println("4 - Alterar");
            System.out.println("5 - Remover");
            System.out.println("6 - Finalizar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(produtos, scanner);
                    break;
                case 2:
                    listarProdutos(produtos);
                    break;
                case 3:
                    pesquisarProdutos(produtos, scanner);
                    break;
                case 4:
                    alterarProduto(produtos, scanner);
                    break;
                case 5:
                    removerProduto(produtos, scanner);
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void cadastrarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.next();

        System.out.println("Digite o valor do produto:");
        double valor = scanner.nextDouble();

        Produto novoProduto = new Produto(nome, valor);
        produtos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void listarProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static void pesquisarProdutos(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("Digite o termo de pesquisa:");
        String termo = scanner.next().toLowerCase();

        ArrayList<Produto> resultados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(termo)) {
                resultados.add(produto);
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o termo informado.");
        } else {
            System.out.println("Produtos encontrados:");
            for (Produto resultado : resultados) {
                System.out.println(resultado);
            }
        }
    }

    private static void alterarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("Digite o nome do produto a ser alterado:");
        String nomeProduto = scanner.next();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                System.out.println("Digite o novo nome do produto:");
                String novoNome = scanner.next();

                System.out.println("Digite o novo valor do produto:");
                double novoValor = scanner.nextDouble();

                produto.setNome(novoNome);
                produto.setValor(novoValor);

                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("Digite o nome do produto a ser removido:");
        String nomeProduto = scanner.next();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}

class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nome do produto: " + nome + ", Valor: R$" + valor;
    }
}
