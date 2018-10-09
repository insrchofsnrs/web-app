package by.insrchofsnrs.webapp;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.util.converter.IUserConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDTOConverterTest {

    @Autowired
    IUserConverter converter;


    private User user = new User (
            21L,
            "alex",
            "alex@hmail.com",
            new Date(1232132312L),
            "213213213",
            "awwdawd");


    private UserDto userDTO = new UserDto(
            "alex",
            "alex@hmail.com",
            new Date(123213212312L),
            "111111111",
            "222222222");

    @Test
    public void createDTOFromUserTest () {
       Assert.assertEquals(user.getBirthday(), converter.createDTOFromUser(user).getBirthday());
       Assert.assertEquals(user.getName(), converter.createDTOFromUser(user).getName());
       Assert.assertEquals(user.getEmail(), converter.createDTOFromUser(user).getEmail());
       Assert.assertEquals(user.getPhone(), converter.createDTOFromUser(user).getPhone());
       Assert.assertEquals(user.getPhone2(), converter.createDTOFromUser(user).getPhone2());
    }

    @Test
    public void createUserFromDTOUserTest () {
        Assert.assertEquals(userDTO.getBirthday(), converter.createUserFromDTO(userDTO).getBirthday());
        Assert.assertEquals(userDTO.getName(), converter.createUserFromDTO(userDTO).getName());
        Assert.assertEquals(userDTO.getEmail(), converter.createUserFromDTO(userDTO).getEmail());
        Assert.assertEquals(userDTO.getPhone(), converter.createUserFromDTO(userDTO).getPhone());
        Assert.assertEquals(userDTO.getPhone2(), converter.createUserFromDTO(userDTO).getPhone2());
    }
}
