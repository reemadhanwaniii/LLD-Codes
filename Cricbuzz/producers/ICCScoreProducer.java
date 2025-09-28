package producers;

import consumers.ScoreBoardSubscriber;
import models.Match;

public class ICCScoreProducer {

    private ScoreBoardSubscriber scoreBoardSubscriber;

    public ICCScoreProducer(ScoreBoardSubscriber scoreBoardSubscriber) {
        this.scoreBoardSubscriber = scoreBoardSubscriber;
    }

//    ideally it fetch runs ... from api and then pass this data to subscriber
    public void scoreUpdates(int score,int ball,int over,int wickets,boolean isFirstInnings) {
        this.scoreBoardSubscriber.update(over,ball,wickets,score,isFirstInnings);
    }
}
