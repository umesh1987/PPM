package com.ppm.dto;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProjectDto {
	private Long id;
	
	@NotBlank(message = "Project Name is Required.")
	private String projectName;
	
	@NotBlank(message = "Project Identifier is Required")
	@Size(min = 4, max = 5, message = "Project Identifier Must Be 4 and 5 Characters.")
	private String projectIdentifier;
	
	@NotBlank(message = "Project Description is Required.")
	private String description;
	
	private Date startDate;
	private Date endDate;
	
	private Date createdDate;
	private Date updatedDate;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedDate = new Date();
	}

}
