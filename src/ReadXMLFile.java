import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ReadXMLFile {

    public static void main(String argv[]) {

        String xmlUrl = "C:\\Users\\Celebi\\Desktop\\Downloads\\allppis.xml";
        ArrayList<String> proteinIDs = XmlProcessor.RetrieveProteinIDs(xmlUrl);

        ProteinParser parser = new ProteinParser();

        ArrayList<Protein> proteins = new ArrayList<Protein>();
        for(String id:proteinIDs)
            proteins.add(parser.getProtein(id));



    }

}