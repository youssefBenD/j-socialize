package com.security.mongo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.mongo.domain.Stage;
import com.security.mongo.domain.Utilisateur;
import com.security.mongo.repository.StageService;
import com.security.mongo.repository.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value = "/stage", method = RequestMethod.GET)
public class StageController {
	@Autowired
	private UserService userService;
	@Autowired
	private StageService stageService;

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String listeStage(Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));
		model.addAttribute("stages", this.stageService.listStages());
		
		return "stageListe";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String nouveauStage(Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));

		return "stageNouveau";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String nouveauStage(@ModelAttribute(value = "stage") Stage stage,
			Model model, Principal principal) {
		Utilisateur u = (userService.getUserByUsername(principal.getName()));
		model.addAttribute("jciUser", u);
		Stage stageBis = new Stage(stage.getSociete(), u.getId(),
				stage.getDescription(), stage.getMois(), stage.getMois(),
				stage.getDomaine(), stage.getEmail(), stage.getPays(),
				stage.getDurée());

		this.stageService.addStage(stageBis);

		return "stageListe";

	}

	public StageService getStageService() {
		return stageService;
	}

	public void setStageService(StageService stageService) {
		this.stageService = stageService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}