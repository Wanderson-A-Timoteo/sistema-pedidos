package br.com.wandersontimoteo.apisistemapedidos.resources;

import br.com.wandersontimoteo.apisistemapedidos.entities.User;
import br.com.wandersontimoteo.apisistemapedidos.services.UserService;
import br.com.wandersontimoteo.apisistemapedidos.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            CustomResponse customResponse = new CustomResponse("Não existe um usuário com o ID: " + id + " fornecido.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);
        }
    }
}
