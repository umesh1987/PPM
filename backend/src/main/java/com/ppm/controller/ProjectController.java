package com.ppm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.dto.ProjectDto;
import com.ppm.entity.Project;
import com.ppm.service.ProjectService;

@RestController
@RequestMapping("api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectDto projectDto, BindingResult result) {
		
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error: result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(projectService.saveOrUpdateProject(projectDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getByProjectIdentifier(@RequestBody ProjectDto projectDto) {
		ProjectDto project = projectService.findByProjectIdentifier(projectDto.getProjectIdentifier());
		return new ResponseEntity<>(project,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public List<Project> getAllProjects(){
		return projectService.findAllProjects();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProjectByIdentifier(@RequestBody ProjectDto projectDto) {
		projectService.deleteProjectByIdentifier(projectDto.getProjectIdentifier());
		return new ResponseEntity<>("Project ID '" + projectDto.getProjectIdentifier() + " deleted.", HttpStatus.OK);
		
	}

}
