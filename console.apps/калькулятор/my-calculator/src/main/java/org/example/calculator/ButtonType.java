package org.example.calculator;

import org.example.calculator.ui.Colors;

import java.awt.*;

public enum ButtonType {
    DIGIT(Colors.NUMBER_COLOR, Colors.TEXT_COLOR, 22, Font.PLAIN),
    OPERATION(Colors.OPERATION_COLOR, Colors.TEXT_COLOR, 20, Font.BOLD),
    EQUALS(Colors.EQUALS_COLOR, Colors.TEXT_COLOR, 20, Font.BOLD),
    CLEAR(Colors.CLEAR_COLOR, Colors.TEXT_COLOR, 16, Font.PLAIN),;

    public final Color backgroundColor;
    public final Color textColor;
    public final int fontSize;
    public final int style;

    ButtonType(Color backgroundColor, Color textColor, int fontSize, int style) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.fontSize = fontSize;
        this.style = style;
    }
}
