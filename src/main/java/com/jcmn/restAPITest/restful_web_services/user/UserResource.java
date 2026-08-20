package com.jcmn.restAPITest.restful_web_services.user;

import com.jcmn.restAPITest.restful_web_services.helloworld.HelloWorldBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    // POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        // /users/4 => /users/{id}, user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }


}
