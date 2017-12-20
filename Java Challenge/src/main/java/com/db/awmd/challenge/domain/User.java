package com.db.awmd.challenge.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	
	@Column(name="email")
	@Email
	@NotEmpty(message="*Need valid email address")
	private String email;
	
	@Transient
	@NotEmpty(message="Password is mandartory")
	@Column(name="password")
	private String password;
	
	@NotEmpty(message = "Please provide First name")
	private String firstName;
	
	@NotEmpty(message = "Please provide Last name")
	private String lastName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns= @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	

}
