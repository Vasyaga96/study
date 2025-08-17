package org.example.calculator.states;

import org.example.calculator.CalculatorController;

public class InputSecondDigitState implements CalculatorState {
    private final CalculatorController calculator;

    public InputSecondDigitState(CalculatorController calculator) {
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
