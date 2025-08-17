package org.example.calculator;

import org.example.calculator.states.CalculatorState;
import org.example.calculator.states.InitialState;
import org.example.calculator.ui.CalculatorView;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private CalculatorState state = new InitialState(this);
    private int currentNumber = 0;
    private int savedNumber = 0;
    private char operator = NO_OPERATOR;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        connectView();
    }

    public void setState(CalculatorState state) {
        this.state = state;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
        calculatorView.setNumber(currentNumber);
    }

    public void saveNumber() {
        savedNumber = currentNumber;
    }

    public void addDigit(int digit) {
        setCurrentNumber(currentNumber * 10 + digit);
    }

    public void setOperation(char operator) {
        this.operator = operator;
    }

    public void calculate() {
        if (operator == NO_OPERATOR) return;

        switch (operator) {
            case '+' -> setCurrentNumber(savedNumber + currentNumber);
            case '–' -> setCurrentNumber(savedNumber - currentNumber);
            case '×' -> setCurrentNumber(savedNumber * currentNumber);
            case '÷' -> setCurrentNumber(savedNumber / currentNumber);
        }
    }

    private void connectView() {
        calculatorView.setButtonClickHandler(this::handleButtonClick);
    }

    private void handleButtonClick(ButtonType buttonType, String text) {
        switch (buttonType) {
            case DIGIT -> handleDigit(Integer.parseInt(text));
            case OPERATION -> handleOperator(text.charAt(0));
            case EQUALS -> handleEquals();
            case CLEAR -> handleClear();
        }
    }

    private void handleDigit(int digit) {
        state.handleDigit(digit);
    }

    private void handleOperator(char operator) {
        state.handleOperator(operator);
    }

    private void handleEquals() {
        state.handleEquals();
    }

    private void handleClear() {
        state.handleClear();
    }

    private static final char NO_OPERATOR = ' ';
}
