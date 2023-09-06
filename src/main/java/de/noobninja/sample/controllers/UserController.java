package de.noobninja.sample.controllers;

import de.noobninja.sample.models.User;
import de.noobninja.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<User> register(
            @RequestBody User newUser
    ) {
        // generate secret
        newUser.setSecret(UUID.randomUUID().toString());
        var savedUser = userService.create(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<User> get(
            @RequestParam(value = "id") int id
    ) {
        var user = userService.getById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity("No user found with id " + id, HttpStatus.CREATED));
    }

    @GetMapping("/authenticate")
    private ResponseEntity<String> validate(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ) {
        var validUser = userService.getByEmailAndPassword(email, password);
        return validUser.map(user -> new ResponseEntity<>("API Secret: " + user.getSecret(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Wrong credentials/No Account found", HttpStatus.NOT_FOUND));
    }

}
