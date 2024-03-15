package Ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n1. Cadastrar produto");
            System.out.println("2. Selecionar todos os produtos");
            System.out.println("3. Quantidade de produtos por segmento");
            System.out.println("4. Alterar dados do produto");
            System.out.println("5. Remover produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(produtos, scanner);
                    break;
                case 2:
                    selecionarTodosProdutos(produtos);
                    break;
                case 3:
                    quantidadeProdutosPorSegmento(produtos);
                    break;
                case 4:
                    alterarDadosProduto(produtos, scanner);
                    break;
                case 5:
                    removerProduto(produtos, scanner);
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }

    private static void cadastrarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o segmento do produto: ");
        String segmento = scanner.nextLine();

        Produto novoProduto = new Produto(nome, segmento);
        if (!produtos.contains(novoProduto)) {
            produtos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Este produto já existe. Não é possível cadastrar produtos iguais.");
        }
    }

    private static void selecionarTodosProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    // Adicione este método à classe GerenciadorProdutos
    private static void quantidadeProdutosPorSegmento(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Quantidade de produtos por segmento:");

            HashMap<String, Integer> contagemPorSegmento = new HashMap<>();

            for (Produto produto : produtos) {
                String segmento = produto.getSegmento();

                contagemPorSegmento.put(segmento, contagemPorSegmento.getOrDefault(segmento, 0) + 1);
            }

            for (String segmento : contagemPorSegmento.keySet()) {
                System.out.println(segmento + ": " + contagemPorSegmento.get(segmento));
            }
        }
    }


    private static void alterarDadosProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.print("Digite o nome do produto que deseja alterar: ");
        String nomeProduto = scanner.nextLine();

        Produto produtoParaAlterar = encontrarProdutoPorNome(produtos, nomeProduto);

        if (produtoParaAlterar != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.nextLine();

            System.out.print("Digite o novo segmento do produto: ");
            String novoSegmento = scanner.nextLine();

            produtoParaAlterar.setNome(novoNome);
            produtoParaAlterar.setSegmento(novoSegmento);

            System.out.println("Dados do produto alterados com sucesso!");
        } else {
            System.out.println("Produto não encontrado. Não é possível alterar.");
        }
    }

    private static void removerProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.print("Digite o nome do produto que deseja remover: ");
        String nomeProduto = scanner.nextLine();

        Produto produtoParaRemover = encontrarProdutoPorNome(produtos, nomeProduto);

        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado. Não é possível remover.");
        }
    }

    private static Produto encontrarProdutoPorNome(ArrayList<Produto> produtos, String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }
}
