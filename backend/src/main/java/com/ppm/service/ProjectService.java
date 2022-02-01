package com.ppm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppm.dto.ProjectDto;
import com.ppm.entity.Project;
import com.ppm.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectDto saveOrUpdateProject(ProjectDto projectDto) {
		Project project = mapToEntity(projectDto);
		Project newProject = projectRepository.save(project);
		return mapToDto(newProject);
	}
	
	private Project mapToEntity(ProjectDto projectDto) {
		Project project = new Project();
		project.setProjectName(projectDto.getProjectName());
		project.setProjectIdentifier(projectDto.getProjectIdentifier());
		project.setDescription(projectDto.getDescription());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setCreatedDate(projectDto.getCreatedDate());
		project.setUpdateddate(projectDto.getUpdatedDate());
		return project;
		
	}
	
	private ProjectDto mapToDto(Project project) {
		ProjectDto projectDto = new ProjectDto();
		projectDto.setId(project.getId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setProjectIdentifier(project.getProjectIdentifier());
		projectDto.setDescription(project.getDescription());
		projectDto.setStartDate(project.getStartDate());
		projectDto.setEndDate(project.getEndDate());
		projectDto.setCreatedDate(project.getCreatedDate());
		projectDto.setUpdatedDate(project.getUpdateddate());
		return projectDto;		
	}

}
