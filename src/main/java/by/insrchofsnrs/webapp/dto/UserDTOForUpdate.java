package by.insrchofsnrs.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOForUpdate {

    private String name;
    private String email;
    private Date birthday;
    private String phone;
    private String phone2;
}
