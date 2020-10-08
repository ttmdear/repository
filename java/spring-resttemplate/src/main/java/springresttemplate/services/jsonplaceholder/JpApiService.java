package springresttemplate.services.jsonplaceholder;

import springresttemplate.services.jsonplaceholder.dto.UserDto;

public interface JpApiService {
    UserDto[] getUsers();
}
