import java.util.ArrayList;

import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.graph.implementations.SingleGraph;
//import weka.*;
import org.graphstream.graph.*;
public class ReadXMLFile {

    public static void main(String argv[]) {

        DIPParser parser = new DIPParser("D:\\fastaseq\\fasta20131201.seq","D:\\fasta20131201.seq\\dip20141001.txt");
        ArrayList<DIPProtein> proteins = parser.RetrieveProteins();




        Graph graph = new DefaultGraph("PIP Network");



    }

}