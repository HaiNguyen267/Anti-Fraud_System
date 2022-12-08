package antifraud.controller;

import antifraud.dto.response.DeleteUserResponse;
import antifraud.entity.User;
import antifraud.repository.UserRepository;
import antifraud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid User user) {
        User createdUser =  userService.register(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.delete(username);

        DeleteUserResponse response = new DeleteUserResponse(username, "Deleted successfully!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
