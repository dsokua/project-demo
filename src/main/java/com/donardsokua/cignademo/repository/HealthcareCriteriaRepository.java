package com.donardsokua.cignademo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.donardsokua.cignademo.model.HealthcareCriteria;

public interface HealthcareCriteriaRepository extends CrudRepository<HealthcareCriteria, Long>{

	public List<HealthcareCriteria> findByHealthcareCriteriaIdIn(List<Long> idList);
}
