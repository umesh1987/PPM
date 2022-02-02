package com.ppm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppm.dto.ProjectDto;
import com.ppm.entity.Project;
import com.ppm.exceptions.ProjectIdentifierException;
import com.ppm.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectDto saveOrUpdateProject(ProjectDto projectDto) {
		Project project = mapToEntity(projectDto);
		try {
			Project newProject = projectRepository.save(project);
			return mapToDto(newProject);
		} catch (Exception e) {
			throw new ProjectIdentifierException("Project ID '" + project.getProjectIdentifier() + "' already exisit.");
		}
	}
	
	public ProjectDto findByProjectIdentifier(String projectIdentifier) {
		Project findProject = projectRepository.findByProjectIdentifier(projectIdentifier);
		
		if(findProject == null) {
			throw new ProjectIdentifierException("Project ID '" + projectIdentifier + "' does not exisit.");
		}
		return mapToDto(findProject);
	}
	
	public List<Project> findAllProjects() {
		return projectRepository.findAll();
		
	}
	
	public void deleteProjectByIdentifier(String projectIdentifier) {
		Project project = projectRepository.findByProjectIdentifier(projectIdentifier);
		if(project == null) {
			throw new ProjectIdentifierException("Project ID '" + projectIdentifier + "' does not exisit to delete.");	
		}
		projectRepository.delete(project);
	}
	
	private Project mapToEntity(ProjectDto projectDto) {
		Project project = new Project();
		project.setProjectName(projectDto.getProjectName());
		project.setProjectIdentifier(projectDto.getProjectIdentifier().toUpperCase());
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
