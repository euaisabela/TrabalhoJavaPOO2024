package com.trabalhoestacio.loja_gerenciamento;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParteInicial2 extends JFrame {

   

    public ParteInicial2(Loja loja) {
        super("Gerenciamento da Loja");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Aumentando o tamanho da janela
        setLocationRelativeTo(null); // Centralizando a janela na tela

        // Define o gradiente de cor marrom claro
        Color startColor = new Color(216, 183, 151);
        Color endColor = new Color(186, 151, 116);

        // Define o botão com estilo de gradiente
        JButtonStyle.setGradientButtonStyle(startColor, endColor);

        // Painel principal com BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Painel para o cabeçalho com imagem
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);

        // Adicionando a imagem de cabeçalho
        //ImageIcon headerIcon = new ImageIcon("src/main/java/minhasimagens/headervintage.png"); teste
        ImageIcon headerIcon = new ImageIcon("loja-gerenciamento/src/main/java/minhasimagens/headervintage.png");
        JLabel headerLabel = new JLabel(headerIcon);
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralizar a imagem
      
        // Adicionando a frase de boas-vindas
        JLabel welcomeLabel = new JLabel("Bem-vindo ao Sistema de Gerenciamento da Loja");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralizar o texto

        headerPanel.add(headerLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre a imagem e a frase
        headerPanel.add(welcomeLabel);

        // Painel para os botões no centro
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton cadastrarProdutoButton = new JButton("Cadastrar Produto");
        JButton excluirProdutoButton = new JButton("Excluir Produto");
        JButton alterarProdutoButton = new JButton("Alterar Produto");
        JButton adicionarClienteButton = new JButton("Adicionar Cliente");
        JButton excluirClienteButton = new JButton("Excluir Cliente");
        JButton verProdutosButton = new JButton("Ver Produtos em Estoque");
        JButton criarPedidoButton = new JButton("Criar Pedido"); // Novo botão
        JButton verPedidosButton = new JButton("Ver Pedidos"); // Botão para ver pedidos

        // Define o estilo do botão
        JButtonStyle.setButtonStyle(cadastrarProdutoButton);
        JButtonStyle.setButtonStyle(excluirProdutoButton);
        JButtonStyle.setButtonStyle(adicionarClienteButton);
        JButtonStyle.setButtonStyle(excluirClienteButton);
        JButtonStyle.setButtonStyle(verProdutosButton);
        JButtonStyle.setButtonStyle(criarPedidoButton);
        JButtonStyle.setButtonStyle(verPedidosButton);
        JButtonStyle.setButtonStyle(alterarProdutoButton);

        cadastrarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarProduto(loja).setVisible(true);
            }
        });

        excluirProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ExcluirProduto(loja).setVisible(true);
            }
        });

       alterarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AlterarProduto(loja).setVisible(true);
            }
        });

        adicionarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdicionarCliente(loja).setVisible(true);
            }
        });

        excluirClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ExcluirCliente(loja).setVisible(true);
            }
        });

        verProdutosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.util.List<Produto> produtosEmEstoque = loja.listarProdutosEmEstoque();
                StringBuilder produtosText = new StringBuilder();
                for (Produto produto : produtosEmEstoque) {
                    produtosText.append("Nome: ").append(produto.getNome()).append(", ");
                    produtosText.append("Preço: ").append(produto.getPreco()).append(", ");
                    produtosText.append("Quantidade em Estoque: ").append(produto.getQuantidadeEmEstoque()).append("\n");
                }
                JOptionPane.showMessageDialog(ParteInicial2.this, produtosText.toString());
            }
        });

        criarPedidoButton.addActionListener(new ActionListener() { // Ação para o novo botão
            public void actionPerformed(ActionEvent e) {
                new CriarPedido(loja).setVisible(true); // Abre a janela de criação de pedidos
            }
        });

        verPedidosButton.addActionListener(new ActionListener() { // Ação para o novo botão
            public void actionPerformed(ActionEvent e) {
                new VerPedido(loja).setVisible(true); // Abre a janela de visualização de pedidos
            }
        });

        buttonPanel.add(cadastrarProdutoButton, gbc);
        gbc.gridy++;
        buttonPanel.add(excluirProdutoButton, gbc);
        gbc.gridy++;
        buttonPanel.add(alterarProdutoButton, gbc);
        gbc.gridy++;
        buttonPanel.add(adicionarClienteButton, gbc);
        gbc.gridy++;
        buttonPanel.add(excluirClienteButton, gbc);
        gbc.gridy++;
        buttonPanel.add(verProdutosButton, gbc);
        gbc.gridy++;
        buttonPanel.add(criarPedidoButton, gbc); // Adiciona o novo botão
        gbc.gridy++;
        buttonPanel.add(verPedidosButton, gbc); // Adiciona o novo botão

        // Adicionando painéis ao painel principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ParteInicial2 parteInicial2 = new ParteInicial2(new Loja());
                parteInicial2.setVisible(true);
            }
        });
    }
}

class JButtonStyle {
    public static void setButtonStyle(JButton button) {
        button.setUI(new BasicButtonUI());
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        button.setForeground(Color.WHITE);
    }

    public static void setGradientButtonStyle(Color startColor, Color endColor) {
        UIManager.put("Button.background", new ColorUIResource(startColor));
        UIManager.put("Button[MouseOver].background", new ColorUIResource(endColor));
        UIManager.put("Button[Pressed].background", new ColorUIResource(endColor));
    }
}
