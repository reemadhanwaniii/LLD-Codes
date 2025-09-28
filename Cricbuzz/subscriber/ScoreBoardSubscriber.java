package subscriber;

import models.Innings;
import models.Match;
import producers.Producer;

public class ScoreBoardSubscriber implements Subscriber {
    private Match match;

    public ScoreBoardSubscriber(Match match) {
        this.match = match;
    }

    public void update(Producer producer) {
        boolean isFirstInnings = producer.getMatchData().getIsFirstInnings();
        Innings inningProducer = (isFirstInnings)?producer.getMatchData().getInnings1() : producer.getMatchData().getInnings2();

        Innings inningSubscriber = (isFirstInnings)?match.getInnings1():match.getInnings2();

        inningSubscriber.setCurrentBall(inningProducer.getCurrentBall());
        inningSubscriber.setCurrentOver(inningProducer.getCurrentOver());
        inningSubscriber.setCurrentScore(inningProducer.getCurrentScore());
        inningSubscriber.setWickets(inningProducer.getWickets());
    }
}
