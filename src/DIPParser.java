import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Aydin
 * Date: 12/19/14
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DIPParser {

    private String sequencesPath;
    private String interactionsPath;

    public DIPParser(String sequencesPath,String interactionsPath){

        this.sequencesPath = sequencesPath;
        this.interactionsPath = interactionsPath;

    }

    public ArrayList<DIPProtein> RetrieveProteins()
    {
        ArrayList<DIPProtein> proteins = new ArrayList<DIPProtein>();
        Path p1 = Paths.get(sequencesPath);
        String fileContent = new String();

        try{

            fileContent = Files.readAllBytes(p1).toString();
        }
        catch (IOException e)
        {
            System.out.println("Fail");

        }

        String[] lines = fileContent.split("\n");
        ArrayList<String>  IDs = new ArrayList<String>();

        String dipId = new String();
        String refseqId = new String();
        String uniprotId = new String();

        for (String line:lines)
        {
            if (line.substring(0,1).equals(">"))
            {
              String[] firstLinePortions = line.substring(1).split("\\|");
              for(String linePortion:firstLinePortions)
              {
                  String[] linePortionKeyValue = linePortion.split(":");
                  if (linePortionKeyValue[0].equals("dip"))
                      dipId = linePortionKeyValue[1];
                  else if (linePortionKeyValue[0].equals("refseq"))
                      refseqId = linePortionKeyValue[1];
                  else if (linePortionKeyValue[0].equals("uniprot"))
                      uniprotId = linePortionKeyValue[2];
              }
            }
            else
                proteins.add(new DIPProtein(dipId,refseqId,uniprotId,line));

        }

        return proteins;
    }




}
