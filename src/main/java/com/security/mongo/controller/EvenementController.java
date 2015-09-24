package com.security.mongo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.mongo.domain.Evenement;
import com.security.mongo.repository.EvenementService;
import com.security.mongo.repository.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value = "/evenement", method = RequestMethod.GET)
public class EvenementController {
	@Autowired
	private UserService userService;
	@Autowired
	private EvenementService evenementService;

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String listeStage(Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));
		model.addAttribute("evenements",
				this.evenementService.listEvenements());

		return "evenementListe";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String nouveauEvenement(Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));
		model.addAttribute("evenement", new Evenement());
		return "evenementNouveau";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String nouveauEvenement(
			@ModelAttribute(value = "evenement") Evenement ev,
			Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));
		Evenement evenement = new Evenement(ev.getNom(), ev.getJour(), ev.getMois(),ev.getAnnee(),userService.getUserByUsername(principal.getName()).getId(),
				ev.getDescription(),0,ev.getLieu(), userService.getUserByUsername(principal.getName()).getOlm());
		this.evenementService.addEvenement(evenement);
		return "evenementListe";

	}

	public EvenementService getEvenementService() {
		return evenementService;
	}

	public void setEvenementService(EvenementService evenementService) {
		this.evenementService = evenementService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}