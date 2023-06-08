package com.eminds.apoproject.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eminds.apoproject.dto.Userdto;
import com.eminds.apoproject.entity.User;
import com.eminds.apoproject.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	 ModelMapper modelMapper;
	
	public Object saveUserInformation(Userdto userdto) {
		User users = new User();
		users.setUsername(userdto.getUsername());
		users.setUseraddress(userdto.getUseraddress());
		users.setMail(userdto.getMail());
		users.setPassword(userdto.getPassword());
		return userRepository.save(users);
	}
	public Userdto findUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) { 
			log.info("User is Not Available");
		}			
		Userdto userdto=modelMapper.map(user.get(),Userdto.class);
		return userdto;
	}

	public List<Userdto> getAlluser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(User -> modelMapper.map(User, Userdto.class)).collect(Collectors.toList());
	}

	public Object updateUserById(int id, Userdto user) throws Exception {
		User user1 = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

		if (Objects.nonNull(user.getUsername())) {
			user1.setUsername(user.getUsername());
		}
		if (Objects.nonNull(user.getUseraddress())) {
			user1.setUseraddress(user.getUseraddress());
		}
		return userRepository.save(user1);

	}

	public Object deleteUserbyid(int id) {
		Optional<User> user1 = userRepository.findById(id);
		if (user1.isEmpty()) {
			return "User Not Found !!";
		}
		userRepository.deleteById(id);;
		return "User deleted successfully";
	}

	

}
