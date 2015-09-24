package com.security.mongo.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Commentaire {
	@Id 
	private String id;
	private String contenu;
	private String id_post;
	private Date date;
	private String id_utilisateur;
	
	
	public Commentaire(String contenu, String id_post, Date date,
			String id_utilisateur) {
		super();
		this.contenu = contenu;
		this.id_post = id_post;
		this.date = date;
		this.id_utilisateur = id_utilisateur;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getId_post() {
		return id_post;
	}
	public void setId_post(String id_post) {
		this.id_post = id_post;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(String id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", contenu=" + contenu + ", id_post="
				+ id_post + ", date=" + date + ", id_utilisateur="
				+ id_utilisateur + "]";
	}

	

}
