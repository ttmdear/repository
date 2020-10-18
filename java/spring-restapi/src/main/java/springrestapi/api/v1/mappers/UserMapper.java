package springrestapi.api.v1.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springrestapi.api.v1.UsersController;
import springrestapi.api.v1.dto.UserDto;
import springrestapi.domain.user.core.User;

@Mapper()
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto map(User user);

    User map(UserDto userDto);

    User map(UsersController.PostRequestBody body);

    User map(UsersController.PutRequestBody body);

    List<UserDto> map(List<User> users);
}
