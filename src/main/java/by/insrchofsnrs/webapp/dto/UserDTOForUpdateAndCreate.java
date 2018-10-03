package by.insrchofsnrs.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOForUpdateAndCreate {
    @NotNull
    private String name;
    @Email
    private String email;
    private Date birthday;
    private String phone;
    private String phone2;
}
