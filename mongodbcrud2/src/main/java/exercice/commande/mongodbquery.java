package exercice.commande;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import model.client;
import model.command;
import model.produit;

public class mongodbquery {
	String uri ="mongodb://localhost:27017";
	MongoClient c = MongoClients.create(uri);
	
	MongoDatabase database= c.getDatabase("gestion_commandes");
	MongoCollection<Document> commandes = database.getCollection("commandes");
	MongoCollection<Document> clients = database.getCollection("client");
	MongoCollection<Document> produits = database.getCollection("produit");
	//"""""""""""""""""""""""""""""""""commande"""""""""""""""""""""""""""""""""""""""
	//find all documents(commandes) from a collection
	public FindIterable<Document> findall() {
	FindIterable<Document> alldoc=commandes.find();
	return alldoc;
	}
	//find document with Pnom "phone"
	public FindIterable<Document> findn(String date) {
	FindIterable<Document> docwithPnom =commandes.find(new Document("date",date));
	return docwithPnom;
	}
	//delete by id
	public void deletecommende(ObjectId  id) {
		System.out.println("methode supprrimer"+id);
		commandes.deleteOne(Filters.eq("_id",id));
	}
   //ajouter une commande
	public void ajoutercomm(command c) {
	Document e = new Document("nom_c", c.getNom_c()).append("nom_p", c.getNom_p())
			.append("qtt", c.getQtt()).append("date", c.getDate());
	commandes.insertOne(e);
	}
	//chercher une commande avec id
	public FindIterable<Document>  findonecom(ObjectId id) {
	FindIterable<Document> docwithPnom =commandes.find(new Document("_id",id));
    return docwithPnom;
	}
//modifier commande
		public void modifiercom(ObjectId id, command c) {
			commandes.updateOne(Filters.eq("_id", id),Updates.set("nom_c", c.getNom_c()));
			commandes.updateOne(Filters.eq("_id", id),Updates.set("nom_p", c.getNom_p()));
			commandes.updateOne(Filters.eq("_id", id),Updates.set("qtt", c.getQtt()));
			commandes.updateOne(Filters.eq("_id", id),Updates.set("date", c.getDate()));			
		}
	//"""""""""""""""""""""""""""""""""client"""""""""""""""""""""""""""""""""""""""
	//find all documents(clients) from a collection
		public FindIterable<Document> findallc() {
		FindIterable<Document> alldoc=clients.find();
		return alldoc;
		}
		//find all noms(clients) from a collection
		public List<String> findallnomc() {
		FindIterable<Document> alldoc=clients.find();
		 List<String> liste = new ArrayList<String>();
		 for(Document i : alldoc) {
			liste.add(i.getString("nom"));
		 }
		return  liste ;
		}
		 //ajouter un client
		public void ajouterclient(model.client c) {
		Document e = new Document("nom",c.getNom() ).append("prenom", c.getPrenom()).append("adress", c.getAdress())
				.append("Phone", c.getPhone());
		clients.insertOne(e);
		}
		//delete by id client
		public void deleteclient(ObjectId id) {
			System.out.println(id+"service");
			clients.deleteOne(Filters.eq("_id",id));
		}
		//find client with nom 
		public FindIterable<Document> findclientn(String nom) {
		FindIterable<Document> docwithPnom =clients.find(new Document("nom",nom));
		return docwithPnom;
		}
		//chercher un client avec id
		public FindIterable<Document>  findoneCl(ObjectId id) {
	    FindIterable<Document> docwithPnom =clients.find(new Document("_id",id));
		return docwithPnom;
		}
	
		//modifier client
		public void modifiercl(ObjectId id,client c) {
	    clients.updateOne(Filters.eq("_id", id),Updates.set("nom", c.getNom()));
	    clients.updateOne(Filters.eq("_id", id),Updates.set("prenom", c.getPrenom()));
	    clients.updateOne(Filters.eq("_id", id),Updates.set("adress", c.getAdress()));
	    clients.updateOne(Filters.eq("_id", id),Updates.set("Phone", c.getPhone()));
		}
		//"""""""""""""""""""""""""""""""""produit"""""""""""""""""""""""""""""""""""""""
		//find all documents(produits) from a collection
		public FindIterable<Document> findallp() {
		FindIterable<Document> alldoc=produits.find();
		return alldoc;
		}
		//find all noms(produits) from a collection
		public List<String> findallnomp() {
		FindIterable<Document> alldoc=produits.find();
		 List<String> liste = new ArrayList<String>();
		 for(Document i : alldoc) {
			liste.add(i.getString("Pnom"));
		 }
		return  liste ;
		}
		public void deleteproduit(ObjectId id) {
			System.out.println(id+"service");
			produits.deleteOne(Filters.eq("_id",id));			
		}
		public void ajouterproduit(produit c) {
			Document e = new Document("Pnom",c.getPnom() ).append("prix", c.getPrix()).append("couleur", c.getCouleur())
					.append("caract", c.getCaract());
			produits.insertOne(e);
			
		}
		public FindIterable<Document> findproduitn(String nom) {
			FindIterable<Document> docwithPnom =produits.find(new Document("Pnom",nom));
			return docwithPnom;
		}
		//chercher un produit avec id
	    public FindIterable<Document>  findonep(ObjectId id) {
	    FindIterable<Document> docwithPnom =produits.find(new Document("_id",id));
		return docwithPnom;
		}
		public void modifierprt(ObjectId id, produit c) {
	    produits.updateOne(Filters.eq("_id", id),Updates.set("Pnom", c.getPnom()));
	    produits.updateOne(Filters.eq("_id", id),Updates.set("prix", c.getPrix()));
	    produits.updateOne(Filters.eq("_id", id),Updates.set("couleur", c.getCouleur()));
	    produits.updateOne(Filters.eq("_id", id),Updates.set("Caract", c.getCaract()));
		}
		
}
