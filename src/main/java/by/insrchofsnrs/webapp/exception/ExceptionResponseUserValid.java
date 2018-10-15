package by.insrchofsnrs.webapp.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ExceptionResponseUserValid extends ExceptionResponse {

    private List<InvalidFieldsUserDto> invalidFieldsList;

    public ExceptionResponseUserValid(Date timestamp,
                                      String message,
                                      String details,
                                      List<InvalidFieldsUserDto> invalidFieldsList) {
        super(timestamp, message, details);
        this.invalidFieldsList = invalidFieldsList;
    }
}
