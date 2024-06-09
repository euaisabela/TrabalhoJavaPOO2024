package com.trabalhoestacio.loja_gerenciamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // os Getters e setters ficam aqui

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // PARA QUE ASSIM QUE UM CLIENTE SEJA ADICIONADO APARECA
    // UM NOME LEGÍVEL PARA O MEU CLIENTE E USUARIO
    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }

    // VAI VALIDAR O CPF DO CLIENTE QUE DIGITAR DA FORMA CERTA
    public boolean validarCPF(String cpf) {
        // Expressão regular para verificar se o CPF está no formato correto
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        return cpf.matches(regex);
    }

    public boolean validarTelefone(String telefone) {
        // Expressão regular para verificar se o telefone está no formato correto
        String regex = "\\d{2}\\d{5}-\\d{4}";
        return telefone.matches(regex);
    }
}
