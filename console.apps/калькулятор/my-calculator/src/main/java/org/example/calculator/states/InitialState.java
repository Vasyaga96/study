package org.example.calculator.states;

import org.example.calculator.CalculatorController;

public class InitialState implements CalculatorState {
    private final CalculatorController calculator;

    public InitialState(CalculatorController calculator) {
        this.calculator = calculator;
    }

    @Override
    public void handleDigit(int digit) {
        calculator.setCurrentNumber(digit);
        calculator.setState(new InputFirstDigitState(calculator));
    }

    @Override
    public void handleOperator(char operator) {
        calculator.setOperation(operator);
        calculator.setState(new InputOperationState(calculator));
    }

    @Override
    public void handleEquals() {
        // does nothing
    }

    @Override
    public void handleClear() {
        calculator.setCurrentNumber(0);
    }
}
