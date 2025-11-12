package controller;

import interfaces.ButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SwingButtonFactory implements ButtonFactory {
    @Override
    public JButton createButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.addActionListener(listener);
        button.setFocusPainted(false);
        button.setBackground(Color.GRAY);
        return button;
    }
}
