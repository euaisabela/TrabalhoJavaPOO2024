package com.trabalhoestacio.loja_gerenciamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Produto> produtos;

    private LocalDate dataPedido;

    @OneToOne
    private int Quantidade;

    public Pedido() {
    }

    public int getQuantidade(){
        return Quantidade;
    }

    public void setQuantidade(int quantidade){
        this.Quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
}
