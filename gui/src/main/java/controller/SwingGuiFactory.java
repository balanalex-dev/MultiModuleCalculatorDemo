package controller;

import interfaces.GuiFactory;
import interfaces.GuiFrame;
import view.CalculatorFrame;

/**
 * Фабрика для создания GUI-компонентов (реализация для Swing).
 */
public class SwingGuiFactory implements GuiFactory {

    @Override
    public GuiFrame createCalculatorFrame() {
        return new CalculatorFrame();
    }
}
