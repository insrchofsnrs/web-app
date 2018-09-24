package by.insrchofsnrs.webapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Data
@Component
public class UserDTOForUpdate {

    private String name;
    private String email;
    private Date birthday;
    private String phone;
    private String phone2;
}
