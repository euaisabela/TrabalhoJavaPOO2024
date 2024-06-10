package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarProduto extends JFrame {

    

    public CadastrarProduto(Loja loja) {
        super("Cadastrar Produto");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel priceLabel = new JLabel("Preço:");
        JTextField priceField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantidade em Estoque:");
        JTextField quantityField = new JTextField();

        JButton addButton = new JButton("Adicionar");
        addButton.setBackground(new Color(66, 135, 245));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                double preco = Double.parseDouble(priceField.getText());
                int quantidade = Integer.parseInt(quantityField.getText());

                Produto novoProduto = new Produto(nome, preco, quantidade);
                loja.adicionarProduto(novoProduto);

                JOptionPane.showMessageDialog(CadastrarProduto.this, "Produto cadastrado com sucesso!");
                dispose();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(quantityLabel);
        panel.add(quantityField);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(addButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
