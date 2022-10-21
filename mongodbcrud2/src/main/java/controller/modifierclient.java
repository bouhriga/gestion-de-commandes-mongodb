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
 * Servlet implementation class modifierclient
 */
@WebServlet("/modifierclient")
public class modifierclient extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		client c = null;
		ObjectId id = new ObjectId(request.getParameter("id"));
		Collection<client> cs = new ArrayList<client>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> clients = service.findoneCl(id);
		for(Document e : clients){
			String nom=e.getString("nom");
			String prenom=e.getString("prenom");
			String adress=e.getString("adress");
			String phone=e.getString("Phone");
			 c=new client(id,nom,prenom,adress,phone);
		}
		request.setAttribute("client", c);
		RequestDispatcher rd = request.getRequestDispatcher("modifierclients.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectId id = new ObjectId(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adress");
		String num = request.getParameter("phone");
		client c=new client(nom,prenom,adresse,num);
		mongodbquery  service = new mongodbquery ();
		service.modifiercl(id,c);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
