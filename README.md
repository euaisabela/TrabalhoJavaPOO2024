# TrabalhoJavaPOO2024
Trabalho Faculdade Estácio 
Matéria: Programação Orientada a Objetos em Java.
Professor RAPHAAEL JESUS.
# Loja de Gerenciamento

Este é um projeto de gerenciamento de loja desenvolvido em Java. O sistema permite cadastrar, excluir e visualizar produtos e clientes, além de criar e visualizar pedidos.

## Funcionalidades

- **Cadastrar Produto**: Adiciona um novo produto ao estoque.
- **Excluir Produto**: Remove um produto do estoque.
- **Alterar Produto** : Pode alterar o preço ou a quantidade do produto ( escolhido).
- **Adicionar Cliente**: Cadastra um novo cliente.
- **Excluir Cliente**: Remove um cliente do sistema.
- **Ver Produtos em Estoque**: Exibe a lista de produtos disponíveis no estoque.
- **Criar Pedido**: Cria um novo pedido para um cliente, associando produtos ao pedido.
- **Ver Pedidos**: Exibe a lista de pedidos criados.

## Algumas Imagens do Projeto 

![image](https://github.com/euaisabela/TrabalhoJavaPOO2024/assets/129691258/cec1fdd1-d1d1-4887-8d41-049cfd23e3ef)

![image](https://github.com/euaisabela/TrabalhoJavaPOO2024/assets/129691258/d7318a85-d68e-4b6e-bf5a-560ca650d433)







## Estrutura do Projeto

O projeto é organizado da seguinte forma:

- `src/main/java/com/trabalhoestacio/loja_gerenciamento/`
  - `ParteInicial2.java`: Classe principal que inicializa a interface de gerenciamento.
  - `CadastrarProduto.java`: Classe responsável pela interface de cadastro de produtos.
  - `AlterarProduto.java`: Classe responsável pela interface de edição de produtos( quantidade e preco).
  - `CriarPedido.java`: Classe responsável pela interface de criação de pedidos.
  - `VerPedido.java`: Classe responsável pela interface de visualização de pedidos.
  - `Loja.java`: Classe que gerencia a lógica de negócios, incluindo produtos, clientes e pedidos.
  - `Produto.java`: Classe que representa um produto.
  - `Cliente.java`: Classe que representa um cliente.
  - `Pedido.java`: Classe que representa um pedido.

## Tecnologias Utilizadas

- Java
- Swing (para a interface gráfica)
- JPA/Hibernate (para a persistência de dados)


# Utilizei o Spring Initializr para a criação do projeto Spring Boot
     - Abaixo o print :

![0b91361d-ca80-4494-a25e-227f6416d10f](https://github.com/euaisabela/TrabalhoJavaPOO2024/assets/129691258/ceb0cbac-91f6-45c2-8989-d531cecd033e)


## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/loja-gerenciamento.git
