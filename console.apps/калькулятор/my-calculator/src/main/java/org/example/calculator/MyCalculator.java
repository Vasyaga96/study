package org.example.calculator;

import org.example.calculator.ui.CalculatorView;
import org.example.calculator.ui.CalculatorWindow;

public class MyCalculator {
    public static void main(String[] args) {
        System.setProperty("apple.awt.application.appearance", "system");
        CalculatorWindow window = new CalculatorWindow();
        CalculatorView view = (CalculatorView) window.getContentPane();
        new CalculatorController(view);
    }
}
