package com.lcp.app.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcp.app.dto.UserDTO;
import com.lcp.app.entity.Role;
import com.lcp.app.entity.User;
import com.lcp.app.repository.RoleRepository;

@Service
public class UserMapper extends AbstractMapper<User, UserDTO>{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public UserDTO fromEntity(User user) {
		if(user == null) {
			return null;
		}
		
		String fullname = user.getName() + " " + user.getLastName();
		if(user.getLastName2() != null) {
			fullname = fullname + " " + user.getLastName2();
		}
		
		return UserDTO.builder()
				   .uuid(user.getUuid())
				   .fullName(fullname)
				   .birthdate(user.getBirthDate().toString())
				   .sex(user.getSex())
				   .email(user.getEmail())
				   .phonenumber(user.getPhonenumber())
				   .role(user.getRole().getRoleName())
				   .build();
	}
	
	@Override
	public User fromDTO(UserDTO userDTO) {
		if(userDTO == null) {
			return null;
		}
		
		String[] fullname = userDTO.getFullName().split(" ");
		String name = fullname[0];
		String lastname = fullname[1];
		String lastname2 = null;
		if(fullname.length > 2) {
			lastname2 = fullname[2];
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd" ) ;
		String birthdate = userDTO.getBirthdate().formatted(formatter);
		LocalDate formattedBirthdate = LocalDate.parse(birthdate);
		
		Role userRole = roleRepository.findByRoleName(userDTO.getRole());
		
		return User.builder()
				   .uuid(UUID.randomUUID().toString())
				   .name(name)
				   .lastname(lastname)
				   .lastname2(lastname2)
				   .birthdate(formattedBirthdate)
				   .sex(userDTO.getSex())
				   .email(userDTO.getEmail())
				   .phonenumber(userDTO.getPhonenumber())
				   .role(userRole)
				   .build();
	}

}
