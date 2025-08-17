package org.example.calculator.states;

import org.example.calculator.CalculatorController;

public class InputFirstDigitState implements CalculatorState {
    private final CalculatorController calculator;

    public InputFirstDigitState(CalculatorController calculator) {
        this.calculator = calculator;
    }

    @Override
    public void handleDigit(int digit) {
        calculator.addDigit(digit);
    }

    @Override
    public void handleOperator(char operator) {
        calculator.setOperation(operator);
        calculator.setState(new InputOperationState(calculator));
    }

    @Override
    public void handleEquals() {
        calculator.calculate();
        calculator.setState(new InitialState(calculator));
    }

    @Override
    public void handleClear() {
        calculator.setCurrentNumber(0);
        calculator.setState(new InitialState(calculator));
    }
}
