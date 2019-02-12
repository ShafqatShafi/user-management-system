package com.example.app.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	@NotEmpty
	@NotBlank
	@Column(name="user_name")
	private String username;
	
	@NotEmpty
	@NotBlank
	@Column(name="first_name")
	private String firstname;
	
	@NotEmpty
	@NotBlank
	@Column(name="last_name")
	private String lastname;
	
	@NotEmpty
	@NotBlank
	@Column(name="password")
	private String password;
	
	@Email
	@Column(name="email")
	private String email;
	
	@Column(name="approved")
	private boolean approved;
	
}
