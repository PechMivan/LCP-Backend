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
public class SignupRequestDto {

	private String name;
	private String lastName;
	private String lastName2;
	private String sex;
	private String birthDate;
	private String phonenumber;
	private String password;
	
}
