package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercice.commande.mongodbquery;
import model.produit;

/**
 * Servlet implementation class ajtprd
 */
@WebServlet("/ajtprd")
public class ajtprd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		int prix = Integer.parseInt(request.getParameter("prix"));
		String couleur = request.getParameter("couleur");
		String caract = request.getParameter("caract");
		produit c=new produit(nom,prix,couleur,caract);
		mongodbquery  service = new mongodbquery ();
		service.ajouterproduit(c);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}



}
