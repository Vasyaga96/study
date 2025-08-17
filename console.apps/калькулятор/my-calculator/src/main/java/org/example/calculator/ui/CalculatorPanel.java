package org.example.calculator.ui;

import org.example.calculator.ButtonType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.BiConsumer;

public class CalculatorPanel extends JPanel implements CalculatorView {
    private CalculatorDisplay display;
    private BiConsumer<ButtonType, String> buttonClickHandler = null;

    public CalculatorPanel() {
        super();
        initUi();
    }

    @Override
    public void setNumber(int number) {
        display.setText(String.valueOf(number));
    }

    @Override
    public void setButtonClickHandler(BiConsumer<ButtonType, String> buttonClickHandler) {
        this.buttonClickHandler = buttonClickHandler;
    }

    private void initUi() {
        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND_COLOR);

        display = new CalculatorDisplay();

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBackground(Colors.BACKGROUND_COLOR);

        String[][] buttons = {
                {"C", " ", " ", "÷"},
                {"7", "8", "9", "×"},
                {"4", "5", "6", "–"},
                {"1", "2", "3", "+"},
                {"0", " ", " ", "="}
        };

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(1, 1, 1, 1);
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String text = buttons[row][col];
                ButtonType buttonType = getButtonType(text);
                JButton button = new CalculatorButton(text, buttonType);
                button.addActionListener(this::handleButtonClick);

                constraints.gridx = col;
                constraints.gridy = row;

                if (row == 0 && col == 0) {
                    constraints.gridwidth = 1;
                    col += 2;
                } else if (row == 4 && col == 0) {
                    constraints.gridwidth = 3;
                    col += 2;
                } else {
                    constraints.gridwidth = 1;
                }

                buttonsPanel.add(button, constraints);
            }
        }

        add(display, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
    }

    private ButtonType getButtonType(String text) {
        return switch (text) {
            case "C" -> ButtonType.CLEAR;
            case "÷", "×", "–", "+" -> ButtonType.OPERATION;
            case "=" -> ButtonType.EQUALS;
            default -> ButtonType.DIGIT;
        };
    }

    private void handleButtonClick(ActionEvent e) {
        if (buttonClickHandler == null) return;

        CalculatorButton button = (CalculatorButton) e.getSource();
        buttonClickHandler.accept(button.getButtonType(), button.getText());
    }
}
