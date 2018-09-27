package by.insrchofsnrs.webapp;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdateAndCreate;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.sevice.UserService;
import by.insrchofsnrs.webapp.util.converter.impl.UserDTOConverter;
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

    UserDTOForUpdateAndCreate userDTO = new UserDTOForUpdateAndCreate(
            "alex",
            "alex@hmail.com",
            new Date(123213212312L),
            "111111111",
            "222222222"
    );

    @Test
    public void userCreateTest() {
        assertNotNull(userService.createUser(userDTO).getId());
    }

    @Test
    public void getAllUsersTest() {
        userService.createUser(userDTO);
        assertFalse(userService.getAllUsers().isEmpty());
    }

    @Test
    public void deleteUserTest() {
        User user = userService.createUser(userDTO);
        assertTrue(userService.deleteUser(user.getId()));
    }

    @Test
    public void updateUserTest() {
        User user = userService.createUser(userDTO);

        UserDTOForUpdateAndCreate userDTO = converter.createDTOFromUser(user);
        userDTO.setEmail("test@email.com");
        userDTO.setName("Loli");
        userDTO.setPhone("test phone");
        userDTO.setPhone2("test phone 2");

        User updatedUser = userService.updateUser(user.getId(), userDTO);

        assertEquals(updatedUser.getId(), user.getId());
        assertEquals(updatedUser.getName(), userDTO.getName());
        assertEquals(updatedUser.getEmail(), userDTO.getEmail());
        assertEquals(updatedUser.getPhone(), userDTO.getPhone());
        assertEquals(updatedUser.getPhone2(), userDTO.getPhone2());
        assertEquals(updatedUser.getBirthday(), userDTO.getBirthday());
    }
}
