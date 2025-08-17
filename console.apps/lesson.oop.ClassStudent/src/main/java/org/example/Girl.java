package org.example;

class Girl extends Student {
    private int squats;

    public Girl(String name, int squats) {
        super(name, "Female");
        this.squats = squats;
    }

    @Override
    public boolean passTest() {
        return squats >= 20;
    }
}