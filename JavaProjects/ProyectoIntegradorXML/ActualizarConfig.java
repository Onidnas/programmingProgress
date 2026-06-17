import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

public class ActualizarConfig {
     public static void main(String[] args) throws Exception {

        try {

        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabrica.newDocumentBuilder();

        Document doc = constructor.parse(new File("config.xml"));

        doc.getElementsByTagName("host").item(0).setTextContent("192.168.1.99");

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource fuente = new DOMSource(doc);
        StreamResult resultado = new StreamResult(new File("config.xml"));
        transformer.transform(fuente, resultado);
        System.out.println("Archivo XML actualizado correctamente.");

        LeerConfig.main(null);

        }
        catch (Exception e) {
            e.getMessage();
        }








    
        
    }

}
