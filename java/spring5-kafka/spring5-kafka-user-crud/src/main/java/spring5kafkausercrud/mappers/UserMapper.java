package spring5kafkausercrud.mappers;

import org.springframework.stereotype.Service;
import spring5kafkausercrud.domain.User;
import spring5kafkausercrud.dto.UserDto;

@Service
public class UserMapper {
    public UserDto map(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setId(user.getId());
        userDto.setId(user.getId());

        return userDto;
    }

    public User map(UserDto userDto) {
        User user = new User();

        user.setId(user.getId());
        user.setId(user.getId());
        user.setId(user.getId());

        return user;
    }
}
