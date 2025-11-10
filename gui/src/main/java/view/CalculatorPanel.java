package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Панель кнопок калькулятора.
 */
public class CalculatorPanel extends JPanel {

    private final List<JButton> buttons = new ArrayList<>();

    public CalculatorPanel() {
        setLayout(new GridLayout(4, 4, 5, 5));

        String[] labels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "C", "0", "=", "/"
        };

        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            buttons.add(button);
            add(button);
        }
    }

    /**
     * Возвращает все кнопки панели.
     * Контроллер или фрейм могут подписывать слушателей.
     */
    public List<JButton> getButtons() {
        return buttons;
    }
}

