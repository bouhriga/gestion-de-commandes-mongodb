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
import model.produit;

/**
 * Servlet implementation class PDFExportproduit
 */
@WebServlet("/PDFExportproduit")
public class PDFExportproduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<produit> cs = new ArrayList<produit>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> produits = service.findallp();
		for(Document e : produits){
		    ObjectId id=e.getObjectId("_id");
			String pnom=e.getString("Pnom");
		    int prix=e.getInteger("prix");
		    String couleur=e.getString("couleur");
			String caract=e.getString("caract");
			produit c=new produit(id,pnom,prix,couleur,caract);
			cs.add(c);
		}
		String masterPath = request.getServletContext().getRealPath( "/WEB-INF/listeproduits.pdf" );
        response.setContentType( "application/pdf" );

        
        try ( PdfReader reader = new PdfReader( masterPath );
        PdfWriter writer = new PdfWriter( response.getOutputStream() );
        PdfDocument document = new PdfDocument( reader, writer ) ) {
        	 PdfPage page = document.getPage( 1 );
             PdfCanvas canvas = new PdfCanvas( page );

             FontProgram fontProgram = FontProgramFactory.createFont();
             PdfFont font = PdfFontFactory.createFont(fontProgram, "utf-8");
             canvas.setFontAndSize( font, 10 );
             
             canvas.beginText();

             int top = 600;
             NumberFormat formatter = NumberFormat.getNumberInstance( new Locale( "fr", "FR" ) );

             for (produit c : cs) {
                 
                 canvas.setTextMatrix( 90, top );
                 canvas.showText( "" + c.getPnom() );

                 canvas.setTextMatrix( 218, top );
                 canvas.showText( formatter.format( c.getPrix()));

                 canvas.setTextMatrix( 292, top );
                 canvas.showText( c.getCouleur() );

                 canvas.setTextMatrix( 368, top );
                 canvas.showText( c.getCaract() );

                 
                 
                 top -= 20;
             }
             
             canvas.endText();
        }
	}


}
