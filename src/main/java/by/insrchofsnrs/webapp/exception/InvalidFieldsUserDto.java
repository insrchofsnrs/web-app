package by.insrchofsnrs.webapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidFieldsUserDto {
    private String message;
    private String field;
    private Object rejectedValue;
}
