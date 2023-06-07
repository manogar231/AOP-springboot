package com.eminds.apoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {

	private String username;
	private String mail;
	private String useraddress;
	private String password;
}
