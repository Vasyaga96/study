public interface WordProcessingStrategy {
    boolean supports(String string);
    void printResults(String string);
    boolean isContains(String string);
}
