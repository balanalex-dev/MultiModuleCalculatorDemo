import controller.SwingCalculatorController;
import controller.SwingGuiFactory;
import interfaces.GuiFactory;
import interfaces.GuiFrame;
import model.Calculator;

public class
Main {

    public static void main(String[] args) {
        // Создаём бизнес-логику (core)
        Calculator calculator = new Calculator();

        // Создаём фабрику GUI (gui)
        GuiFactory factory = new SwingGuiFactory();

        // Создаём окно через фабрику
        GuiFrame frame = factory.createCalculatorFrame();

        // Создаём контроллер, связывающий GUI и модель
        new SwingCalculatorController(calculator, frame);

        // Показываем интерфейс
        frame.showFrame();
    }
}
