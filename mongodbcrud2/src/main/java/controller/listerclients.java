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

import exercice.commande.mongodbquery;
import model.client;

/**
 * Servlet implementation class listerclients
 */
@WebServlet("/listerclients")
public class listerclients extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<client> cs = new ArrayList<client>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> clients = service.findallc();
		for(Document e : clients){
		    ObjectId id=e.getObjectId("_id");
			String nom=e.getString("nom");
		    String prenom=e.getString("prenom");
			String adress=e.getString("adress");
			String phone=e.getString("Phone");
			client c=new client(id,nom,prenom,adress,phone);
			cs.add(c);
		}
		request.setAttribute("clients", cs);
		RequestDispatcher rd = request.getRequestDispatcher("listeclients.jsp");
		rd.forward(request, response);
	}

	
}
