package repositories;

import pattern.InMemoryDatabase;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private InMemoryDatabase inMemoryDatabase;

    public UserRepositoryImpl() {
        this.inMemoryDatabase = new InMemoryDatabase();
    }

    @Override
    public List<String> findUsers(int limit, int offset) {
         List<String> allUSers = inMemoryDatabase.getUsers();
         int start = (offset-1)*limit;  //start of the paginated data
         int end = Math.min(start + limit, allUSers.size());  //end of the paginated data

        if(start >= allUSers.size()) {
            return List.of();
        }
         return allUSers.subList(start, end);
    }
}
/**
 * When limit and offset based pagination is not good
 *
 * set of fb post f10,f9,f8,f7,f6,f5,f4,f3,f2,f1,f0
 * limit 3 offset 0 (f10,f9,f8)
 *
 * f12,f11,f10,f9,f8,f7,f6,f5,f4,f3,f2,f1
 * limit 3 offset 3 (f7,f6,f5) - expected, f9,f8,f7 - result
 *
 * fb has a very throughput of post
 * let say we are doing pagination and 2 more user signed up behind the scenes
 *
 *
 * solution is - cursor based pagination(created_at property)
 */