package org.example;


class OddWordConverter implements WordConverter {
    @Override
    public String convert(String original) {
        StringBuilder converted = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (c == 'z') {
                converted.append('a');
            } else if (c == 'я') {
                converted.append('а');
            } else if ((c >= 'a' && c < 'z') || (c >= 'а' && c < 'я')) {
                converted.append((char) (c + 1));
            } else {
                converted.append(c);
            }
        }
        return converted.toString();
    }
}