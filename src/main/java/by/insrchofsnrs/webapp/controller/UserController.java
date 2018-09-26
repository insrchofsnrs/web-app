package by.insrchofsnrs.webapp.controller;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdateAndCreate;
import by.insrchofsnrs.webapp.pojo.User;

import by.insrchofsnrs.webapp.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateQueryException;
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
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(users, HttpStatus.OK);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (HibernateQueryException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(user, HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
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
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestBody UserDTOForUpdateAndCreate userDTO) {
        User user = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
