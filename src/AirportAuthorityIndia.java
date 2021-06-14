import java.util.ArrayList;
import java.util.*;

class CapacityExceed extends RuntimeException{
    CapacityExceed(String e){
        super(e);
    }
}
class Baggage
{
    int weight ;
    Baggage(int weight)
    {
        this.weight=weight;
    }
}
class ConveyerBelt
{
    final int capacity=10;
    // Declare variable to store Baggage; [1 M]
    ArrayList<Baggage> baggageArrayList= new ArrayList<>();
    /*this method will add bag in above declare variable. If Conveyer Belt capacity exceed it will throw
CapacityExceed Exception. Use proper syntax to handle the exception Create your own CapacityExceed
Exception */
    public void add(Baggage bag) // this method can be used by one thread at a time modify suitably [1 M]
    {
        try{
            synchronized (this){
                if (baggageArrayList.size()<capacity){
                    baggageArrayList.add(bag);
                    System.out.println("Bag Added");
                }
                else {
                    throw new CapacityExceed("Conveyer Belt is full");
                }
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }


    }
}
class CheckIn
{
    public boolean CheckBaggageWeight(Baggage Bag)
    {
        if (Bag.weight>15){
            return false;
        }
        return true;
        // if Bag weight is more than 15 kg the method will return false else return true [1 M]
    }
}
class Passenger extends Thread // this will inherit Thread class, make suitable modification
{
    Thread t;
    /* create an constructor that will accept object of chekin, ConveyerBelt and plane class and store them in
member variable */
    CheckIn checkIn;
    ConveyerBelt conveyerBelt;
    Plane plane;
    Passenger(CheckIn checkIn,ConveyerBelt conveyerBelt, Plane plane){
        this.checkIn=checkIn;
        this.conveyerBelt=conveyerBelt;
        this.plane=plane;
        t=new Thread(this);
    }

    synchronized public void boardPassenger (int row, int seat)
    {
        Scanner scanner=new Scanner(System.in);
        Baggage baggage;
        System.out.println("Enter Weight of baggage");
        int weight=scanner.nextInt();
        baggage=new Baggage(weight);
        if (plane.seats[row][seat]==0){
            plane.seats[row][seat]=1;
            if (checkIn.CheckBaggageWeight(baggage)){
                conveyerBelt.add(baggage);
            }else {
                System.out.println("Bag is too heavy");
            }
        }else {
            System.out.println("seat is filled");
        }

//this method will change t he value of array seat as per input argument. [1M]
//this method will use object of checkin to check Baggage weight if it is less than 15 it will add Baggage to[3M]
//ConveyerBelt

    }
//override run method, this will call boardPassenger method [1M]
    synchronized public void run() {
        Scanner scanner= new Scanner(System.in);
        System.out.println(t.getName()+" Thread Running");
        System.out.println("Enter Row");
        int row=scanner.nextInt();
        System.out.println("Enter seat");
        int seat=scanner.nextInt();
        boardPassenger(row,seat);

    }
}
class Plane
{
    int[][] seats=new int[30][6];// 30 rows having 6 seat each
//create a constructor to initialize the seat array, 0 means vacant 1 means filled. [2M]
    Plane(){
        for (int[]a:seats){
            Arrays.fill(a,0);
        }
    }
}
public class AirportAuthorityIndia
{

    public static void main(String[] args)
{
    ConveyerBelt conveyerBelt=new ConveyerBelt();
    CheckIn checkIn=new CheckIn();
    Plane plane=new Plane();
    //Create at least three passengers and start the thread. [1M]

    Thread main=Thread.currentThread();
    main.setName("Main");

    Passenger passenger1=new Passenger(checkIn,conveyerBelt,plane);
    Passenger passenger2=new Passenger(checkIn,conveyerBelt,plane);
    Passenger passenger3=new Passenger(checkIn,conveyerBelt,plane);
    passenger1.t.setName("Passenger1");
    passenger2.t.setName("Passenger2");
    passenger3.t.setName("Passenger3");
    passenger1.t.start();
    try{
        passenger1.t.join();
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    passenger2.t.start();
    try{
        passenger2.t.join();
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    passenger3.t.start();
    try{
        passenger3.t.join();
    }catch (InterruptedException e){
        e.printStackTrace();
    }

    // Set name for each thread [1M]
    // main thread will wait for passenger thread to terminate [1M]
    try {
        System.out.println("Waiting for threads to finish.");
        passenger1.t.join();
        passenger2.t.join();
        passenger3.t.join();
    } catch (InterruptedException e) {
        System.out.println("Main thread Interrupted");
    }
    System.out.println("Main thread exiting.");


}
}