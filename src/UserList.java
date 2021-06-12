import java.util.ArrayList;

/**
 * This class represents UsersList on the system
 * @author Zeyad Maher Mahmoud
 */
public class UserList {
  public ArrayList<User> users =new ArrayList<User>() ;

    /**
     * This function allows the user to sign-in on the system
     * @param email User's E-mail
     * @param password User's Password
     * @return User
     */
   public User signIn( String email,String password)
   {
      for(int i=0;i<users.size();i++)
      {
         if(users.get(i).getEmail()==email&&users.get(i).getPassword()==password)
         {
            return users.get(i);

         }

      }
      return null;

   }
    /**
     * This method gets a user from users list by his ID
     * @param Id the User's ID
     * @return the User
     */
    public User getUserById(int Id)
    {
        for(int i=0; i<users.size();i++)
        {
            if(users.get(i).getId()==Id)
                return users.get(i);
        }
        return null;
    }

    /**
     * This method allows the user to register on the system
     * @param user the user to be registered
     * @param administrator the administrator to approve his registration
     */
   public void Register(User user,Administrator administrator)
   {
      administrator.PendingUsers.add(user);

   }

}
