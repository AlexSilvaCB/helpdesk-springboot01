package com.alex.helpdesk.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Long;

import com.alex.helpdesk.domain.dto.ClientDTO;
import com.alex.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "TB_CLIENT")
public class Client extends Entities {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Called> calleds = new ArrayList<>();

	public Client() {
		super();
		addProfiles(Profile.CLIENT);
	}

	public Client(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfiles(Profile.CLIENT);
	}
	
	public Client (ClientDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.dataCreate = obj.getDataCreate();
	}

	public List<Called> getCalleds() {
		return calleds;
	}

	public void setCalleds(List<Called> calleds) {
		this.calleds = calleds;
	}
	
	
	
	
}
