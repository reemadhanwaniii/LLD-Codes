package models;

public class Innings {
    private int currentScore;
    private int currentBall;
    private int currentRunRate;
    private int currentOver;
    private int wickets;

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentBall() {
        return currentBall;
    }

    public void setCurrentBall(int currentBall) {
        this.currentBall = currentBall;
    }

    public int getCurrentRunRate() {
        return currentRunRate;
    }

    public void setCurrentRunRate(int currentRunRate) {
        this.currentRunRate = currentRunRate;
    }

    public int getCurrentOver() {
        return currentOver;
    }

    public void setCurrentOver(int currentOver) {
        this.currentOver = currentOver;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
