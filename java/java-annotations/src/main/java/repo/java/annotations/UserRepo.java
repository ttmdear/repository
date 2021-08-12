package repo.java.annotations;

import repo.java.annotations.annotations.AnnotationOnMethod;
import repo.java.annotations.entities.User;

public class UserRepo extends Repo<User, String> {

    @Override
    @AnnotationOnMethod(logCall = true)
    public User findById(String id) {
        return super.findById(id);
    }
}
