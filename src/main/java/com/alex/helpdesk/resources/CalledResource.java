package com.alex.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.helpdesk.domain.dto.CalledDTO;
import com.alex.helpdesk.domain.entities.Called;
import com.alex.helpdesk.services.CalledService;

@RestController
@RequestMapping(value = "/called")
public class CalledResource {

	@Autowired
	private CalledService calledService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CalledDTO> findById(@PathVariable Long id) {
		Called obj = calledService.findById(id);
		return ResponseEntity.ok().body(new CalledDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<CalledDTO>> findAll(){
		List<Called> list = calledService.findAll();
		List<CalledDTO> listDTO = list.stream().map(obj -> new CalledDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
