package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExcluirCliente extends JFrame {

    private Loja loja;

    public ExcluirCliente(Loja loja) {
        super("Excluir Cliente");
        this.loja = loja;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("CLIQUE NO CLIENTE QUE DESEJA EXCLUIR ABAIXO");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        DefaultListModel<Cliente> listModel = new DefaultListModel<>();
        JList<Cliente> clienteList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(clienteList);

        JButton deleteButton = new JButton("Excluir");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = clienteList.getSelectedValue();
                if (cliente != null) {
                    loja.excluirCliente(cliente);
                    JOptionPane.showMessageDialog(ExcluirCliente.this, "Cliente excluído com sucesso!");
                    listModel.removeElement(cliente);
                } else {
                    JOptionPane.showMessageDialog(ExcluirCliente.this, "Selecione um cliente para excluir.");
                }
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setVisible(true);

        // Preenche a lista de clientes
        List<Cliente> clientes = loja.listarClientes();
        for (Cliente cliente : clientes) {
            listModel.addElement(cliente);
        }
    }
}
