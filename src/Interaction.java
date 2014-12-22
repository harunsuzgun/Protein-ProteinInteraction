/**
 * Created with IntelliJ IDEA.
 * User: Celebi
 * Date: 12/22/14
 * Time: 7:05 PM
 */
public class Interaction {

    private DIPProtein p1;
    private DIPProtein p2;

    /*
    * ID interactor A	ID interactor B	Alt. ID interactor A	Alt. ID interactor B	Alias(es) interactor A
    * Alias(es) interactor B	Interaction detection method(s)	Publication 1st author(s)	Publication Identifier(s)
    * Taxid interactor A	Taxid interactor B	Interaction type(s)	Source database(s)	Interaction identifier(s)
    * Confidence value(s)	Processing Status
    *
    *
    * */
    public Interaction(DIPProtein p1, DIPProtein p2)
    {
        this.p1  = p1;
        this.p2 = p2;

    }
}
