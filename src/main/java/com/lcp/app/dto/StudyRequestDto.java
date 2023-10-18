package com.lcp.app.dto;

import lombok.Getter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StudyRequestDto {

	private String name;
	private String indications;
	private String waitTime;
	private CategoryDto category;
}

