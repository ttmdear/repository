package com.ttmdear.petclinic.data.services;

import com.ttmdear.petclinic.data.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
