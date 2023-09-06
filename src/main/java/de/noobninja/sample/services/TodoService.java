package de.noobninja.sample.services;

import de.noobninja.sample.models.Todo;
import de.noobninja.sample.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    public Optional<Todo> getById(int id){
        return todoRepo.findById(id);
    }

    public Iterable<Todo> getAll(){
        return todoRepo.findAll();
    }

    public Iterable<Todo> getAllByUser(int id){
        return todoRepo.findAllByUserId(id);
    }

    public Todo create(Todo item){
        return todoRepo.save(item);
    }

    public void delete(int id){
        todoRepo.deleteById(id);
    }

    public Todo update(Todo item){
        return todoRepo.save(item);
    }
}
