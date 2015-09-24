package com.security.mongo.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post {
	@Id
	private String id;
	private String id_utilisateur;
	private Date date;
	private String contenu;
	private String olm;
	
	
	public Post(String id_utilisateur, Date date, String contenu, String olm) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.date = date;
		this.contenu = contenu;
		this.olm = olm;
	}

	public Post() {
		super();
	}

	public String getOlm() {
		return olm;
	}

	public void setOlm(String olm) {
		this.olm = olm;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(String id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", id_utilisateur=" + id_utilisateur
				+ ", date=" + date + ", contenu=" + contenu + ", olm=" + olm
				+ "]";
	}



}
