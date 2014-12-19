/**
 * Created with IntelliJ IDEA.
 * User: Celebi
 * Date: 12/19/14
 * Time: 11:20 PM
 */
public class DIPProtein {


    public String sequence;
    public String dipId;
    public String refsegId;
    public String uniprotId;

    public DIPProtein(String dipId,String refsegId,String uniprotId, String sequence)
    {
        this.dipId = dipId;
        this.refsegId = refsegId;
        this.uniprotId = uniprotId;
        this.sequence = sequence;

    }

}
