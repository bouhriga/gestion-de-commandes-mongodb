package export;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

@WebServlet("/PDFExport")
public class PDFExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<client> cs = new ArrayList<client>();
		mongodbquery  service = new mongodbquery ();
		FindIterable<Document> clients = service.findallc();
		for(Document e : clients){
		    ObjectId id=e.getObjectId("_id");
			String nom=e.getString("nom");
		    String prenom=e.getString("prenom");
			String adress=e.getString("adress");
			String phone=e.getString("Phone");
			client c=new client(id,nom,prenom,adress,phone);
			cs.add(c);
		}
		
		String masterPath = request.getServletContext().getRealPath( "/WEB-INF/listeclients.pdf" );
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
             for (client c : cs) {
                 
                 canvas.setTextMatrix( 90, top );
                 canvas.showText( "" + c.getNom() );

                 canvas.setTextMatrix( 174, top );
                 canvas.showText( c.getPrenom() );

                 canvas.setTextMatrix( 263, top );
                 canvas.showText( c.getPhone() );

                 canvas.setTextMatrix( 410, top );
                 canvas.showText( c.getAdress() );

                 
                 
                 top -= 20;
             }
             
             canvas.endText();
        }
	}


}
