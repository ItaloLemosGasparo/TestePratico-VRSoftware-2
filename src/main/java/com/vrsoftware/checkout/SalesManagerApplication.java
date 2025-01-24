package com.vrsoftware.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class SalesManagerApplication {

    public static void main(String[] args) {
        new Thread(() -> SpringApplication.run(SalesManagerApplication.class, args)).start();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sales Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 80);
            frame.setLayout(new FlowLayout());

            JButton btnClientes = new JButton("Clientes");
            btnClientes.addActionListener(e -> { openClientesScreen(); });

            JButton btnProdutos = new JButton("Produtos");
            btnProdutos.addActionListener(e -> { openProdutosScreen(); });

            JButton btnVendas = new JButton("Vendas");
            btnVendas.addActionListener(e -> { openVendasScreen(); });

            // Adicionando os botões na tela
            frame.add(btnClientes);
            frame.add(btnProdutos);
            frame.add(btnVendas);

            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        });
    }

    private static void openClientesScreen() {
        JOptionPane.showMessageDialog(null, "Tela de Clientes será aberta.");
    }

    private static void openProdutosScreen() {
        JOptionPane.showMessageDialog(null, "Tela de Produtos será aberta.");
    }

    private static void openVendasScreen() {
        JOptionPane.showMessageDialog(null, "Tela de Vendas será aberta.");
    }
}
