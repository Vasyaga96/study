package org.example;

class EvenWordConverter implements WordConverter {
    @Override
    public String convert(String original) {
        return "" + original.charAt(0) + original.charAt(original.length() - 1);
    }
}