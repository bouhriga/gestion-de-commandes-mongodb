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

import org.bson.types.ObjectId;

import exercice.commande.mongodbquery;
import model.command;

/**
 * Servlet implementation class supprimercomm
 */
@WebServlet("/supprimercomm")
public class supprimercomm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet supprrimer");
		ObjectId id = new ObjectId(request.getParameter("id"));
		mongodbquery  service = new mongodbquery ();
		service.deletecommende(id);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	
	
	}


}
