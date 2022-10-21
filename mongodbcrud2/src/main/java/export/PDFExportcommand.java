package export;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.mongodb.client.FindIterable;

import exercice.commande.mongodbquery;
import model.client;
import model.command;

/**
 * Servlet implementation class PDFExportcommand
 */
@WebServlet("/PDFExportcommand")
public class PDFExportcommand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<command> cs = new ArrayList<command>();
		String prenom = null;
		String adress = null;
		String phone = null;
		String couleur = null;
		String caract = null;
		int prix = 0 ;
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> commandes = service.findall();
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
			String date=e.getString("date");
			command c=new command(id,pnom,cnom,qtt,date,prenom,adress,phone,couleur,caract,prix);
			cs.add(c);
		}
		
		String masterPath = request.getServletContext().getRealPath( "/WEB-INF/listecommandes.pdf" );
        response.setContentType( "application/pdf" );

        
        try ( PdfReader reader = new PdfReader( masterPath );
        PdfWriter writer = new PdfWriter( response.getOutputStream() );
        PdfDocument document = new PdfDocument( reader, writer ) ) {
        	 PdfPage page = document.getPage( 1 );
             PdfCanvas canvas = new PdfCanvas( page );

             FontProgram fontProgram = FontProgramFactory.createFont();
             PdfFont font = PdfFontFactory.createFont(fontProgram, "utf-8");
             canvas.setFontAndSize( font, 6 );
             
             canvas.beginText();

             int top = 600;
             NumberFormat formatter = NumberFormat.getNumberInstance( new Locale( "fr", "FR" ) );

             for (command c : cs) {
                 
                 canvas.setTextMatrix( 90, top );
                 canvas.showText( "" + c.getNom_p());

                 canvas.setTextMatrix( 140, top );
                 canvas.showText( c.getNom_c()+" "+c.getPrenom_c() );

                 canvas.setTextMatrix( 200, top );
                 canvas.showText( c.getAdress() );

                 canvas.setTextMatrix( 260, top );
                 canvas.showText( c.getPhone() );

                 canvas.setTextMatrix( 300, top );
                 canvas.showText( c.getCaract() );
                 
                 canvas.setTextMatrix( 380, top );
                 canvas.showText(formatter.format( c.getPrix()) );
                 
                 canvas.setTextMatrix( 410, top );
                 canvas.showText( c.getCouleur() );
                 
                 canvas.setTextMatrix( 450, top );
                 canvas.showText( formatter.format( c.getQtt()) );
                 
                 canvas.setTextMatrix( 480, top );
                 canvas.showText( c.getDate());
                 top -= 20;
             }
             
             canvas.endText();
        }
	}


}
