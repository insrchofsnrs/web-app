package by.insrchofsnrs.webapp.dto;

import by.insrchofsnrs.webapp.exception.ValidUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidUser(message = "заполни телефон")
public class UserDto {
    @NotNull
    private String name;

    @Email
    private String email;

    @Past
    private Date birthday;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", flags = Pattern.Flag.UNICODE_CASE,
             message = "number format +1234567890")
    private String phone;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", flags = Pattern.Flag.UNICODE_CASE,
             message = "number format +1234567890")
    private String phone2;
}
