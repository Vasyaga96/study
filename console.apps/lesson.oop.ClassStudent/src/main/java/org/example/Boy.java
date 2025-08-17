package org.example;

class Boy extends Student {
    private int pushUps;

    public Boy(String name, int pushUps) {
        super(name, "Male");
        this.pushUps = pushUps;
    }

    @Override
    public boolean passTest() {
        return pushUps >= 20;
    }
}