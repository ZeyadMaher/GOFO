import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hi");
        Administrator admin=new Administrator();
        UserList users=new UserList();// list for active users
        PlaygroundsList list1=new PlaygroundsList();//list for active playgrounds
        Player player=new Player(20190224,"zeyadmaher@gmail.com","zeyad","maadi","1234");
        PlaygroundOwner owner=new PlaygroundOwner(1111,"owner.com","ali","cairo","1234");

        users.Register(player,admin);//register player to system and wait for confirmation
        users.Register(owner,admin);//register owner to system and wait for confirmation
        admin.ApproveUser(users,20190224);// user confirm player with his id
        admin.ApproveUser(users,1111);// user confirm owner with his id


        Playground p1=new Playground();
        p1.registerPlayground("tetsh",100,20,15,owner);// set data for the playgrgound
        owner.addPlayground(admin,p1);// add playground p1 for owner and send to the admin to confirm
        admin.ApprovePlayground(list1,"tetsh");// admin approve

        Playground p2=new Playground();
        p2.registerPlayground("suez",90,50,15,owner);
        owner.addPlayground(admin,p2);// add playground p2 for owner and send to the admin to confirm
        admin.ApprovePlayground(list1,"suez");//admin approve

        admin.addBalance(users,20190224,1000); // admin increase balance for player with id "20190224" with 1000
        Scanner input=new Scanner(System.in);
        System.out.println("now we added 1 player,1 owner,2playgrounds for this owner to the system and \nthey're all confirmed by the admin ");


        loop: while (true)
        {
            System.out.println("What do you want to do\n1-Player functions\n2-Owner functions\n3-Exit ");
            int choose= input.nextInt();
            if (choose==1)
            {
                loop1: while (true)
                {
                    System.out.println("1-Book a Playground\n2-View my bookings\n3-Cancel Booking\n4-exit ");
                    int Pchoose= input.nextInt();
                    if (Pchoose==1)
                    {
                        player.Book(list1);

                    }
                    if (Pchoose==2)
                    {
                        player.viewBookings(list1);

                    }
                    if (Pchoose==3)
                    {
                        player.cancelBook(list1);

                    }
                    if (Pchoose==4)
                    {
                        break loop1;

                    }

                }


            }
            if (choose==2)
            {
                loop2: while (true)
                {
                    System.out.println("1-Add a Playground\n2-View bookings\n3-exit ");
                    int Pchoose= input.nextInt();
                    if (Pchoose==1)
                    {
                        System.out.println("enter name");
                        String name=input.next();
                        System.out.println("enter size");
                        float size=input.nextFloat();
                        System.out.println("enter price per hour");
                        float price=input.nextFloat();
                        System.out.println("enter cancellation period");
                        int cancel =input.nextInt();

                        Playground pg=new Playground(name,size,price,cancel,owner);
                        owner.addPlayground(admin,pg);
                        System.out.println("Playground added and waits for confirmation");
                        admin.ApprovePlayground(list1,name);
                        System.out.println("Admin approved");


                    }
                    if (Pchoose==2)
                    {
                        owner.viewBookings(list1);

                    }

                    if (Pchoose==3)
                    {
                        break loop2;

                    }

                }


            }
            if (choose==3)
            {

                break loop;
            }


        }




        /*  zoz.Book(list1);
        zoz.Book(list1);
        owner.viewBookings(list1,owner);
        list1.display();
        System.out.println(zoz.getEwallet().getBalance());
        zoz.cancelBook(list1);*/
    }
}
