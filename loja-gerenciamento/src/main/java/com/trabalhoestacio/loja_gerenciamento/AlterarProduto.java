package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AlterarProduto extends JFrame {

    private Loja loja;

    public AlterarProduto(Loja loja) {
        super("Alterar Produto");
        this.loja = loja;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300); // Ajustando o tamanho da janela
        setLocationRelativeTo(null);

        JLabel messageLabel = new JLabel("Selecione o produto abaixo e a quantidade específica");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(productList);
        JPanel panel = new JPanel(new BorderLayout());

        JButton altButton = new JButton("Alterar");
        altButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = productList.getSelectedValue();
                if (selectedProduct != null) {
                    String[] parts = selectedProduct.split(" - ");
                    String productName = parts[0]; // Obtendo o nome do produto
                    int price = Integer.parseInt(JOptionPane.showInputDialog(AlterarProduto.this, "Digite o novo preço:"));
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog(AlterarProduto.this, "Digite a nova quantidade:"));
                    Produto produto = loja.getProdutoPorNome(productName);
                    if (produto != null) {
                        loja.alterarProduto(produto, price, quantity);
                        JOptionPane.showMessageDialog(AlterarProduto.this, "Produto alterado com sucesso!");
                        // Atualizando a lista de produtos após a exclusão
                        atualizarListaProdutos(listModel);
                    } else {
                        JOptionPane.showMessageDialog(AlterarProduto.this, "Produto não encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(AlterarProduto.this, "Selecione um produto para alterar.");
                }
            }
        });

        panel.add(messageLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(altButton, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setVisible(true);

        // Preenche a lista de produtos
        atualizarListaProdutos(listModel);
    }

    private void atualizarListaProdutos(DefaultListModel<String> listModel) {
        listModel.clear();
        List<Produto> produtos = loja.listarProdutosEmEstoque();
        for (Produto produto : produtos) {
            // Adicionando apenas o nome do produto na lista
            listModel.addElement(produto.getNome());
        }
    }
}
