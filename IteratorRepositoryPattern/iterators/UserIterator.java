package iterators;

import repositories.UserRepository;
import repositories.UserRepositoryImpl;

import java.util.List;

public class UserIterator implements Iterator {

    private final UserRepository userRepository;
    private int limit = 1;
    private int offset = 0;
    private List<String> current;

    public UserIterator(int limit) {
        this.userRepository = new UserRepositoryImpl();
        this.limit = limit;
        this.current = userRepository.findUsers(limit,offset);
    }

    @Override
    public boolean hasNext() {
        return !current.isEmpty();
    }

    @Override
    public Object next() {
        List<String> result = current;
        this.offset += limit;
        this.current = userRepository.findUsers(limit,offset);
        return result;
    }
}
