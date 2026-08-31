package com.jcmn.restAPITest.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    private UserDaoService service;

    private UserRepository repository;

    public UserJPAResource(UserDaoService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    // GET /users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    // GET /users/{id}
    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable int id){
        Optional<User> foundUser = repository.findById(id);

        if (foundUser.isEmpty()){
            throw new UserNotFoundException("id: " + id);
        }

        return foundUser.get();
    }

    // POST /users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid /* For validating the user Posted */ @RequestBody User user){
        User savedUser = repository.save(user);

        // /users/4 => /users/{id}, user.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    // DELETE /users/{id}
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }


}
