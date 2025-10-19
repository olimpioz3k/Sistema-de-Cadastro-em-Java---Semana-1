# Sistema Interativo de Cadastro de Produtos em Java

Este projeto é um sistema de console simples e interativo para gerenciar um estoque de produtos. O usuário pode cadastrar, listar e remover produtos através de um menu no terminal.

##  Pilares da POO Aplicados

O projeto foi construído para demonstrar os 4 pilares da Programação Orientada a Objetos:

1.  **Abstração**: A classe `Produto` é uma abstração de um produto do mundo real, contendo apenas os atributos essenciais para o sistema (`id`, `nome`, `preco`, `quantidade`).
2.  **Encapsulamento**: Os atributos da classe `Produto` são `private`. O acesso a eles é controlado publicamente através de métodos `getters` (para ler) e `setters` (para modificar).
3.  **Herança**: A classe `ProdutoPerecivel` herda (`extends`) da classe `Produto`. Ela reutiliza todo o código e atributos do `Produto` e adiciona sua própria característica (`dataValidade`).
4.  **Polimorfismo**: O método `exibirDetalhes()` é sobrescrito (`@Override`) na classe `ProdutoPerecivel`. A classe `Estoque`, ao listar os produtos, chama `produto.exibirDetalhes()` para cada item. O Java, em tempo de execução, decide qual versão do método deve chamar (a da classe `Produto` ou a da `ProdutoPerecivel`), exibindo a data de validade apenas quando necessário.

## Estrutura das Classes

-   `Produto.java`: A classe base (molde) para todos os produtos.
-   `ProdutoPerecivel.java`: A classe especializada que herda de `Produto`.
-   `Estoque.java`: A classe que gerencia a lista de produtos (adicionar, remover, listar).
-   `Main.java`: Contém o menu interativo (`while` loop), o `Scanner` para ler a entrada do usuário e a lógica (`switch`) para chamar as operações do estoque.

## Como Executar

1.  Clone o repositório.
2.  Abra o projeto em uma IDE Java (como IntelliJ IDEA).
3.  Execute o método `main` na classe `Main.java`.
4.  Interaja com o menu que aparecerá no console.