package com.jcmn.restAPITest.restful_web_services.user;

// DAO (Data Access Object) is a software design pattern used to abstract and encapsulate all interactions
// with the database or data source. It isolates your application's business logic from the underlying storage
// technology (such as MySQL, PostgreSQL, or NoSQL), ensuring that changing your database setup will not
//disrupt the rest of your system.

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class UserDaoService {
    // JPA/Hibernate > Database
    // UserDaoService > Static List

    private static List<User> users = new ArrayList<>();

    private static Integer userIdCount = 0;

    static {
        users.add(new User(++userIdCount, "Jose", LocalDate.now().minusYears(36)));
        users.add(new User(++userIdCount, "Ramon", LocalDate.now().minusYears(19)));
        users.add(new User(++userIdCount, "Miguel", LocalDate.now().minusYears(56)));
        users.add(new User(++userIdCount, "Rayhan", LocalDate.now().minusYears(22)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id){
        // Used as a filter in Streams
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return  users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++userIdCount);
        users.add(user);
        return user;
    }

    public void  deleteById(int id){
        // Used as a filter in Streams
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
