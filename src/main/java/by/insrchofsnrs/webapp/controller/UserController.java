package by.insrchofsnrs.webapp.controller;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        ArrayList<User> users = (ArrayList<User>) userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody UserDto userDto) {

        ResponseEntity<?> result;

        User createdUser = userService.createUser(userDto);
        result = new ResponseEntity<>(createdUser, HttpStatus.OK);

        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        ResponseEntity<User> result;
        userService.deleteUser(id);
        result = new ResponseEntity<>(HttpStatus.OK);

        return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id,
                                        @Validated @RequestBody UserDto userDto) {

        ResponseEntity<?> result;

        User user = userService.updateUser(id, userDto);
        result = new ResponseEntity<>(user, HttpStatus.OK);

        return result;
    }
}
