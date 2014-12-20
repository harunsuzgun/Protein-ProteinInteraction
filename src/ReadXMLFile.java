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

        DIPParser parser = new DIPParser("D:\\fastaseq\\fasta20131201.seq","D:\\fasta20131201.seq\\dip20141001.txt");
        ArrayList<DIPProtein> proteins = parser.RetrieveProteins();


    }

}