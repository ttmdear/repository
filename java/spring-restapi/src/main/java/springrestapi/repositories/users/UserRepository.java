package springrestapi.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springrestapi.domain.user.core.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
