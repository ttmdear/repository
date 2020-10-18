package springrestapi.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springrestapi.domain.user.resources.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {

}
