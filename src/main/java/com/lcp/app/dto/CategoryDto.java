package com.lcp.app.dto;

import java.util.List;

import com.lcp.app.entity.Study;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryDto {

	private String name;
	private String urlCategory;
	private List<Study> studies;
}
