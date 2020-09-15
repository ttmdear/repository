package repo.spring.tests.repositories;

import repo.spring.tests.domain.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, String> {

}
