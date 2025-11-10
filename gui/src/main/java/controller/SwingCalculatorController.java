package controller;

import interfaces.CalculatorController;
import interfaces.GuiFrame;
import interfaces.Operation;
import model.Calculator;


/**
 * Контроллер, реализующий логику калькулятора для Swing-интерфейса.
 */
public class SwingCalculatorController implements CalculatorController {

    private final Calculator calculator;
    private final GuiFrame guiFrame;

    private double firstOperand = 0;
    private double secondOperand = 0;

    private Operation currentOperation = null;
    private boolean isNewInput = true;
    private final StringBuilder inputBuffer = new StringBuilder();

    public SwingCalculatorController(Calculator calculator, GuiFrame guiFrame) {
        this.calculator = calculator;
        this.guiFrame = guiFrame;
        this.guiFrame.setController(this);  // GUI получает ссылку на контроллер
    }

    @Override
    public void onNumberPressed(String number) {
        if (isNewInput) {
            inputBuffer.setLength(0);
            isNewInput = false;
        }
        inputBuffer.append(number);
        guiFrame.displayResult(Double.parseDouble(inputBuffer.toString()));
    }

    @Override
    public void onOperationPressed(Operation operation) {
        if (inputBuffer.length() > 0) {
            firstOperand = Double.parseDouble(inputBuffer.toString());
            inputBuffer.setLength(0);

        }
        currentOperation = operation;
    }


    @Override
    public void onEqualsPressed() {
        if (currentOperation == null || inputBuffer.length() == 0) {
            return;
        }
        secondOperand = Double.parseDouble(inputBuffer.toString());
        double result = calculator.calculate(firstOperand, secondOperand, currentOperation);
        calculator.setCurrentValue(result);
        guiFrame.displayResult(result);
        isNewInput = true;
        currentOperation = null;
        inputBuffer.setLength(0);
        inputBuffer.append(result);
        firstOperand = 0;
    }

    @Override
    public void onClearPressed() {
        calculator.clear();
        firstOperand = 0;
        secondOperand = 0;
        currentOperation = null;
        inputBuffer.setLength(0);
        guiFrame.displayResult(0);
        isNewInput = true;
    }
}
