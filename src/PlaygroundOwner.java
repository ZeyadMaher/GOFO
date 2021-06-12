import java.util.ArrayList;

/**
 * This class represents PlaygroundOwner attributers and methods
 * @author Zeyad Maher Mahmoud
 */
public class PlaygroundOwner extends User {
   ArrayList<Playground> myPlaygrounds =new ArrayList<Playground>();

    /**
     * This method sets the value of the playgroundOwner attributes
     * @param Id PlaygroundOwner's ID
     * @param Email PlaygroundOwner's Email
     * @param Name PlaygroundOwner's Name
     * @param Location PlaygroundOwner's Location
     * @param Password PlaygroundOwner's Password
     */
   public PlaygroundOwner (int Id,String Email,String Name,String Location,String Password)
   {
      super( Id, Email, Name, Location, Password);

   }

    /**
     * This method gets a playground by it's name
     * @param name Playground Name
     * @return Playground
     */
    public Playground getPlaygroundByName(String name)
    {
        for(int i=0; i<myPlaygrounds.size();i++)
        {
            if(myPlaygrounds.get(i).Name==name)
                return myPlaygrounds.get(i);
        }
        return null;
    }

    /**
     * This method allows PlaygroundOwner to add playgrounds to the system -PendingList-
     * @param administrator the administrator to approve or delete the playground
     * @param playground the playground to be added
     */
    public void addPlayground ( Administrator administrator ,Playground playground){
       myPlaygrounds.add(playground);
       administrator.PendingPlaygrounds.add(playground);
       playground.setStatus(PlaygroundStatus.PENDING);
    }

    /**
     * This method allows playgroundOwner to delete one of his playgrounds from the system
     * @param playground the playground to be deleted
     * @param list the list of AvailablePlaygrounds
     */
    public void deletePlayground(Playground playground,PlaygroundsList list)
    {
        list.availablePlaygrounds.remove(playground);
        myPlaygrounds.remove(playground);
    }

    /**
     * This method allows playgroundOwner to view his bookings
     * @param list the list of AvailablePlaygrounds
     */
    public void viewBookings(PlaygroundsList list){
       for (int i =0;i<list.availablePlaygrounds.size();i++)
       {
           if (list.availablePlaygrounds.get(i).getOwner().getId()== this.getId())
           {
               list.availablePlaygrounds.get(i).checkBookings();

           }

       }
    }

}
