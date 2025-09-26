package services;

import iterators.Iterator;
import iterators.UserIterator;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final Iterator<List<String>> iterator;


    public UserService() {
        this.iterator = new UserIterator(10);
        this.userRepository = new UserRepositoryImpl();
    }

    public void getUsers() {


        /**
         * this.userRepository.findUsers(10,1);
         * for this type of implementation problem is :
         * -> here service layer has to keep track of current page and current offset
         * -> wherever pagination is required we need to maintain offset there
         * -> we don't know when to stop ?  we might have to write a custom logic to check no more data is there
         */


        while(!iterator.hasNext()){
            List<String> users = iterator.next();
            System.out.println(users);
        }
    }
}
