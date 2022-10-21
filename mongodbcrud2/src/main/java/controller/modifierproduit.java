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
import model.produit;

/**
 * Servlet implementation class modifierproduit
 */
@WebServlet("/modifierproduit")
public class modifierproduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierproduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produit c = null;
		ObjectId id = new ObjectId(request.getParameter("id"));
		Collection<produit> cs = new ArrayList<produit>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> produits = service.findonep(id);
		for(Document e : produits){
			String nom=e.getString("Pnom");
			int prix=e.getInteger("prix");
			String couleur=e.getString("couleur");
			String caract=e.getString("caract");
			 c=new produit(id,nom,prix,couleur,caract);
		}
		request.setAttribute("produit", c);
		RequestDispatcher rd = request.getRequestDispatcher("modifierproduits.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectId id = new ObjectId(request.getParameter("id"));
		String nom = request.getParameter("nom");
		int prix =Integer.parseInt(request.getParameter("prix")) ;
		String couleur = request.getParameter("couleur");
		String caract = request.getParameter("caract");
		produit c=new produit(nom,prix,couleur,caract);
		mongodbquery  service = new mongodbquery ();
		service.modifierprt(id,c);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
