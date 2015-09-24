package com.security.mongo.domain;

public class Evenement {
	private String id;
	private String nom;
	private int jour;
	private int mois;
	private int annee;
	private String id_utilisateur;
	private String description;
	private int nbrParticipant;
	private String lieu;
	private String olm;

	public Evenement() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbrParticipant() {
		return nbrParticipant;
	}

	public void setNbrParticipant(int nbrParticipant) {
		this.nbrParticipant = nbrParticipant;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getOlm() {
		return olm;
	}

	public void setOlm(String olm) {
		this.olm = olm;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCreateur() {
		return id_utilisateur;
	}

	public void setCreateur(String id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", jour=" + jour
				+ ", mois=" + mois + ", annee=" + annee + ", id_utilisateur="
				+ id_utilisateur + ", description=" + description
				+ ", nbrParticipant=" + nbrParticipant + ", lieu=" + lieu
				+ ", olm=" + olm + "]";
	}

	public Evenement(String nom, int jour, int mois, int annee,
			String id_utilisateur, String description, int nbrParticipant,
			String lieu, String olm) {
		super();
		this.nom = nom;
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.id_utilisateur = id_utilisateur;
		this.description = description;
		this.nbrParticipant = nbrParticipant;
		this.lieu = lieu;
		this.olm = olm;
	}

}
