package consumers;

import models.Innings;
import models.Match;

public class ScoreBoardSubscriber {
    private Match match;

    public ScoreBoardSubscriber(Match match) {
        this.match = match;
    }

    public void update(int currentOver,int currentBall,int wickets,int currentScore,boolean isFirstInnings) {
        Innings innings = isFirstInnings? this.match.getInnings1() : this.match.getInnings2();

        innings.setCurrentBall(currentBall);
        innings.setCurrentOver(currentOver);
        innings.setWickets(wickets);
        innings.setCurrentScore(currentScore);

    }
}
