import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;


public class LeerConfig {
	public static void main(String [] args) {
		try {
	 DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
	 DocumentBuilder constructor = fabrica.newDocumentBuilder();
	 //Abrir y analizar 
	  
	  Document doc = constructor.parse(new File("config.xml"));
	  Element baseDeDatos = (Element) doc.getElementsByTagName("baseDeDatos").item(0);
	  Element aplicacion = (Element) doc.getElementsByTagName("aplicacion").item(0);
          System.out.println("=================================");
	  System.out.println("Empresa: " + doc.getElementsByTagName("empresa").item(0).getTextContent());
	  System.out.println("Admin: " + doc.getElementsByTagName("administrador").item(0).getTextContent());

          System.out.println("=================================");
	  System.out.println("Host DB: " + baseDeDatos.getElementsByTagName("host").item(0).getTextContent());
	  System.out.println("Puerto: " + baseDeDatos.getElementsByTagName("puerto").item(0).getTextContent());
	  System.out.println("Nombre: " + baseDeDatos.getElementsByTagName("nombre").item(0).getTextContent());
	  System.out.println("Usuario: " + baseDeDatos.getElementsByTagName("usuario").item(0).getTextContent());
	  System.out.println("Idioma: " + aplicacion.getElementsByTagName("idioma").item(0).getTextContent());
          System.out.println("=================================");
	  
	  

	}
	 catch (Exception e) {
       	     System.err.println("Error: " + e.getMessage());

       							 }
 }
}
