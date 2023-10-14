package br.com.wandersontimoteo.apisistemapedidos.services;

import br.com.wandersontimoteo.apisistemapedidos.entities.User;
import br.com.wandersontimoteo.apisistemapedidos.repositories.UserRepository;
import br.com.wandersontimoteo.apisistemapedidos.services.exceptions.DatabaseException;
import br.com.wandersontimoteo.apisistemapedidos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findByIdUser(UUID id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser(User obj) {
        return  userRepository.save(obj);
    }

    public void deleteUser(UUID id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException error) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException err) {
            throw new DatabaseException(err.getMessage());
        }
    }

    public User updateUser(UUID id, User obj){
        try {
            User updateUser = userRepository.getReferenceById(id);
            updateData(updateUser, obj);
            return userRepository.save(updateUser);
        } catch (EntityNotFoundException erro) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User updateUser, User obj) {
        updateUser.setName(obj.getName());
        updateUser.setEmail(obj.getEmail());
        updateUser.setPhone(obj.getPhone());
    }
}
