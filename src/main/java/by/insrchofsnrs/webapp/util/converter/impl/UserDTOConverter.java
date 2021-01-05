package by.insrchofsnrs.webapp.util.converter.impl;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.util.converter.IUserConverter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements IUserConverter {

    @Override
    public User createUserFromDTO(UserDto dto) {

        User result = new User();

        result.setName(dto.getName());
        result.setEmail(dto.getEmail());
        result.setBirthday(dto.getBirthday());
        result.setPhone(dto.getPhone());
        result.setPhone2(dto.getPhone2());

        return result;
    }

    @Override
    public UserDto createDTOFromUser(User user) {

        UserDto result = new UserDto();

        result.setName(user.getName());
        result.setEmail(user.getEmail());
        result.setBirthday(user.getBirthday());
        result.setPhone(user.getPhone());
        result.setPhone2(user.getPhone2());

        return result;
    }
}
