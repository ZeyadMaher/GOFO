import java.util.ArrayList;

/**
 * This class represents Administrator's attributes and functions
 * @author Doha Ramadan Hanafy
 */
public class Administrator {
    private String Name;
    private String Username;
    private String Password;
    public ArrayList<Playground> PendingPlaygrounds = new ArrayList<Playground>();
    public ArrayList<User> PendingUsers = new ArrayList<User>();

    /**
     * This method allows administrator to approve playgrounds which are registered
     * @param list The available playgrounds list
     * @param name the name of the playground to be approved
     */
    public void ApprovePlayground(PlaygroundsList list, String name)
    {
        getPlaygroundByName(name).setStatus(PlaygroundStatus.VALID);
        list.availablePlaygrounds.add(getPlaygroundByName(name));
        PendingPlaygrounds.remove(getPlaygroundByName(name));

    }

    /**
     * This method allows administrator to delete playgrounds which are registered
     * @param name the name of the playground to be deleted
     * @param list the playgroundsList
     */
    public void deletePlayground(String name ,PlaygroundsList list)
    {

        for(int i=0; i<list.availablePlaygrounds.size();i++)
        {
            if(list.availablePlaygrounds.get(i).Name.equals(name))
            {
                list.availablePlaygrounds.remove(i);
            }
        }

    }

    /**
     * This method gets a playground from it's pending list by
     * @param name the playground's name
     * @return the playground
     */
    public Playground getPlaygroundByName(String name)
    {
        for(int i=0; i<PendingPlaygrounds.size();i++)
        {
            if(PendingPlaygrounds.get(i).Name.equals(name))
                return PendingPlaygrounds.get(i);
        }
        return null;
    }

    /**
     * This method gets a user from PendingUsers list by his ID
     * @param Id the User's ID
     * @return the User
     */

    public User getUserById(int Id)
    {
        for(int i=0; i<PendingUsers.size();i++)
        {
            if(PendingUsers.get(i).getId()==Id)
                return PendingUsers.get(i);
        }
        return null;
    }

    /**
     * This method allows the administrator to approve users
     * @param list UsersList
     * @param id The ID of the user to be approved
     */
    public void ApproveUser(UserList list,int id)
    {
        list.users.add(getUserById(id));
         PendingUsers.remove(getUserById(id));

    }

    /**
     * This method allows Administrator to add balance to a specific user's eWallet from UsersList
     * @param list UsersList
     * @param id User's ID
     * @param value the amount to be added
     */
    public void addBalance(UserList list, int id,float value)
    {
    float balance = list.getUserById(id).getEwallet().getBalance();
    list.getUserById(id).getEwallet().setBalance(balance+=value);
    }

    /**
     * This method allows Administrator to subtract balance from a specific user's eWallet from UsersList
     * @param list UsersList
     * @param id User's ID
     * @param value the amount to be added
     */
    public void subtractBalance(UserList list, int id,float value)
    {
        float balance = getUserById(id).getEwallet().getBalance();
        getUserById(id).getEwallet().setBalance(balance-=value);

    }

}