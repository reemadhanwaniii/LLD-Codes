package producers;

import models.Match;
import subscriber.Subscriber;

public interface Producer {
    Match getMatchData();
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscribers();
}
