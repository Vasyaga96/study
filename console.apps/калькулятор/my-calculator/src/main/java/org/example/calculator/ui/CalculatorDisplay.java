package org.example.calculator.ui;

import javax.swing.*;
import java.awt.*;

public class CalculatorDisplay extends JTextField {
    public CalculatorDisplay() {
        super();
        initUi();
    }

    private void initUi() {
        setText("0");
        setEditable(false);
        setFocusable(false);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
        setBackground(Colors.BACKGROUND_COLOR);
        setForeground(Colors.TEXT_COLOR);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
