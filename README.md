# TrabalhoJavaPOO2024
Trabalho Faculdade Estácio Programação Orientada a Objetos em Java 
# Loja de Gerenciamento

Este é um projeto de gerenciamento de loja desenvolvido em Java. O sistema permite cadastrar, excluir e visualizar produtos e clientes, além de criar e visualizar pedidos.

## Funcionalidades

- **Cadastrar Produto**: Adiciona um novo produto ao estoque.
- **Excluir Produto**: Remove um produto do estoque.
- **Adicionar Cliente**: Cadastra um novo cliente.
- **Excluir Cliente**: Remove um cliente do sistema.
- **Ver Produtos em Estoque**: Exibe a lista de produtos disponíveis no estoque.
- **Criar Pedido**: Cria um novo pedido para um cliente, associando produtos ao pedido.
- **Ver Pedidos**: Exibe a lista de pedidos criados.

## Imagem da Frente
![image](https://github.com/euaisabela/TrabalhoJavaPOO2024/assets/129691258/c1092975-5efd-4f8a-a01b-cdd694836d8c)




## Estrutura do Projeto

O projeto é organizado da seguinte forma:

- `src/main/java/com/trabalhoestacio/loja_gerenciamento/`
  - `ParteInicial2.java`: Classe principal que inicializa a interface de gerenciamento.
  - `CadastrarProduto.java`: Classe responsável pela interface de cadastro de produtos.
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

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/loja-gerenciamento.git
