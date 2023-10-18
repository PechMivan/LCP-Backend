package com.lcp.app.dto;

import lombok.Getter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AppointmentDto {

	private String uuid;
	private String fullName;
	private String dateTime;
	private String sex;
	private String birthDate;
	private String phonenumber;
	private String email;
	private String urlAnalisis;
	private List<StudyResponseDto> studies;
}
