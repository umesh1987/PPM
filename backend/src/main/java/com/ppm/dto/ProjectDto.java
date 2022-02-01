package com.ppm.dto;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
public class ProjectDto {
	private Long id;
	private String projectName;
	private String projectIdentifier;
	private String description;
	private Date startDate;
	private Date endDate;
	
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
