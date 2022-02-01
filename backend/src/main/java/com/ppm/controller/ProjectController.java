package com.ppm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.dto.ProjectDto;
import com.ppm.service.ProjectService;

@RestController
@RequestMapping("api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/create")
	public ResponseEntity<ProjectDto> createNewProject(@RequestBody ProjectDto projectDto) {
		return new ResponseEntity<>(projectService.saveOrUpdateProject(projectDto), HttpStatus.CREATED);
	}

}
