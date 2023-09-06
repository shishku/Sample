package de.noobninja.sample.controllers;

import de.noobninja.sample.models.Todo;
import de.noobninja.sample.repositories.UserRepository;
import de.noobninja.sample.services.TodoService;
import de.noobninja.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Todo> get(
            @RequestParam(value = "id") int id
    ) {
        // get todo from db by id
        Optional<Todo> todoInDb = todoService.getById(id);
        return todoInDb.map(todo -> new ResponseEntity<>(todo, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity("No todo found with id " + id, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity getAll(
            @RequestHeader("api-secret") String secret
    ) {
        var userBySecret = userService.getBySecret(secret);
        if (userBySecret.isPresent()) {
            Iterable<Todo> allTodosInDb =
                    todoService.getAllByUser(
                            userBySecret.get().getId()
                    );
            return new ResponseEntity<>(
                    allTodosInDb, HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                "Invalid api secret",
                    HttpStatus.BAD_REQUEST
        );
    }

    @PostMapping
    public ResponseEntity<Todo> create(
            @RequestBody Todo newTodo
    ) {
        // save in db
        todoService.create(newTodo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(
            @RequestParam(value = "id") int id
    ) {
        Optional<Todo> todoInDb = todoService.getById(id);
        if (todoInDb.isPresent()) {
            todoService.delete(id);
            return new ResponseEntity<>("Todo deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("No todo to delete found with id " + id, HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity edit(
            @RequestBody Todo editedTodo
    ) {
        Optional<Todo> todoInDb = todoService.getById(editedTodo.getId());
        if (todoInDb.isPresent()) {
            Todo savedTodo = todoService.update(editedTodo);
            return new ResponseEntity<>(savedTodo, HttpStatus.OK);
        }
        return new ResponseEntity<>("No todo to update found with id " + editedTodo.getId(), HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/finish")
    public ResponseEntity setDone(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "isDone") boolean isDone
    ) {
        Optional<Todo> todoInDb = todoService.getById(id);
        if (todoInDb.isPresent()) {
            // update isDone
            todoInDb.get().setDone(isDone);
            Todo savedTodo = todoService.update(todoInDb.get());
            return new ResponseEntity<>(savedTodo, HttpStatus.OK);
        }
        return new ResponseEntity<>("No todo to update found with id " + id, HttpStatus.NOT_FOUND);
    }

}
