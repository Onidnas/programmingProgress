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
	  System.out.println(doc.getElementsByTagName("empresa").item(0).getTextContent());
	  System.out.println(doc.getElementsByTagName("baseDeDatos").item(0));
	  System.out.println(doc.getElementsByTagName("host").item(0).getTextContent());
	}
	 catch (Exception e) {
       	     System.err.println("Error: " + e.getMessage());

       							 }
 }
}
