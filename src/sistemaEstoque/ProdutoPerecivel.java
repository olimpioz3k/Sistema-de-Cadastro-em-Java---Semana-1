package sistemaEstoque;
import  java.time.LocalDate;

public class ProdutoPerecivel extends Produto {

    private LocalDate dataValidade;

    public ProdutoPerecivel(int id, String nome, double preco, int quantidade, LocalDate dataValidade) {
        super(id, nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade(){
        return dataValidade;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Data de validade: " + this.dataValidade);
    }
}
