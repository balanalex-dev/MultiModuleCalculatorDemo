package model;

import interfaces.Operation;

/**
 * Класс Calculator выполняет базовые арифметические операции.
 * Не зависит от GUI или контроллеров (чистая бизнес-логика).
 */
public class Calculator {

    private double currentValue;

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Выполняет вычисление для заданных операндов и операции.
     */
    public double calculate(double a, double b, Operation op) {
        switch (op) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if ((b == 0) || (a == 0)) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Unknown operation: " + op);
        }
        
    }

    public void clear() {
        currentValue = 0;
    }

}
