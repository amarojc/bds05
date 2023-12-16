package com.devsuperior.movieflix.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.movieflix.entities.User;


public class UserRoleDTO extends UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	Set<RoleDTO> roles = new HashSet<>();

		
	public UserRoleDTO(Long id, String name, String email, Set<RoleDTO> roles) {
		super(id, name, email);
		this.roles = roles;
	}

	public UserRoleDTO(User user) {
		super(user);
		user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));		
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

}
