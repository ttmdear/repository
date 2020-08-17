package springexceptions.services;

import org.springframework.stereotype.Repository;
import springexceptions.domain.User;
import springexceptions.exceptions.NotFound;
import springexceptions.exceptions.PermissionDenied;

@Repository
public class FileRepository {
    public String find(User user, String fileId) {
        if (user == null) {
            throw new NotFound();
        }

        if (!user.getId().equals(UserRepository.STATIC_USER_ID)) {
            throw new PermissionDenied();
        }

        return "YXNkc2FkYXNkYXNkc2E=";
    }
}
