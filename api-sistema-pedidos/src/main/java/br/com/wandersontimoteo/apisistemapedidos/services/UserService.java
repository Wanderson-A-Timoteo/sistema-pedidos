package br.com.wandersontimoteo.apisistemapedidos.services;

import br.com.wandersontimoteo.apisistemapedidos.entities.User;
import br.com.wandersontimoteo.apisistemapedidos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findByUUID(id);
    }

    public User insert(User obj) {
        return  userRepository.save(obj);
    }
}
