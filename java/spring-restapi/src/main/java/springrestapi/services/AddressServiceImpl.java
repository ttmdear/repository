package springrestapi.services;

import org.springframework.stereotype.Service;
import springrestapi.domain.user.locations.Address;
import springrestapi.repositories.users.AddressRepository;

@Service
public class AddressServiceImpl extends ReadWriteServiceImpl<Address, String> implements AddressService {
    public AddressServiceImpl(AddressRepository addressRepository) {
        super(addressRepository);
    }
}
