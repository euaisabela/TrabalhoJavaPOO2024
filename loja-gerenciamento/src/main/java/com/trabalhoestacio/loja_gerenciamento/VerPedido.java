package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;

public class VerPedido extends JFrame {
    private Loja loja;

    public VerPedido(Loja loja) {
        super("Ver Pedidos");
        this.loja = loja;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea pedidosArea = new JTextArea();
        pedidosArea.setEditable(false);

        StringBuilder pedidosText = new StringBuilder();
        for (Pedido pedido : loja.listarPedidos()) {
            pedidosText.append("ID: ").append(pedido.getId()).append("\n")
                    .append("Cliente: ").append(pedido.getCliente().getCpf()).append("\n")
                    .append("Data: ").append(pedido.getDataPedido()).append("\n")
                    .append("Produtos: \n");

            for (Produto produto : pedido.getProdutos()) {
                pedidosText.append("  - ").append(produto.getNome()).append("\n");
            }

            pedidosText.append("\n");
        }

        pedidosArea.setText(pedidosText.toString());
        JScrollPane scrollPane = new JScrollPane(pedidosArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);

        setVisible(true);
    }
}
