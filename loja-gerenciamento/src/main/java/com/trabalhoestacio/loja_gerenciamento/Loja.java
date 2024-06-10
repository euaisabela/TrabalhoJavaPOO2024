package com.trabalhoestacio.loja_gerenciamento;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    public Loja() {
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void criarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Produto> listarProdutosEmEstoque() {
        return produtos;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public void adicionarProduto(Produto novoProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(novoProduto.getNome())) {
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + novoProduto.getQuantidadeEmEstoque());
                return;
            }
        }
        produtos.add(novoProduto);
    }

    public void excluirProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void alterarProduto(Produto produto, double preco, int quantidade) {
        produto.setPreco(preco);
        produto.setQuantidadeEmEstoque(quantidade);
    }

    public Produto getProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    public int getquantidade(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto.getQuantidadeEmEstoque();
            }
        }
        return 0;
    }

    public void adicionarCliente(Cliente cliente) {
        boolean cpfJaCadastrado = clientes.stream().anyMatch(c -> c.getCpf().equals(cliente.getCpf()));
        if (!cpfJaCadastrado) {
            if (cliente.validarCPF(cliente.getCpf()) && cliente.validarTelefone(cliente.getTelefone())) {
                clientes.add(cliente);
            } else {
                System.out.println("CPF ou telefone inválido. O cliente não foi adicionado.");
            }
        } else {
            System.out.println("CPF já cadastrado. O cliente não foi adicionado.");
        }
    }

    public void excluirCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public boolean clienteJaCadastrado(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
