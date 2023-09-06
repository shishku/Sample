package de.noobninja.sample.services;

import de.noobninja.sample.models.Todo;
import de.noobninja.sample.models.User;
import de.noobninja.sample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Optional<User> getById(int id){
        return userRepo.findById(id);
    }

    public Iterable<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> getByEmailAndPassword(String email, String password){
        return userRepo.findByEmailAndPassword(email, password);
    }

    public Optional<User> getBySecret(String secret){
        return userRepo.findBySecret(secret);
    }

    public User create(User item){
        return userRepo.save(item);
    }

    public void delete(int id){
        userRepo.deleteById(id);
    }

    public User update(User item){
        return userRepo.save(item);
    }

}
