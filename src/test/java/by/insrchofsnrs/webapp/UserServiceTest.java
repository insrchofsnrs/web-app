package by.insrchofsnrs.webapp;


import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.sevice.UserService;
import by.insrchofsnrs.webapp.util.converter.impl.UserDTOConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOConverter converter;

    UserDto userDTO = new UserDto(
            "alex",
            "alex@hmail.com",
            new Date(423213212312L),
            "111111111",
            "222222222"
    );

    @Test
    public void userCreateTest() {
        User user = userService.createUser(userDTO);

        assertNotNull(user.getId());
        assertEquals(user.getBirthday(), userDTO.getBirthday());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getPhone(), userDTO.getPhone());
        assertEquals(user.getPhone2(), userDTO.getPhone2());
    }

    @Test
    public void getAllUsersTest() {
        userService.createUser(userDTO);
        assertTrue(CollectionUtils.isNotEmpty(userService.getAllUsers()));
    }

    @Test
    public void deleteUserTest() {
        User user = userService.createUser(userDTO);
        assertTrue(userService.deleteUser(user.getId()));
    }

    @Test
    public void updateUserTest() {
        User user = userService.createUser(userDTO);

        UserDto userDTO = converter.createDTOFromUser(user);
        userDTO.setEmail("test@email.com");
        userDTO.setName("Loli");
        userDTO.setPhone("test phone");
        userDTO.setPhone2("test phone 2");

        User updatedUser = userService.updateUser(user.getId().toString(), userDTO);
        System.out.println(user.getId().toString());
        assertEquals(updatedUser.getId(), user.getId());
        assertEquals(updatedUser.getName(), userDTO.getName());
        assertEquals(updatedUser.getEmail(), userDTO.getEmail());
        assertEquals(updatedUser.getPhone(), userDTO.getPhone());
        assertEquals(updatedUser.getPhone2(), userDTO.getPhone2());
        assertEquals(updatedUser.getBirthday(), userDTO.getBirthday());
    }
}
