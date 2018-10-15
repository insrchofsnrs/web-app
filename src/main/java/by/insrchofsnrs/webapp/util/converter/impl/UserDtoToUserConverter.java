package by.insrchofsnrs.webapp.util.converter.impl;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.util.converter.IMerger;
import org.springframework.stereotype.Service;

@Service
public class UserDtoToUserConverter implements IMerger<User, UserDto> {
    @Override
    public User merge(User user, UserDto userDto){

        /*
        String name;
        String email;
        Date birthday;
        String phone;
        String phone2;
        */

        User result;
        if (userDto.getName()!=null) user.setName(userDto.getName());
        if (userDto.getEmail()!=null) user.setEmail(userDto.getEmail());
        if (userDto.getBirthday()!=null) user.setBirthday(userDto.getBirthday());
        if (userDto.getPhone()!=null) user.setPhone(userDto.getPhone());
        if (userDto.getPhone2()!=null) user.setPhone2(userDto.getPhone2());

        result = user;
        return result;
    }
}
