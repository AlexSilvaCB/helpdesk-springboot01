package com.alex.helpdesk.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.alex.helpdesk.domain.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "TB_CLIENT")
public class Client extends Entities {
	private static final long serialVersionUID = 1L;
	
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

	public List<Called> getCalleds() {
		return calleds;
	}

	public void setCalleds(List<Called> calleds) {
		this.calleds = calleds;
	}
	
	
	
	
}
