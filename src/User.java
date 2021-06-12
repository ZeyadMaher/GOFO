/**
 * this class is a class to represent all users attributes and functions
 * @author Zeyad Maher Mahmoud
 */
public class User {

    private Ewallet ewallet=new Ewallet();
    private String name;
    private int id;
    private String password;
    private String email ;
    private String location ;

    /**
     * This constructor is our default constructor
     */
    User(){}

    /**
     * This method is for setting all user attributes
     * @param Id User's ID
     * @param Email User's E-mail
     * @param Name User's Name
     * @param Location User's Location
     * @param Password User's Password
     */
    User(int Id,String Email,String Name,String Location,String Password)
    {
        setID(Id);
        setEmail(Email);
        setName(Name);
        setLocation(Location);
        setPassword(Password);
        ewallet.setBalance(0);


    }

    /**
     * This method returns User's email
     * @return user's E-mail
     */

    public String getEmail() {
        return email;
    }

    /**
     * This method returns User's Name
     * @return User's Name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns User's ID
     * @return User's ID
     */
    public int getId() {
        return id;
    }

    /**
     * This method returns User's Location
     * @return User's Location
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method returns User's e-wallet
     * @return User's e-wallet
     */
    public Ewallet getEwallet() {
        return ewallet;
    }

    /**
     * This method returns User's Password
     * @return User's Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets User's email to a given value
     * @param em User's email
     */
    public void setEmail(String em) {
        this.email=em;
        ;
    }

    /**
     * This method sets User's ID to a given value
     * @param id2 User's ID
     */

    public void setID(int id2) {
        this.id =id2;
    }

    /**
     * This method sets User's Password to a given value
     * @param pass User's Password
     */
    public void setPassword(String pass) {
       this.password=pass;
    }

    /**
     * This method sets User's name to a given value
     * @param name User's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets User's Location to a given value
     * @param location User's Location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * This method sets User's e-wallet to a given value
     * @param ewallet User's e-wallet
     */
    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }
}
