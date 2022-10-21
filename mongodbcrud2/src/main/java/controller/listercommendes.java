package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;

import model.client;
import model.command;
import exercice.commande.mongodbquery;

/**
 * Servlet implementation class listercommendes
 */
@WebServlet("/listercommendes")
public class listercommendes extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<command> cs = new ArrayList<command>();
		String prenom = null;
		String adress = null;
		String phone = null;
		String couleur = null;
		String caract = null;
		int prix = 0 ;
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> commandes = service.findall();
		for(Document e : commandes){
			ObjectId id=e.getObjectId("_id");
			String cnom=e.getString("nom_c");
			FindIterable<Document> client = service.findclientn(cnom);
			for(Document n : client){
			 prenom=n.getString("prenom");
			 adress=n.getString("adress");
			 phone=n.getString("Phone");
			}
			String pnom=e.getString("nom_p");
			FindIterable<Document> produit = service.findproduitn(pnom);
			for(Document n : produit){
				couleur=n.getString("couleur");
				caract=n.getString("caract");
				prix=n.getInteger("prix");
				}
			int qtt=e.getInteger("qtt");
			String date=e.getString("date");
			command c=new command(id,pnom,cnom,qtt,date,prenom,adress,phone,couleur,caract,prix);
			cs.add(c);
		}
		request.setAttribute("commandes", cs);
		RequestDispatcher rd = request.getRequestDispatcher("listecommandes.jsp");
		rd.forward(request, response);
		

	}

	

}
