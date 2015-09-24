package com.security.mongo.domain;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Utilisateur {
	@Id
	private String id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private String role;
	private int age;
	private String olm;
	private String sexe;
	private String email;

	
	public Utilisateur(String nom, String prenom, String username,
			String password, String role, int age, String olm, String sexe,
			String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = DigestUtils.sha1Hex(password);
		this.role = role;
		this.age = age;
		this.olm = olm;
		this.sexe = sexe;
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utilisateur() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Utilisateur(String nom, String prenom, String username,
			String password, String role, int age, String olm) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = DigestUtils.sha1Hex(password);
		this.role = role;
		this.age = age;
		this.olm = olm;
	}

	public Utilisateur(String username, String password, String role, int age,
			String olm) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.age = age;
		this.olm = olm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOlm() {
		return olm;
	}

	public void setOlm(String olm) {
		this.olm = olm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getSHA1Password() {
		return password;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", username=" + username + ", password=" + password
				+ ", role=" + role + ", age=" + age + ", olm=" + olm + "]";
	}

}