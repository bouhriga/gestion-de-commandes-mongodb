package model;

import org.bson.types.ObjectId;

public class client {
	private ObjectId id;
	private String nom;
	private String prenom;
	private String adress;
	private String phone;
	public client() {
		super();
	}
	public client( String nom, String prenom, String adress, String phone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.phone = phone;
	}
	public client(ObjectId id, String nom, String prenom, String adress, String phone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.phone = phone;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
