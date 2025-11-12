package view;

import interfaces.ButtonFactory;
import interfaces.CalculatorController;
import interfaces.GuiFrame;
import interfaces.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CalculatorFrame extends JFrame implements GuiFrame {

    CalculatorPanel panel;
    private final JTextField display;
    private CalculatorController controller;

    public CalculatorFrame(ButtonFactory buttonFactory) {

        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // Поле отображения
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Панель кнопок

        panel = new CalculatorPanel(buttonFactory, new ButtonClickListener());
        add(panel, BorderLayout.CENTER);

//        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
//        String[] buttons = {
//                "7", "8", "9", "+",
//                "4", "5", "6", "-",
//                "1", "2", "3", "*",
//                "C", "0", "=", "/"
//        };
//
//        for (String text : buttons) {
//            JButton btn = new JButton(text);
//            btn.setFont(new Font("Arial", Font.PLAIN, 20));
//            btn.addActionListener(new ButtonClickListener());
//            panel.add(btn);
//        }
//
//        add(panel, BorderLayout.CENTER);
    }
    @Override
    public void displayResult(double value) {
        display.setText(String.valueOf(value));
    }

    @Override
    public void setController(CalculatorController controller) {
        this.controller = controller;

    }

    public void showFrame() {
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (controller == null) return;
            String cmd = e.getActionCommand();

            switch (cmd) {
                case "+":
                    controller.onOperationPressed(Operation.ADD);
                    break;
                case "-":
                    controller.onOperationPressed(Operation.SUBTRACT);
                    break;
                case "*":
                    controller.onOperationPressed(Operation.MULTIPLY);
                    break;
                case "/":
                    controller.onOperationPressed(Operation.DIVIDE);
                    break;
                case "=":
                    controller.onEqualsPressed();
                    break;
                case "C":
                    controller.onClearPressed();
                    break;
                default:
                    controller.onNumberPressed(cmd);
                    break;
            }
        }
    }
}
