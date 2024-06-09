package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CriarPedido extends JFrame {
    private Loja loja;

    public CriarPedido(Loja loja) {
        super("Criar Pedido");
        this.loja = loja;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel cpfLabel = new JLabel("CPF do Cliente:");
        JTextField cpfField = new JTextField();
        JLabel quantidadeLabel = new JLabel("Quantidade de Produtos:");
        JTextField quantidadeField = new JTextField();

        JButton criarPedidoButton = new JButton("Criar Pedido");
        criarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());

                Cliente cliente = loja.listarClientes().stream()
                        .filter(c -> c.getCpf().equals(cpf))
                        .findFirst()
                        .orElse(null);

                if (cliente == null) {
                    JOptionPane.showMessageDialog(CriarPedido.this, "Cliente não encontrado.");
                    return;
                }

                List<Produto> produtosPedido = new ArrayList<>();
                for (int i = 0; i < quantidade; i++) {
                    Produto produto = loja.getProdutoPorNome(JOptionPane.showInputDialog("Nome do produto " + (i + 1) + ":"));
                    if (produto != null) {
                        produtosPedido.add(produto);
                    } else {
                        JOptionPane.showMessageDialog(CriarPedido.this, "Produto não encontrado.");
                        return;
                    }
                }

                Pedido pedido = new Pedido();
                pedido.setCliente(cliente);
                pedido.setProdutos(produtosPedido);
                pedido.setDataPedido(LocalDate.now());

                loja.criarPedido(pedido);

                JOptionPane.showMessageDialog(CriarPedido.this, "Pedido criado com sucesso!");
                dispose();
            }
        });

        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(quantidadeLabel);
        panel.add(quantidadeField);
        panel.add(criarPedidoButton);

        getContentPane().add(panel);

        setVisible(true);
    }
}
