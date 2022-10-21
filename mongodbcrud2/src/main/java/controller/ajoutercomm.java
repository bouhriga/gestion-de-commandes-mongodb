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
import model.client;
import model.command;

@WebServlet("/ajoutercomm")
public class ajoutercomm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<String> nomc= new ArrayList<String>();
		 List<String> nomp = new ArrayList<String>();

		mongodbquery  service = new mongodbquery ();
		nomc = service.findallnomc();
		nomp = service.findallnomp();
		nomp.forEach(d -> System.out.println(d));
		request.setAttribute("cs",nomc);
		request.setAttribute("ps",nomp);
		RequestDispatcher rd = request.getRequestDispatcher("ajoutercommande.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnom = request.getParameter("produit");
		String cnom = request.getParameter("client");
		int qtt = Integer.parseInt(request.getParameter("qtt"));
		String date = request.getParameter("date");
		command c=new command(pnom,cnom,qtt,date);
		mongodbquery  service = new mongodbquery ();
		service.ajoutercomm(c);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}



}
