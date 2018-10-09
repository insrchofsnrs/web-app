package by.insrchofsnrs.webapp.controller;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateQueryException;
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
    public ResponseEntity<?> addUser(@Validated @RequestBody UserDto userDTO) {

        ResponseEntity<?> result;

            User createdUser = userService.createUser(userDTO);
            result = new ResponseEntity<>(createdUser, HttpStatus.OK);

        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        ResponseEntity<User> result;
        try {
            userService.deleteUser(id);
            result = new ResponseEntity<>(HttpStatus.OK);
        } catch (HibernateQueryException e) {
            log.error("При удалении юзера что-то пошло не так!");
            result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id,
                                        @Validated @RequestBody UserDto userDTO) {

        ResponseEntity<?> result;

        User user = userService.updateUser(id, userDTO);
        result = new ResponseEntity<>(user, HttpStatus.OK);

        return result;
    }
}
