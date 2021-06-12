import java.util.Arrays;

/**
 * This class represents Playground's attributes and method
 * @author Doha Ramadan Hanafy
 */
public class Playground
{
    protected String Name;
    protected float Size;
    protected float PricePerHour;
    protected int[] hours = new int[24];
    protected int CancellationPeriod;
    protected PlaygroundStatus status;
    private PlaygroundOwner owner;

    /**
     * Our default constructor
     */
    Playground()
    {

    }

    /**
     * This method sets playground's attributes
     * @param name Playground's name
     * @param size Playground's size
     * @param price Playground's PricePerHour
     * @param period Playground's CancellationPeriod
     * @param owner Playground's owner
     */
    Playground(String name, float size, float price, int period,PlaygroundOwner owner)
    {
        this.Name=name;
        this.Size=size;
        this.PricePerHour=price;
        this.CancellationPeriod=period;
        this.owner=owner;
        setStatus(PlaygroundStatus.INVALID);
    }

    /**
     * This method sets Playground's name
     * @param name Playground's name
     */
    public void setName(String name)
    {
        this.Name=name;
    }

    /**
     * This method sets Playground's size
     * @param size Playground's size
     */
    public void setSize(float size)
    {
        this.Size=size;
    }

    /**
     * This method sets Playground's PricePerHour
     * @param price Playground's PricePerHour
     */
    public void setPricePerHour(float price)
    {
        this.PricePerHour=price;
    }

    /**
     * This method sets Playground's CancellationPeriod
     * @param period Playground's CancellationPeriod
     */
    public void setCancellationPeriod(int period)
     {
        this.CancellationPeriod=period;
     }

    /**
     * This method sets Playground's PlaygroundOwner
     * @param owner Playground's PlaygroundOwner
     */
    public void setOwner(PlaygroundOwner owner) {

        this.owner = owner;
    }

    /**
     * This method sets the playground's status
     * @param s playground's status
     */
    public void setStatus(PlaygroundStatus s)
    {
        this.status=s;
    }
    /**
     * This method gets the Playground's Name
     * @return Playground's Name
     */
    public String getName()
    {
        return this.Name;
    }

    /**
     * This method gets the Playground's Size
     * @return Playground's Size
     */
    public float getSize()
    {
        return this.Size;
    }

    /**
     * This method gets the Playground's PricePerHour
     * @return Playgroud's PricePerHour
     */
    public float getPricePerHour()
    {
        return this.PricePerHour;
    }

    /**
     * This method gets the Playground's CancellationPeriod
     * @return Playground's CancellationPeriod
     */
    public int getCancellationPeriod()
    {
        return this.CancellationPeriod;
    }

    /**
     * This method gets the Playground's available hours
     * @param position the index of the required slot
     * @return the slot
     */
    public int getHours(int position)
    { return hours[position]; }

    /**
     * This method gets Playground's Owner
     * @return Playground's Owner
     */
    public PlaygroundOwner getOwner() { return owner; }

    /**
     * This method gets playground's status
     * @return playground's status
     */
    public PlaygroundStatus getStatus()
    {
        return this.status;
    }
    /**
     * This method is for booking hours for a specific user
     * @param Playerid the playerID to be booked for
     * @param slot the slot to be booked
     */
    public void bookHours(int Playerid, int slot)
    {
        int i=slot-1;
        hours[i] = Playerid;
    }

    /**
     * This method is for checking playground's available hours
     */
    public void checkHours()
    {
        System.out.print("[");
        for(int i=0; i<24;i++)
        {       System.out.print("slot"+(i+1)+":");
            if (hours[i]==0)
            {
                System.out.print("free"+",");
            }
            else
            {
                System.out.print("not available"+",");
            }

        }
        System.out.println("]");
    }

    /**
     * this method for showing the playground's info
     * @return the playground info
     */
    @Override
    public String toString() {
        return "Playground{" +
                "Name='" + Name + '\'' +
                ", Size=" + Size +
                ", PricePerHour=" + PricePerHour +
                ", hours=" + Arrays.toString(hours) +
                ", CancellationPeriod=" + CancellationPeriod +
                ", owner=" + owner.getName() +
                ", status=" +getStatus()+
                '}';
    }

    /**
     * This method is for checking playground's bookings
     */
    public void checkBookings()
    {
        System.out.print(getName()+"{ [");
        for(int i=0; i<24;i++)
        {       System.out.print("slot"+(i+1)+":");
            if (hours[i]==0)
            {
                System.out.print("free"+",");
            }
            else
            {
                System.out.print(hours[i]+",");
            }

        }
        System.out.println("] }");
    }

    /**
     * This method registers Playground on the system
     * @param name Plauground's name
     * @param size Plauground's size
     * @param price Plauground's PricePerHour
     * @param period Playground's CancellationPeriod
     * @param owner Playground's owner
     */
    public void registerPlayground(String name, float size, float price, int period,PlaygroundOwner owner)
    {
        this.Name=name;
        this.Size=size;
        this.PricePerHour=price;
        this.CancellationPeriod=period;
        this.owner=owner;
    }

}
