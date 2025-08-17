package org.example.calculator.states;

public interface CalculatorState {
    void handleDigit(int digit);
    void handleOperator(char operator);
    void handleEquals();
    void handleClear();
}
