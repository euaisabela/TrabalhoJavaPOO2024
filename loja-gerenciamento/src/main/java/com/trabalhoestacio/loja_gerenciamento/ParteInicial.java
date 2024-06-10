package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParteInicial extends JFrame {

    public ParteInicial() {
        super("Login do Sistema");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250); // Aumentei a altura para acomodar a imagem
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Painel para o logotipo e os campos de login
        JPanel loginPanel = new JPanel(new GridBagLayout());

        // Configuração do GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Adiciona um espaço vertical extra

        // Adicionando a imagem como logotipo no topo e centralizado
        //ImageIcon logoIcon = new ImageIcon("/minhasimagens/Logo.jpg"); // teste 1
        ImageIcon logoIcon = new ImageIcon("loja-gerenciamento/src/main/java/minhasimagens/Logo.jpg");
        JLabel logoLabel = new JLabel(logoIcon);
        loginPanel.add(logoLabel, gbc);

        // Ajuste dos campos de texto
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0); // Adiciona um espaçamento superior
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel usernameLabel = new JLabel("Usuário:");
        loginPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15); // Defina um tamanho preferido para o campo de texto
        gbc.gridy++;
        loginPanel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Senha:");
        gbc.gridy++;
        loginPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15); // Defina um tamanho preferido para o campo de texto
        gbc.gridy++;
        loginPanel.add(passwordField, gbc);

        // Adicionando o painel de login ao painel principal
        mainPanel.add(loginPanel, BorderLayout.CENTER);

        // Botão de login
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("antonio") && password.equals("123")) {
                    dispose();
                    Loja loja = new Loja();
                    new ParteInicial2(loja).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ParteInicial.this, "Usuário ou senha incorretos. Tente novamente.");
                }
            }
        });
        buttonPanel.add(loginButton);

        // Adicionando o painel de botões ao painel principal
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ParteInicial parteInicial = new ParteInicial();
                parteInicial.setVisible(true);
            }
        });
    }
}
