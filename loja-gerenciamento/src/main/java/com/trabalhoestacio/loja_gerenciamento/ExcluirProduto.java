package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExcluirProduto extends JFrame {

    private Loja loja;

    public ExcluirProduto(Loja loja) {
        super("Excluir Produto");
        this.loja = loja;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300); // Ajustando o tamanho da janela
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Adicionando uma frase no topo da janela
        JLabel messageLabel = new JLabel("Selecione o produto abaixo");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(productList);

        JButton deleteButton = new JButton("Excluir");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = productList.getSelectedValue();
                if (selectedProduct != null) {
                    String[] parts = selectedProduct.split(" - ");
                    String productName = parts[0]; // Obtendo o nome do produto
                    Produto produto = loja.getProdutoPorNome(productName);
                    if (produto != null) {
                        loja.excluirProduto(produto);
                        JOptionPane.showMessageDialog(ExcluirProduto.this, "Produto excluído com sucesso!");
                        // Atualizando a lista de produtos após a exclusão
                        atualizarListaProdutos(listModel);
                    } else {
                        JOptionPane.showMessageDialog(ExcluirProduto.this, "Produto não encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(ExcluirProduto.this, "Selecione um produto para excluir.");
                }
            }
        });

        panel.add(messageLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setVisible(true);

        // Preenche a lista de produtos
        atualizarListaProdutos(listModel);
    }

    // Método para atualizar a lista de produtos na interface
    private void atualizarListaProdutos(DefaultListModel<String> listModel) {
        listModel.clear();
        List<Produto> produtos = loja.listarProdutosEmEstoque();
        for (Produto produto : produtos) {
            // Adicionando apenas o nome do produto na lista
            listModel.addElement(produto.getNome());
        }
    }
}
