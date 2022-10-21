package model;

import org.bson.types.ObjectId;

public class command {
	private ObjectId id;
	private String nom_p;
	private String nom_c;
	private int qtt;
	private String date;
	private String prenom_c;
	private String adress;
	private String phone;
	private String couleur;
	private String caract;
	private int prix;
	
	public command() {
		super();
		// TODO Auto-generated constructor stub
	}
	public command( String nom_p, String nom_c, int qtt, String date) {
		super();
		this.nom_p = nom_p;
		this.nom_c = nom_c;
		this.qtt = qtt;
		this.date = date;
	}
	public command(ObjectId id, String nom_p, String nom_c, int qtt, String date) {
		super();
		this.id = id;
		this.nom_p = nom_p;
		this.nom_c = nom_c;
		this.qtt = qtt;
		this.date = date;
	}
	public command(ObjectId id, String nom_p, String nom_c, int qtt, String date, String prenom_c, String adress,
			String phone, String couleur, String caract, int prix) {
		super();
		this.id = id;
		this.nom_p = nom_p;
		this.nom_c = nom_c;
		this.qtt = qtt;
		this.date = date;
		this.prenom_c = prenom_c;
		this.adress = adress;
		this.phone = phone;
		this.couleur = couleur;
		this.caract = caract;
		this.prix = prix;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNom_p() {
		return nom_p;
	}
	public void setNom_p(String nom_p) {
		this.nom_p = nom_p;
	}
	public String getNom_c() {
		return nom_c;
	}
	public void setNom_c(String nom_c) {
		this.nom_c = nom_c;
	}
	public int getQtt() {
		return qtt;
	}
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrenom_c() {
		return prenom_c;
	}
	public void setPrenom_c(String prenom_c) {
		this.prenom_c = prenom_c;
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
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getCaract() {
		return caract;
	}
	public void setCaract(String caract) {
		this.caract = caract;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	
}
