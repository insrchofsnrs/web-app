package by.insrchofsnrs.webapp.util.converter.impl;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdateAndCreate;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.util.converter.IUserConverter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements IUserConverter {
    @Override
    public User createUserFromDTO(UserDTOForUpdateAndCreate dto) {
        return new User(
                dto.getName(),
                dto.getEmail(),
                dto.getBirthday(),
                dto.getPhone(),
                dto.getPhone2());
    }

    @Override
    public UserDTOForUpdateAndCreate createDTOFromUser(User user) {
        return new UserDTOForUpdateAndCreate(
                user.getName(),
                user.getEmail(),
                user.getBirthday(),
                user.getPhone(),
                user.getPhone2());
    }
}
