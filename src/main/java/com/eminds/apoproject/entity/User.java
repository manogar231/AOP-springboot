package com.eminds.apoproject.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "user_data")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column(name = "user_name" , unique = true)
	private String username;
	@Column(name = "mail")
	private String mail;
	@Column(name = "user_address")
	private String useraddress;
	@Column(name = "create_at")
	private LocalDate createdAt;
	@Column(name = "update_at")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(name = "password")
	private String password;
	@Column(name = "user_status")
	private String status;
	@Column(name = "last_login")
	private Date lastlogin;
	@Column(name = "OTP")
	private String resetOtp;
}
