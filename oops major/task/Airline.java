import java.util.Scanner;

class AirlineReservation
{
    private boolean seats[][];

    public AirlineReservation()
    {
        seats = new boolean[2][];
        seats[0] = new boolean[5];
        seats[1] = new boolean[10];
    }

    public int assignFirstClass()
    {
        for(int i=0;i<seats[0].length;i++)
        {
            if(!seats[0][i])
            {
                seats[0][i]=true;
                return i+1;
            }
        }
        return -1;
    }

    public int assignEconomy()
    {
        for(int i=0;i<seats[1].length;i++)
        {
            if(!seats[1][i])
            {
                seats[1][i]=true;
                return i+1;
            }
        }
        return -1;
    }

    public boolean isFull()
    {
        for(int i=0;i<seats[0].length;i++)
            if(!seats[0][i])
                return false;

        for(int i=0;i<seats[1].length;i++)
            if(!seats[1][i])
                return false;

        return true;
    }
}

public class Airline
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        AirlineReservation flight = new AirlineReservation();

        while(!flight.isFull())
        {
            System.out.println("Please type 1 for First Class");
            System.out.println("Please type 2 for Economy");

            int choice = sc.nextInt();

            int seat=-1;
            int section=0;

            if(choice==1)
            {
                seat = flight.assignFirstClass();
                section=1;

                if(seat==-1)
                {
                    System.out.println("First Class Full. Accept Economy? (1 yes / 2 no)");
                    int opt=sc.nextInt();

                    if(opt==1)
                    {
                        seat = flight.assignEconomy();
                        section=2;
                    }
                    else
                    {
                        System.out.println("Next flight leaves in 3 hours");
                        continue;
                    }
                }
            }
            else if(choice==2)
            {
                seat = flight.assignEconomy();
                section=2;

                if(seat==-1)
                {
                    System.out.println("Economy Full. Accept First Class? (1 yes / 2 no)");
                    int opt=sc.nextInt();

                    if(opt==1)
                    {
                        seat = flight.assignFirstClass();
                        section=1;
                    }
                    else
                    {
                        System.out.println("Next flight leaves in 3 hours");
                        continue;
                    }
                }
            }
            else
            {
                System.out.println("Invalid Input");
                continue;
            }

            System.out.println("------ BOARDING PASS ------");

            if(section==1)
            {
                System.out.println("Class : First Class");
                System.out.println("Seat  : F"+seat);
            }
            else
            {
                System.out.println("Class : Economy");
                System.out.println("Seat  : E"+seat);
            }

            System.out.println("---------------------------");
        }

        System.out.println("Next flight leaves in 3 hours");
        sc.close();
    }
}