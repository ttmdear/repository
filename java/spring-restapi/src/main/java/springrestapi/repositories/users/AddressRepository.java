package springrestapi.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springrestapi.domain.user.locations.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
