import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Aydin
 * Date: 12/19/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class XmlProcessor {
    static ArrayList<String> RetrieveProteinIDs(String xmlUrl)
    {
        ArrayList<String> rVal = new ArrayList<String>();

        ArrayList IDs = new ArrayList();


        try {
            File fXmlFile = new File(xmlUrl);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("primaryRef");  // reference for the ID
            //System.out.println("----------------------------");

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

        for (Object id:IDs)
            rVal.add(id.toString());

        return rVal;
    }
}
