package com.security.mongo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.mongo.mapReduce.AgeUtilisateursMapReduce;
import com.security.mongo.mapReduce.PostsMR;
import com.security.mongo.mapReduce.UsersMR;
import com.security.mongo.repository.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value = "/statistique", method = RequestMethod.GET)
public class StatUtilisateurController {

	@Autowired
	private UserService userService;
	@Autowired
	private AgeUtilisateursMapReduce ageUtilisateursMapReduce;
	@Autowired
	private PostsMR postMR;
	@Autowired
	private UsersMR userMR;

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public String listeStage(Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));
		model.addAttribute("mapReduceOutputPost", this.postMR.postsStats());
		model.addAttribute("mapReduceOutput", this.ageUtilisateursMapReduce.statUtilisateurs());
		model.addAttribute("mapReduceOutputUser", this.userMR.classifierAge());
		model.addAttribute("mapReduceOutputUserNombre", this.userMR.nombreUtilisateurs());
		return "statistique";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AgeUtilisateursMapReduce getAgeUtilisateursMapReduce() {
		return ageUtilisateursMapReduce;
	}

	public void setAgeUtilisateursMapReduce(
			AgeUtilisateursMapReduce ageUtilisateursMapReduce) {
		this.ageUtilisateursMapReduce = ageUtilisateursMapReduce;
	}

	public PostsMR getPostMR() {
		return postMR;
	}

	public void setPostMR(PostsMR postMR) {
		this.postMR = postMR;
	}

	public UsersMR getUserMR() {
		return userMR;
	}

	public void setUserMR(UsersMR userMR) {
		this.userMR = userMR;
	}
	
	

}
