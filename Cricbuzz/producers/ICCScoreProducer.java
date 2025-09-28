package producers;

import models.Match;
import subscriber.ScoreBoardSubscriber;
import subscriber.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ICCScoreProducer implements Producer {

    private Match match;
    Set<Subscriber> subscribers;

    public ICCScoreProducer(Match match) {
        this.subscribers = new HashSet<>();

    }

//    ideally it fetch runs ... from api and then pass this data to subscriber
    public void scoreUpdates() {
        this.notifySubscribers();
    }

    @Override
    public Match getMatchData() {
        return this.match;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber sub: subscribers) {
            sub.update(this);
        }
    }
}
