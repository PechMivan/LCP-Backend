package com.lcp.app.service;

import java.util.List;

import com.lcp.app.entity.Study;

public interface StudyService {

	
	Study createStudy( Study study);
	
	Study getStudyById(Long id);
	
	List<Study> getAllStudies();
	
	Study updateStudy(Study study, Long id);
	
	Study deleteStudy(Long id);
}