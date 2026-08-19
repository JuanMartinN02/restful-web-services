package com.jcmn.restAPITest.restful_web_services.user;

// DAO (Data Access Object) is a software design pattern used to abstract and encapsulate all interactions
// with the database or data source. It isolates your application's business logic from the underlying storage
// technology (such as MySQL, PostgreSQL, or NoSQL), ensuring that changing your database setup will not
//disrupt the rest of your system.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {
    // JPA/Hibernate > Database
    // UserDaoService > Static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jose", LocalDate.now().minusYears(36)));
        users.add(new User(2, "Ramon", LocalDate.now().minusYears(19)));
        users.add(new User(3, "Miguel", LocalDate.now().minusYears(56)));
        users.add(new User(4, "Rayhan", LocalDate.now().minusYears(22)));
    }

    public List<User> findAll() {
        return users;
    }

}
