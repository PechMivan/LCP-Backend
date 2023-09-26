package com.lcp.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.lcp.app.entity.Study;

public interface StudyRepository extends CrudRepository< Study, Long>{
	
	List<Study> findByName(String name);

	Study findById(long study_id);
	
}