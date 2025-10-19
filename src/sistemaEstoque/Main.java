package sistemaEstoque;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    private static Estoque estoque = new Estoque();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        scanner.useLocale(Locale.US);

        boolean executando = true;

        while (executando) {
            exibirMenu();
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        estoque.listarProdutos();
                        break;
                    case 3:
                        removerProduto();
                        break;
                    case 4:
                        executando = false;
                        System.out.println("Desligando sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nSISTEMA CADASTRO DE PRODUTOS");
        System.out.println("1. Cadastrar novo produto");
        System.out.println("2. Listar produtos");
        System.out.println("3. Remover produto (por ID)");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarProduto() {
        System.out.println("\nCadastro de Produto");
        try {
            System.out.print("Insira o ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Insira o Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Insira o Preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Insira a Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Produto perecível? (s/n): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {

                System.out.print("Digite a Data de Validade (AAAA-MM-DD): ");
                String dataStr = scanner.nextLine();
                LocalDate dataValidade = LocalDate.parse(dataStr);

                ProdutoPerecivel p = new ProdutoPerecivel(id, nome, preco, quantidade, dataValidade);
                estoque.adicionarProduto(p);
            }
            else{
                Produto p = new Produto(id, nome, preco, quantidade);
                estoque.adicionarProduto(p);
            }
        }
        catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
            System.out.println("Por favor, verifique os dados e tente novamente.");
            if(scanner.hasNextLine()) scanner.nextLine();
        }
    }

    private static void removerProduto() {
        try {
            System.out.print("\nDigite o ID do produto a ser removido: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            estoque.removerProduto(id);
        } catch (InputMismatchException e) {
            System.out.println("Erro: O ID deve ser um número.");
            scanner.nextLine();
        }
    }
}