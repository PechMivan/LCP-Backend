package com.lcp.app.mapper;

import org.springframework.stereotype.Service;

import com.lcp.app.dto.CustomerDTO;
import com.lcp.app.entity.Customer;

@Service
public class CustomerMapper extends AbstractMapper<Customer, CustomerDTO>{
	
	@Override
	public CustomerDTO fromEntity(Customer customer) {
		if(customer == null) {
			return null;
		}
		
		return CustomerDTO.builder()
				   .uuid(null)
				   .fullName(null)
				   .birthDate(null)
				   .sex(null)
				   .email(null)
				   .phonenumber(null)
				   .build();
	}
	
	@Override
	public Customer fromDTO(CustomerDTO customerDTO) {
		if(customerDTO == null) {
			return null;
		}
		
		return Customer.builder()
				   .name(null)
				   .lastName(null)
				   .lastName2(null)
				   .birthDate(null)
				   .sex(null)
				   .email(null)
				   .phonenumber(null)
				   .build();
	}

}
