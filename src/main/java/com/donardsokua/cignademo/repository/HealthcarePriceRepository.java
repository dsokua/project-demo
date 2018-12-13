package com.donardsokua.cignademo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.donardsokua.cignademo.model.HealthcarePrice;

public interface HealthcarePriceRepository extends CrudRepository<HealthcarePrice, Long> {
	
	@Query(value="SELECT p.* FROM healthcare_price p WHERE :age between p.age_from and p.age_to ", nativeQuery=true)
    HealthcarePrice findByAge(@Param("age") int age);

}
