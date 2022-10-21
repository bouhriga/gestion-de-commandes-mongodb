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
import model.command;

/**
 * Servlet implementation class cherchercommand
 */
@WebServlet("/cherchercommand")
public class cherchercommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cherchercommand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("chercherdate");
		String prenom = null;
		String adress = null;
		String phone = null;
		String couleur = null;
		String caract = null;
		int prix = 0 ;
		Collection<command> cs = new ArrayList<command>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> commandes = service.findn(date);
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
			String date1=e.getString("date");
			command c=new command(id,pnom,cnom,qtt,date1,prenom,adress,phone,couleur,caract,prix);
			cs.add(c);
		}
		request.setAttribute("commandes", cs);
		RequestDispatcher rd = request.getRequestDispatcher("listecomN.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
