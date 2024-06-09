package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarCliente extends JFrame {

    private Loja loja;

    public AdicionarCliente(Loja loja) {
        super("Adicionar Cliente");
        this.loja = loja;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel cpfLabel = new JLabel("CPF: 000.000.000-00");
        JTextField cpfField = new JTextField();
        JLabel telefoneLabel = new JLabel("Telefone ex:(1190555-0505)");
        JTextField telefoneField = new JTextField();

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String telefone = telefoneField.getText();

                if (loja.clienteJaCadastrado(cpf)) {
                    JOptionPane.showMessageDialog(AdicionarCliente.this, "CPF já cadastrado. O cliente não foi adicionado.");
                } else {
                    Cliente novoCliente = new Cliente(nome, cpf, telefone);
                    if (novoCliente.validarCPF(cpf) && novoCliente.validarTelefone(telefone)) {
                        loja.adicionarCliente(novoCliente);
                        JOptionPane.showMessageDialog(AdicionarCliente.this, "Cliente cadastrado com sucesso!");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(AdicionarCliente.this, "CPF ou telefone inválido. O cliente não foi adicionado.");
                    }
                }
            }
        });

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(telefoneLabel);
        panel.add(telefoneField);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(addButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
