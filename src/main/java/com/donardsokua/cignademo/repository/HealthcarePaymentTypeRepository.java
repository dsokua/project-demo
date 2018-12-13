package com.donardsokua.cignademo.repository;

import org.springframework.data.repository.CrudRepository;

import com.donardsokua.cignademo.model.HealthcarePaymentType;

public interface HealthcarePaymentTypeRepository extends CrudRepository<HealthcarePaymentType, Long> {

}
