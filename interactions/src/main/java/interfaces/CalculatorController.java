package interfaces;


public interface CalculatorController {
    void onNumberPressed(String number);
    void onOperationPressed(Operation op);
    void onEqualsPressed();
    void onClearPressed();
}
