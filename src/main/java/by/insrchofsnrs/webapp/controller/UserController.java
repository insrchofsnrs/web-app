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
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        ResponseEntity<User> result = new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);

        User createdUser = userService.createUser(user);
        if (createdUser.getId() != null) {
            result = new ResponseEntity<>(createdUser, HttpStatus.OK);
        }

        return result;
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

    //не знаю как тут проверить сохранился юзер или нет и при фейловом обновлении отправить BAD_REQUEST
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestBody UserDTOForUpdateAndCreate userDTO) {
        User user = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
