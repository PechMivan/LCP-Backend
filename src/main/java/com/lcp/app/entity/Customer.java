package com.lcp.app.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="customer_id")
private Long ID;
@Column(name="uuid", columnDefinition = "VARCHAR(255)", updatable = false, nullable = true)
private String uuid;
@Column(name="name", length=100, nullable=false)
private String name;
@Column(name="lastname", length=100, nullable=false)
private String lastName;
@Column(name="lastname2", length=100)
private String lastName2;
@Column(name="sex", length=10, nullable=false)
private String sex;
@Column(name="birthdate", columnDefinition = "date" , nullable=false)
private LocalDate birthDate;
@Column(name="phonenumber", length=15, nullable=false)
private String phonenumber;
@Column(name="active", columnDefinition="boolean default true", nullable=false)
private boolean isActive;
@ManyToOne
@JoinColumn(name="fk_role_id", nullable=false)
private Role role;

}
