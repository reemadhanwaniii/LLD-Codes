package producers;

import models.Match;
import subscriber.ScoreBoardSubscriber;

public class ICCScoreProducer implements Producer {

    private Match match;
    private ScoreBoardSubscriber scoreBoardSubscriber;

    public ICCScoreProducer(Match match,ScoreBoardSubscriber scoreBoardSubscriber) {
        this.scoreBoardSubscriber = scoreBoardSubscriber;
    }

//    ideally it fetch runs ... from api and then pass this data to subscriber
    public void scoreUpdates(int score,int ball,int over,int wickets,boolean isFirstInnings) {
        this.scoreBoardSubscriber.update(this);
    }

    @Override
    public Match getMatchData() {
        return this.match;
    }
}
