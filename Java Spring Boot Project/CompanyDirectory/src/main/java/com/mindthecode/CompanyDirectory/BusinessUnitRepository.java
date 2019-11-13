package com.mindthecode.CompanyDirectory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface BusinessUnitRepository extends CrudRepository<BusinessUnit, Long> {

    @Override
    @RestResource(exported = false)
    void delete(BusinessUnit entity);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    BusinessUnit save(BusinessUnit entity);
}
