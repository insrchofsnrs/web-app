package by.insrchofsnrs.webapp.util.converter.impl;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.util.converter.IMerger;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserDtoToUserConverter implements IMerger<User, UserDto> {
    @Override
    @Nullable
    public User merge(User user, UserDto userDto) {

        /*
        String name;
        String email;
        Date birthday;
        String phone;
        String phone2;
        */
        User result = null;

        if(!(user==null || userDto==null)) {
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setBirthday(userDto.getBirthday());
            user.setPhone(userDto.getPhone());
            user.setPhone2(userDto.getPhone2());
            result = user;
        }

        return result;
    }
}
