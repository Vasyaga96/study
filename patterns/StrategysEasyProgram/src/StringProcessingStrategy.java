public class StringProcessingStrategy implements WordProcessingStrategy {
    private final String string;
    public StringProcessingStrategy(String string) {
        this.string = string;
    }
    @Override
    public void printResults(String string) {

    }

    @Override
    public boolean supports(String string) {
        return false;
    }

    @Override
    public boolean isContains(String string) {

    }
}
