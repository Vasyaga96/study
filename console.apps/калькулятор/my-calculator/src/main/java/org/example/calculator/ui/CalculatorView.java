package org.example.calculator.ui;

import org.example.calculator.ButtonType;

import java.util.function.BiConsumer;

public interface CalculatorView {
    void setNumber(int number);
    void setButtonClickHandler(BiConsumer<ButtonType, String> buttonClickHandler);
}
