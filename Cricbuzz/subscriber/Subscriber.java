package subscriber;

import producers.Producer;

public interface Subscriber {
    public void update(Producer producer);
}
