package com.cybertek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.implementation.ProjectServiceImpl;
import com.cybertek.implementation.UserServiceImpl;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private ProjectServiceImpl projectService;
	private UserServiceImpl userService;

	@Autowired
	public ProjectController(ProjectServiceImpl projectService, UserServiceImpl userService) {
		this.projectService = projectService;
		this.userService = userService;
	}
	
	@GetMapping("/create")
	public String createProject(Model model) {

		List<ProjectDTO> projects = projectService.getListOfProjectDTO();

		model.addAttribute("projects", projects);
		model.addAttribute("project", new ProjectDTO());
		model.addAttribute("managers", userService.getManagers());

		return "project/create";
	}
	
	
}

