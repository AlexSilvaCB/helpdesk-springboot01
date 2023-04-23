package com.alex.helpdesk.domain.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.alex.helpdesk.domain.enums.Profile;

public abstract class Entities {
	
	protected Long id;
	protected String name;
	protected String cpf;
	protected String email;
	protected String password;
	
	protected Set<Integer> profiles = new HashSet<>();
	
	protected Instant dataCreate = Instant.now();
	
	public Entities() {
		super();
		addProfiles(Profile.CLIENT);
	}
	
	public Entities(Long id, String name, String cpf, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		addProfiles(Profile.CLIENT);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}


	public void addProfiles(Profile profile) {
		this.profiles.add(profile.getCode());
	}


	public Instant getDataCreate() {
		return dataCreate;
	}


	public void setDataCreate(Instant dataCreate) {
		this.dataCreate = dataCreate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entities other = (Entities) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	
	
	

}
