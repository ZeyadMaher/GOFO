import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the list of playgrounds on the system
 * @author Doha Ramadan Hanafy
 */
    public class PlaygroundsList extends Playground {
    public ArrayList<Playground> availablePlaygrounds = new ArrayList<Playground>();

    /**
     * This function displays the info of the playgrounds in our playgroundList
     */
    public void display()
    {
        String owner;
        for (int i=0;i<availablePlaygrounds.size();i++)
        {   owner =availablePlaygrounds.get(i).getOwner().getName();
             System.out.print("Playground{" +
                "Name='" + availablePlaygrounds.get(i).getName() + '\'' +
                ", Size=" + availablePlaygrounds.get(i).getSize() +
                ", PricePerHour=" + availablePlaygrounds.get(i).getPricePerHour() +
                ", hours=" ) ;availablePlaygrounds.get(i).checkHours() ;
            System.out.println( ", CancellationPeriod=" + availablePlaygrounds.get(i).getCancellationPeriod() +
                    ", status=" +availablePlaygrounds.get(i).getStatus()+
                ", owner=" +owner+
                '}');
        }
    }

    /**
     * This function gets a playground from PlaygroundsList by it's name
     * @param name Playground's name
     * @return playground
     */
    public Playground getPlaygroundByyName(String name) {
       for(int i=0; i<availablePlaygrounds.size();i++)
       {
           if(availablePlaygrounds.get(i).getName().equals(name))

               return availablePlaygrounds.get(i);
       }
       return null ;
    }
}
