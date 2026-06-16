import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Fabrica {
  DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
  DocumentBuilder constructor = fabrica.newDocumentBuilder();
}
