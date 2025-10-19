package sistemaEstoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> listaProdutos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto '" + produto.getNome() + "' adicionado");
    }

    public void removerProduto(int id) {
        boolean removeu = listaProdutos.removeIf(produto -> produto.getId() == id);

        if (removeu) {
            System.out.println("Produto com ID " + id + " removido.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        System.out.println("\nLISTA DE PRODUTOS EM ESTOQUE");

        for (Produto produto : listaProdutos) {
            produto.exibirDetalhes();
        }
    }
}