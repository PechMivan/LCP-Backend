package com.lcp.app.entity;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "users")
@AttributeOverride(name = "ID", column = @Column(name = "user_id"))
public class User extends Customer {
	
	@Column(name="email", length=200, unique = true, nullable=false)
	private String email;

	@Column(name="password", length=64, nullable=false)
	private String password;
	
	@Builder
	User(Long ID, String uuid, String name,String lastname,String lastname2,String sex,
		 LocalDate birthdate,String phonenumber, boolean isActive, Role role,
		 String email, String password){
		super(ID, uuid, name, lastname, lastname2, sex, birthdate, phonenumber, isActive, role);
		this.email = email;
		this.password = password;
	}
}
