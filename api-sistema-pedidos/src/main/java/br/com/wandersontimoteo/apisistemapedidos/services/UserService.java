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

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public User update(UUID id, User obj){
        User updateUser = userRepository.getReferenceById(id);
        updateData(updateUser, obj);
        return userRepository.save(updateUser);
    }

    private void updateData(User updateUser, User obj) {
        updateUser.setName(obj.getName());
        updateUser.setEmail(obj.getEmail());
        updateUser.setPhone(obj.getPhone());
    }
}
