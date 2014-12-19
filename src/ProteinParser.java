import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Aydin
 * Date: 12/19/14
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProteinParser {


    public Protein getProtein(String code)
    {
        Protein rVal;
        URL url;
        HttpURLConnection connection = null;
        String baseUrl = "http://uniprot.org/uniprot/";
        String parseUrl = baseUrl + code + ".fasta";

        String raw_fasta = new String();
        try {

            url = new URL(parseUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            rd.close();
            raw_fasta = response.toString();
            //System.out.print(response);
        }

        catch (IOException e) {
            System.out.print("fail");
            System.out.print(e);

        }

        String[] lines = raw_fasta.split("\n");

        String[] first_line_split = lines[0].split("\\|| ");

        String type = first_line_split[0].substring(1);
        String compound_type = first_line_split[3];
        String sequence = new String();
        for (int i=1;i<lines.length;i++)
            sequence = sequence + lines[i]; // string.join like thing?


        rVal = new Protein(code,sequence,type,compound_type);


        return rVal;
    }






}
