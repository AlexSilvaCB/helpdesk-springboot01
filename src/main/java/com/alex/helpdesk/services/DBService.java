package com.alex.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.entities.Called;
import com.alex.helpdesk.domain.entities.Client;
import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.domain.enums.Priority;
import com.alex.helpdesk.domain.enums.Profile;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositories.CalledRepository;
import com.alex.helpdesk.repositories.EntitiesRepository;

@Service
public class DBService {

	@Autowired
	private EntitiesRepository eRepository;
	
	@Autowired
	private CalledRepository calRepository;

	
	public void instanceDB() {
		Technical tec1 = new Technical(null, "Guilherme", "961.855.230-60", "gui@email.com","123456");
		tec1.addProfiles(Profile.ADMIN);
		Technical tec2 = new Technical(null, "Richard Stall", "903.347.070-56", "stallman@email.com", "123456");
		Technical tec3 = new Technical(null, "Claude", "271.068.470-54", "claude@email.com", "123456");
		Technical tec4 = new Technical(null, "Tim", "162.720.120-39", "lee@mail.com", "123456");
		Technical tec5 = new Technical(null, "Linus", "778.556.170-27", "linus@email.com","123456");
		
		Client cli1 = new Client(null, "Albert", "111.661.890-74", "einsten@email.com", "123456");
		Client cli2 = new Client(null, "Marie", "322.429.140-06", "marie@email.com", "123456");
		Client cli3 = new Client(null, "Charles", "792.043.830-62", "charles@email.com", "123456");
		Client cli4 = new Client(null, "Stephen", "177.409.680-30", "stephen@email.com", "123456");
		Client cli5 = new Client(null, "Max", "081.399.300-83", "planck@email.com", "123456");
		
		
		Called c1 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Chamado 1", "Teste chamado 1", cli1, tec1);
		Called c2 = new Called(null, Priority.HIGH, Status.OPEN, "Chamado 2", "Teste chamado 2", cli2, tec1);
		Called c3 = new Called(null, Priority.LOW, Status.CLOSED, "Chamado 3", "Teste chamado 3", cli3, tec2);
		Called c4 = new Called(null, Priority.HIGH, Status.OPEN, "Chamado 4", "Teste chamado 4", cli3, tec3);
		Called c5 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Chamado 5", "Teste chamado 5", cli1, tec2);
		Called c6 = new Called(null, Priority.LOW, Status.CLOSED, "Chamado 6", "Teste chamado 6", cli5, tec5);
		
		eRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		calRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
	}
	
}
