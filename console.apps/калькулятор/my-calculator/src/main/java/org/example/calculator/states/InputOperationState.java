package org.example.calculator.states;

import org.example.calculator.CalculatorController;

public class InputOperationState implements CalculatorState {
    private final CalculatorController calculator;

    public InputOperationState(CalculatorController calculator) {
        this.calculator = calculator;
    }

    @Override
    public void handleDigit(int digit) {

    }

    @Override
    public void handleOperator(char operator) {

    }

    @Override
    public void handleEquals() {

    }

    @Override
    public void handleClear() {

    }
}
