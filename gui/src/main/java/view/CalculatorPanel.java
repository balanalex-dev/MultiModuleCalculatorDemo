package view;

import interfaces.ButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Панель кнопок калькулятора.
 */
public class CalculatorPanel extends JPanel {

    //private final List<JButton> buttons = new ArrayList<>();

    private final Map<String, JButton> buttons = new LinkedHashMap<>();


    public CalculatorPanel(ButtonFactory buttonFactory, ActionListener listener) {
        setLayout(new GridLayout(4, 4, 5, 5));

        String[] labels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "C", "0", "=", "/"
        };

        for (String label : labels) { //todo патерн абстракт фактори и применить его к кнопкам
            JButton button = buttonFactory.createButton(label, listener);
            buttons.put(label, button);
            add(button);

        }
    }

    /**
     * Возвращает все кнопки панели.
     * Контроллер или фрейм могут подписывать слушателей.
     */
    public Map<String, JButton> getButtons() {
        return buttons;
    }
}

