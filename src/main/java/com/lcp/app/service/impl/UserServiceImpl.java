package com.lcp.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lcp.app.dto.UserDTO;
import com.lcp.app.dto.UserRegistrationDTO;
import com.lcp.app.entity.User;
import com.lcp.app.mapper.UserMapper;
import com.lcp.app.repository.UserRepository;
import com.lcp.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public User createUser(UserRegistrationDTO user) {
       User existingUser = getUserByEmail(user.getEmail());
       if(existingUser != null) {
    	   throw new IllegalStateException("User with email" + user.getEmail() + "already exists");
       }
       User newUser = userMapper.fromDTO(user);
       String encryptedPassword = bcrypt.encode(user.getPassword());
       newUser.setPassword(encryptedPassword);
       return saveUser(newUser);
    }

    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
       return userRepository.findById(id)
             .orElseThrow( ()-> new IllegalStateException("User does not exist with id: " + id) );
    }
    
	@Override
	public UserDTO getUserDTOById(Long id) {
		return userMapper.fromEntity(getUserById(id));
	}
    
    @Override
    public User getUserByEmail(String email) {
    	User existingUser = userRepository.findByEmail(email);
        if( existingUser == null) {
            throw new IllegalStateException("User does not exist");
         }
        return existingUser;
    }
    
	@Override
	public UserDTO getUserDTOByEmail(String email) {
		return userMapper.fromEntity(getUserByEmail(email));
	}
    
    public List <User> getUsersByName(String name) {
       List <User> existingUsers = userRepository.findAllByName(name);
             if( existingUsers == null || existingUsers.isEmpty()) {
                throw new IllegalStateException("Users does not exist");
             }
             return existingUsers;
    }
    
	@Override
	public List<UserDTO> getUsersDTOByName(String name) {
		return getUsersByName(name)
			   .stream()
			   .map(user -> userMapper.fromEntity(user))
			   .collect(Collectors.toList());
	}
    
    public List <User> getUsersByLastName(String lastname) {
       List <User> existingUsers = userRepository.findAllByLastName(lastname);
             if( existingUsers == null || existingUsers.isEmpty()) {
                throw new IllegalStateException("Users does not exist");
             }
             return existingUsers;
    }
    
	@Override
	public List<UserDTO> getUsersDTOByLastName(String lastname) {
		return getUsersByLastName(lastname)
			   .stream()
			   .map(user -> userMapper.fromEntity(user))
			   .collect(Collectors.toList());
	}

    @Override
    public List<UserDTO> getAllUsers() {
    	
    	List<User> users = (List<User>) userRepository.findAll();
        return userMapper.fromEntity(users);
    }

    @Override
    public User updateUser(User user, Long id) {
       User existingUser = getUserById(id);
       existingUser.setName(  user.getName()   );
       existingUser.setLastName( user.getLastName());
       existingUser.setLastName2( user. getLastName2());
       existingUser.setSex( user.getSex());
       existingUser.setBirthDate( user.getBirthDate());
       existingUser.setEmail(user.getEmail());
       existingUser.setPhonenumber( user.getPhonenumber());
       String encryptedPassword = bcrypt.encode(user.getPassword());
       existingUser.setPassword(encryptedPassword);
       return saveUser( existingUser );
    }

    @Override
    public User deleteUser(Long id) {
       User existingUser = getUserById(id);
       userRepository.delete(existingUser);
       return existingUser;
    }
    
    public User loginUser(String email, String password) {
        User existingUser = getUserByEmail(email);
        if(existingUser != null) {
     	   if(bcrypt.matches(password, existingUser.getPassword())) {
     		   return existingUser;
     	   }
        }
        throw new IllegalStateException("User or Password Incorrect");
    }

    BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
}