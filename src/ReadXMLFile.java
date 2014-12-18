import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class ReadXMLFile {

    public static void main(String argv[]) {
        ArrayList IDs = new ArrayList();
        try {

            File fXmlFile = new File("C:\\Users\\Celebi\\Desktop\\Downloads\\allppis.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("primaryRef");  // hacı bu bizim id'nin referansı oluyor
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println(eElement.getAttribute("db"));
                    if(eElement.getAttribute("db").equals("SP"))
                        IDs.add(eElement.getAttribute("id"));
                    //System.out.println("Protein id : " + eElement.getAttribute("id"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(IDs);



    }

}