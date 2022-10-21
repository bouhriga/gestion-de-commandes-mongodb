package model;

import org.bson.types.ObjectId;

public class produit {
	private ObjectId id;
	private String pnom;
	private int prix;
	private String couleur;
	private String caract;
	public produit() {
		super();
	}
	public produit( String pnom, int prix, String couleur, String caract) {
		super();
		this.pnom = pnom;
		this.prix = prix;
		this.couleur = couleur;
		this.caract = caract;
	}
	public produit(ObjectId id, String pnom, int prix, String couleur, String caract) {
		super();
		this.id = id;
		this.pnom = pnom;
		this.prix = prix;
		this.couleur = couleur;
		this.caract = caract;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getPnom() {
		return pnom;
	}
	public void setPnom(String pnom) {
		this.pnom = pnom;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
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
	
}
