package com.ppm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "projectname")
	private String projectName;
	
	@Column(name = "projectidentifier", updatable = false, unique = true)
	private String projectIdentifier;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "startdate")
	private Date startDate;
	
	@Column(name = "enddate")
	private Date endDate;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "updateddate")
	private Date updateddate;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateddate = new Date();
	}
}
