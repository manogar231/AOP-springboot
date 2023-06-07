package com.eminds.apoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eminds.apoproject.dto.Userdto;
import com.eminds.apoproject.service.UserService;
import com.eminds.apoproject.util.PrintOne;

@Controller
@RequestMapping("/useraop")
public class UserController {

	@Autowired
	private UserService userservices;

	@PrintOne
	@PostMapping("/save")
	public ResponseEntity<Object> saveUser(@RequestBody Userdto userdto) {
		return ResponseEntity.ok().body(userservices.saveUserInformation(userdto));
	}
	@PrintOne
	@GetMapping("/getuser/{id}")
	public ResponseEntity<Userdto> finduserbyid(@PathVariable(value = "id") int id) throws Exception {
		Userdto userdto = userservices.findUserById(id);
        return ResponseEntity.ok(userdto);
	}
	@PrintOne
	@GetMapping("/alluser")
	public ResponseEntity<List<Userdto>>  getallUsers() {
		return ResponseEntity.ok(userservices.getAlluser());
	}
	@PrintOne
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateuser(@PathVariable(value = "id") Integer userid, @RequestBody Userdto user) throws Exception {
		return ResponseEntity.ok(userservices.updateUserById(userid, user));
	}
	@PrintOne
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteuser(@PathVariable(value = "id") int userid){
		return ResponseEntity.ok(userservices.deleteUserbyid(userid));
	}

}
