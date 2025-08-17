package org.example.calculator.ui;

import org.example.calculator.ButtonType;

import javax.swing.*;
import java.awt.*;

public class CalculatorButton extends JButton {
    private final ButtonType buttonType;

    public CalculatorButton(String text, ButtonType buttonType) {
        super(text);
        this.buttonType = buttonType;
        initUi();
    }

    public ButtonType getButtonType() {
        return buttonType;
    }

    private void initUi() {
        //noinspection MagicConstant
        setFont(new Font("Helvetica Neue", buttonType.style, buttonType.fontSize));
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(true);
        setOpaque(true);
        setBackground(buttonType.backgroundColor);
        setForeground(buttonType.textColor);
        setPreferredSize(new Dimension((int) (45 * 1.25), 45));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            setBackground(Colors.CLICK_COLOR);
        } else {
            setBackground(buttonType.backgroundColor);
        }

        super.paintComponent(g);
    }
}
