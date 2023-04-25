package com.alex.helpdesk.domain.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TechnicalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	protected String name;
	protected String cpf;	
	protected String email;
	protected String password;
	protected Set<Integer> profiles = new HashSet<>();
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="America/Sao_Paulo")
	protected Instant dataCreate = Instant.now();

	public TechnicalDTO() {
		super();
		addProfiles(Profile.CLIENT);	
	}

	public TechnicalDTO(Technical obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.dataCreate = obj.getDataCreate();
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
	
	
	
	
	
	

}
