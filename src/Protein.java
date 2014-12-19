/**
 * Created with IntelliJ IDEA.
 * User: Aydin
 * Date: 12/19/14
 * Time: 7:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Protein {


    public String sequence;
    public String code;
    public String type;
    public String compound_type;

    public Protein(String code, String sequence, String type, String compound_type)
    {
        this.code = code;
        this.sequence = sequence;
        this.type = type;
        this.compound_type = compound_type;

    }

}
