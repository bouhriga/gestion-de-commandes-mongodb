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
import model.client;

/**
 * Servlet implementation class supprimerclient
 */
@WebServlet("/supprimerclient")
public class supprimerclient extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectId id = new ObjectId(request.getParameter("id"));
		mongodbquery  service = new mongodbquery ();
		service.deleteclient(id);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	
	}


}
