import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
    final static Charset ENCODING = StandardCharsets.UTF_8;


    public DIPParser(String sequencesPath,String interactionsPath){

        this.sequencesPath = sequencesPath;
        this.interactionsPath = interactionsPath;

    }

    public ArrayList<DIPProtein> RetrieveProteins()
    {
        ArrayList<DIPProtein> proteins = new ArrayList<DIPProtein>();
        Path p1 = Paths.get(this.sequencesPath);
        String fileContent = new String();

        try{

            fileContent = Files.readAllLines(p1,ENCODING).toString();
            fileContent= fileContent.substring(1);
        }
        catch (IOException e)
        {
            System.out.println("Fail");

        }

        String[] lines = fileContent.split("\\*\\*\\*\\*\\*\\*");
        ArrayList<String>  IDs = new ArrayList<String>();

        String dipId = new String();
        String refseqId = new String();
        String uniprotId = new String();

        for (int i=0;i<lines.length;i++)
        {
            if (i%2==0)
            {
              String[] firstLinePortions = lines[i].substring(1).split("\\|");
              for(String linePortion:firstLinePortions)
              {
                  String[] linePortionKeyValue = linePortion.split(":");
                  if (linePortionKeyValue[0].equals("dip"))
                      dipId = linePortionKeyValue[1];
                  else if (linePortionKeyValue[0].equals("refseq"))
                      refseqId = linePortionKeyValue[1];
                  else if (linePortionKeyValue[0].equals("uniprot"))
                      uniprotId = linePortionKeyValue[1];
              }
            }
            else
                proteins.add(new DIPProtein(dipId,refseqId,uniprotId,lines[i]));

        }

        return proteins;
    }

    public ArrayList<Interaction> RetrieveInteractions()
    {
        ArrayList<Interaction> interactions = new ArrayList<Interaction>();
        Path p1 = Paths.get(this.sequencesPath);
        String fileContent = new String();

        try{

            fileContent = Files.readAllLines(p1,ENCODING).toString();
            fileContent= fileContent.substring(1);
        }
        catch (IOException e)
        {
            System.out.println("Fail");

        }


        return interactions;
    }


}
