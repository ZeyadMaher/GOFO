import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents Player's attributes and functions
 * @author Zeyad Maher Mahmoud
 */
public class  Player extends User {
    /**
     * This is our default constructor
     */
    Player(){}

    /**
     * This method is for setting the value of players' attributes
     * @param Id Player's ID
     * @param Email Player's Email
     * @param Name PLayer's Name
     * @param Location Player's Location
     * @param Password PLayer's Password
     */
    Player(int Id,String Email,String Name,String Location,String Password)
    {
        super( Id, Email, Name,Location, Password);
    }

    Scanner input=new Scanner(System.in);

    /**
     * This function allows player to book a playground for a specific period of time-slot-
     * @param list PlaygroundsList
     */
     public void Book(PlaygroundsList list) {
         ArrayList<Integer> arr = new ArrayList<Integer>();//used to store
         int slot;

         list.display();
         System.out.println("\nEnter name of playground you want to select ");

         String var = input.next();
         if (list.getPlaygroundByyName(var) != null)
         {
             list.getPlaygroundByyName(var).checkHours();     //error------------
             System.out.println("How many slots you want to book");
             int count = input.nextInt();
             System.out.println("Enter the free slot number you want to book (space separated)");
             for (int i = 0; i < count; i++)
             {

                 arr.add(input.nextInt());
             }
             for (int i = 0; i < arr.size(); i++) {
                  slot = arr.get(i);
                 if (list.getPlaygroundByyName(var).getHours(slot-1)==0)//slot is empty
                 {
                     list.getPlaygroundByyName(var).bookHours(this.getId(), slot);//book slot with player id

                 }
                 else
                 {
                     System.out.println("slot "+slot+" can't be booked");
                     arr.remove(i);
                 }

             }
             float fee = arr.size() * list.getPlaygroundByyName(var).getPricePerHour();
             if (this.getEwallet().getBalance() >= fee) {
                 this.getEwallet().setBalance(this.getEwallet().getBalance() - fee);
                 System.out.println("Booked successfully");



             } else {
                 System.out.println("Booked unsuccessfully (Insufficient balance)");
             }


         }
         else
         {
             System.out.println("playground not found");
         }
     }

    /**
     * This method allows player to view his bookings on  the system
     * @param list PlaygroundsList
     */
    public void viewBookings(PlaygroundsList list){
        for (int k=0;k<list.availablePlaygrounds.size();k++){

            for(int i=0; i<24;i++)
            {
                if (list.availablePlaygrounds.get(k).getHours(i)==this.getId())
                {
                    System.out.print(list.availablePlaygrounds.get(k).getName()+"{ [");
                    System.out.print("slot"+(i+1)+":");
                    System.out.print(list.availablePlaygrounds.get(k).getHours(i)+",");
                    System.out.println("] }");
                }


            }


        }
    }

    /**
     * This method allows player to cancel his bookings
     * @param list PlaygroundsList
     */
    public void cancelBook(PlaygroundsList list)
    {

        viewBookings(list);
        System.out.println("which playground you want to choose to cancel your book from");
        String name=input.next();
        System.out.println("which slot you want to cancel");
        int var=input.nextInt();

        System.out.print(name+"{ [");
        for(int i=0; i<24;i++)
        {
            if (list.getPlaygroundByyName(name).getHours(i)==this.getId()&&i==var-1)
            {
                list.getPlaygroundByyName(name).bookHours(0,var);
                System.out.print("slot "+(var)+" cancelled successfully");
                float f =list.getPlaygroundByyName(name).getPricePerHour();
                getEwallet().setBalance(getEwallet().getBalance()+f);
            }


        }
        System.out.println("] }");
        System.out.println("now your bookings are");
        viewBookings(list);

    }

}
