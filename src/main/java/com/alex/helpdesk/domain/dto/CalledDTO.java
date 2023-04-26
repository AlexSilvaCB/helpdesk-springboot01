package com.alex.helpdesk.domain.dto;

import java.io.Serializable;
import java.time.Instant;

import com.alex.helpdesk.domain.entities.Called;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public class CalledDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="America/Sao_Paulo")
	private Instant openDate = Instant.now();
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="America/Sao_Paulo")
	private Instant closedate;
	
	@NotNull(message = "The PRIORITY field is required")
	private Integer priority;
	@NotNull(message = "The NAME field is required")
	private Integer status;
	@NotNull(message = "The TITLE field is required")
	private String title;
	@NotNull(message = "The COMMENTS field is required")
	private String comments;
	@NotNull(message = "The CLIENT field is required")
	private Long client;
	@NotNull(message = "The TECHNICAL field is required")
	private Long technical;
	
	private String nameClient;
	private String nameTechnical;
	
	public CalledDTO() {
		super();
	}

	public CalledDTO(Called obj) {
		super();
		this.id = obj.getId();
		this.openDate = obj.getOpenDate();
		this.closedate = obj.getClosedate();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.comments = obj.getComments();
		this.client = obj.getClient().getId();
		this.technical = obj.getTechnical().getId();
		this.nameClient = obj.getClient().getName();
		this.nameTechnical = obj.getTechnical().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Instant openDate) {
		this.openDate = openDate;
	}

	public Instant getClosedate() {
		return closedate;
	}

	public void setClosedate(Instant closedate) {
		this.closedate = closedate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public Long getTechnical() {
		return technical;
	}

	public void setTechnical(Long technical) {
		this.technical = technical;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getNameTechnical() {
		return nameTechnical;
	}

	public void setNameTechnical(String nameTechnical) {
		this.nameTechnical = nameTechnical;
	}
}
