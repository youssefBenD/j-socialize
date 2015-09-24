package com.security.mongo.domain;

public class Stage {
	private String id;
	private String societe;
	private String id_utilisateur;
	private String description;
	private int mois;
	private int année;
	private String domaine;
	private String email;
	private String pays;
	private int durée;

	

	public Stage() {
		super();
	}

	
	public Stage(String societe, String id_utilisateur, String description,
			int mois, int année, String domaine, String email, String pays,
			int durée) {
		super();
		this.societe = societe;
		this.id_utilisateur = id_utilisateur;
		this.description = description;
		this.mois = mois;
		this.année = année;
		this.domaine = domaine;
		this.email = email;
		this.pays = pays;
		this.durée = durée;
	}


	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Stage [id=" + id + ", societe=" + societe + ", id_utilisateur="
				+ id_utilisateur + ", description=" + description + ", mois="
				+ mois + ", année=" + année + ", domaine=" + domaine
				+ ", email=" + email + ", pays=" + pays + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(String id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnée() {
		return année;
	}

	public void setAnnée(int année) {
		this.année = année;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}


	public int getDurée() {
		return durée;
	}


	public void setDurée(int durée) {
		this.durée = durée;
	}
	
	

}
