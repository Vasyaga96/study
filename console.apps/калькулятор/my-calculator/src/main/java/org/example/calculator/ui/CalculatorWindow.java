package org.example.calculator.ui;

import javax.swing.*;

public class CalculatorWindow extends JFrame {
    public CalculatorWindow() {
        super();
        initUi();
    }

    private void initUi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);

        CalculatorPanel contents = new CalculatorPanel();

        setContentPane(contents);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
