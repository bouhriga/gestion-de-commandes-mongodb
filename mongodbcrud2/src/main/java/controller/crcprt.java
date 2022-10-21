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
import model.produit;

/**
 * Servlet implementation class crcprt
 */
@WebServlet("/crcprt")
public class crcprt extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("cherchernom");
		Collection<produit> cs = new ArrayList<produit>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> produits = service.findproduitn(nom);
		for(Document e : produits){
			ObjectId id=e.getObjectId("_id");
			String Pnom=e.getString("Pnom");
			int prix=e.getInteger("prix");
			String couleur=e.getString("couleur");
			String caract=e.getString("caract");
			produit c=new produit(id,nom,prix,couleur,caract);
			cs.add(c);
		}
		request.setAttribute("produits", cs);
		RequestDispatcher rd = request.getRequestDispatcher("listeproduitN.jsp");
		rd.forward(request, response);

	}

}
