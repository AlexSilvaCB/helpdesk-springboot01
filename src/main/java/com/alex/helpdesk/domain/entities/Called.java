package com.alex.helpdesk.domain.entities;

import java.time.Instant;
import java.util.Objects;

import com.alex.helpdesk.domain.enums.Priority;
import com.alex.helpdesk.domain.enums.Status;

public class Called {

	private Long id;
	private Instant openDate = Instant.now();
	private Instant closedate;
	
	private Priority priority;
	private Status status;
	
	private String title;
	private String comments;
	
	private Client client;
	private Technical technical;
	
	public Called() {
		super();
	}

	public Called(Long id, Priority priority, Status status, String title, String comments, Client client,
			Technical technical) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.comments = comments;
		this.client = client;
		this.technical = technical;
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

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Technical getTechnical() {
		return technical;
	}

	public void setTechnical(Technical technical) {
		this.technical = technical;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Called other = (Called) obj;
		return Objects.equals(id, other.id);
	}
}
