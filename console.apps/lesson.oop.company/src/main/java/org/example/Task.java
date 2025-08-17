package org.example;

import java.util.Random;

public class Task {
    private int durationHours;

    public Task(int durationHours){
        this.durationHours = durationHours;
    }
    public boolean haveDurationHours(){
        return durationHours > 0;
    }
    public static Task ctreateRandomTask(int start, int end){
        Random random = new Random();
        return new Task(random.nextInt(start, end));
    }
    public int getDurationHours() {
        return durationHours;
    }
    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

}
