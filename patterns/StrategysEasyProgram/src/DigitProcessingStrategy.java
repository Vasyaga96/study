public class DigitProcessingStrategy implements WordProcessingStrategy {

    private final String str;
    public DigitProcessingStrategy(String string) {
        this.str = string;
    }
    @Override
    public boolean supports(String str) {
        return isContains(str);
    }

    @Override
    public void printResults(String string) {

    }

    @Override
    public boolean isContains(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
