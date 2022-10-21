package exercice.commande;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class mongodbinsert {
	public static void main(String[] args) {
		String uri ="mongodb://localhost:27017";
		MongoClient client = MongoClients.create(uri);
		
		MongoDatabase database= client.getDatabase("gestion_commandes");
		MongoCollection<Document> clients = database.getCollection("client");

		MongoCollection<Document> commandes = database.getCollection("commandes");
		
		//find all documents from a collection
		FindIterable<Document> alldocc=clients.find();
		 List<String> liste = new ArrayList<String>();
		 for(Document i : alldocc) {
			liste.add(i.getString("nom"));
		 }
		 liste.forEach(d -> System.out.println(d));

		
	}

}
