package by.insrchofsnrs.webapp.util.converter;

import by.insrchofsnrs.webapp.exception.InvalidFieldsUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ErrorConverter implements Converter<MethodArgumentNotValidException, List<InvalidFieldsUserDto>> {
    @Override
    public List<InvalidFieldsUserDto> convert(MethodArgumentNotValidException e) {
        List<InvalidFieldsUserDto> result = e.getBindingResult().getFieldErrors()
                .stream()
                .map((p)-> new InvalidFieldsUserDto(p.getDefaultMessage(), p.getField(), p.getRejectedValue()))
                .collect(Collectors.toList());
        return result;
    }
}
