package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import model.command;

/**
 * Servlet implementation class modifierecommform
 */
@WebServlet("/modifierecommform")
public class modifierecommform extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mongodbquery  service = new mongodbquery ();
		command c = null;
		ObjectId id = new ObjectId(request.getParameter("id"));
		Collection<command> cs = new ArrayList<command>();
		FindIterable<Document> commandes = service.findonecom(id);
		for(Document e : commandes){
			String nom_c=e.getString("nom_c");
			String nom_p=e.getString("nom_p");
			int qtt=e.getInteger("qtt");
			String date=e.getString("date");
			 c=new command(id,nom_c,nom_p,qtt,date);
		}
		request.setAttribute("command", c);
		RequestDispatcher rd = request.getRequestDispatcher("modifiercommandes.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("wiiiik dkhal");
		ObjectId id = new ObjectId(request.getParameter("id"));
		System.out.println(id);
		String nomp = request.getParameter("nomp");
		System.out.println(nomp);
		String nomc = request.getParameter("nomc");
		System.out.println(nomc);
		int qtt =Integer.parseInt(request.getParameter("qtt"));
		String date = request.getParameter("date");
		command c=new command(id,nomc,nomp,qtt,date);
		mongodbquery  service = new mongodbquery ();
		service.modifiercom(id,c);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
