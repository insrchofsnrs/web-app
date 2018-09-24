package by.insrchofsnrs.webapp;

import by.insrchofsnrs.webapp.controller.UserController;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.sevice.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;

    @Test
    public void firstTestIHaveNOIdeaAboutWhat() {
        User user = new User();
        user.setName("Test USer");
        when(userController.addUser(user)).thenReturn(new ResponseEntity<>(user, HttpStatus.CREATED));
    }
}
