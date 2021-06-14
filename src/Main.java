import java.util.*;

class Hotel{
    String name;
    String city;
    int rooms;
    int price;
    int vacantRooms;
    int[] customer;
    Hotel(String name, String city, int rooms, int price){
        this.name=name;
        this.city=city;
        this.rooms=rooms;
        vacantRooms=rooms;
        this.price=price;
        customer=new int[rooms];
        Arrays.fill(customer,0);
    }

}
class User implements Runnable{
    String name;
    int age;
    long id;
    Thread t;
    String password;
    HotelBooking hotelBooking;
    User(String name,int age, long id, String password,HotelBooking hotelBooking){
        this.name=name;
        this.age=age;
        this.id=id;
        this.password=password;
        t=new Thread(this);
        this.hotelBooking=hotelBooking;
    }

    @Override
    public void run() {
        System.out.println("User Thread Running");
        HotelBooking hotelBooking= new HotelBooking();
        hotelBooking.BookHotel();
    }
}


class HotelBooking {
    HashMap<Long,String> hashMap;
    ArrayList<Hotel> hotels;
    ArrayList<User> users;
    HotelBooking(){
        Hotel hotel1=new Hotel("hotel 1","Delhi",10,10000);
        Hotel hotel2=new Hotel("hotel 2","Delhi",5,8000);
        Hotel hotel3=new Hotel("hotel 3","Jaipur",10,6000);
        Hotel hotel4=new Hotel("hotel 4","Jaipur",5,12000);
        Hotel hotel5=new Hotel("hotel 5","Delhi",7,15000);
        hotels=new ArrayList<>();
        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(hotel4);
        hotels.add(hotel5);
        hashMap=new HashMap<>();
        users= new ArrayList<>();
        hashMap.put((long) 199301246,"helloworld");
        hashMap.put((long) 199301247,"hello");

    }
    Scanner scanner= new Scanner(System.in);
    User signUp_signIn(){
        System.out.println("Enter ID");
        long id=scanner.nextLong();
        String password;
        User user=null;
        if (hashMap.containsKey(id)){
            do{
                System.out.println("Enter Password");
                password=scanner.next();
                if (!password.equals(hashMap.get(id))){
                    System.out.println("Try Again");
                }else{
                    System.out.println("Signed In");
                    for (User u: users){
                        if (u.password.equals(password)){
                            user=u;
                        }
                    }
                }
            }while (!hashMap.get(id).equals(password));
        }else{
            System.out.println("Enter Name");
            String name=scanner.next();
            System.out.println("Enter age");
            int age=scanner.nextInt();
            System.out.println("Enter Password");
            password=scanner.next();
            System.out.println("Signed Up");
            user=new User(name,age,id,password,this);
            users.add(user);
            hashMap.put(id,password);
        }
        return user;
    }

    synchronized void BookHotel(){
        System.out.println("Enter City");
        String city=scanner.next();
        System.out.println("Enter Date");
        try {
            String date=scanner.next();
            String[] date1=date.split("-",3);
            if(Integer.parseInt(date1[0])>12 || Integer.parseInt(date1[1])>31 ){
                throw new RuntimeException();
            }
        }catch (RuntimeException e){
            System.out.println("Invalid date");
            return;
        }

        ArrayList<Hotel>available=new ArrayList<>();
        int i=1;
        for (Hotel h: hotels){
            if (h.city.equals(city)){
                available.add(h);
                System.out.println(i+") "+h.name+"\t"+h.price+"\t"+"No. of rooms available ="+h.vacantRooms);
                i++;
            }
        }
        int choice=scanner.nextInt();
        Hotel chosenRoom=available.get(choice-1);
        System.out.println(chosenRoom.name);
        System.out.println("Number of rooms ");
        int rooms=scanner.nextInt();
        System.out.println("Number of people ");
        int people=scanner.nextInt();
        for (int j=0;j<rooms;j++){
            System.out.println("Available rooms: ");
            for (int k=0;k<chosenRoom.rooms;k++){
                if(chosenRoom.customer[k]==0){
                    System.out.print(k+" ");
                }
            }
            System.out.println("");
            int roomChoice=scanner.nextInt();
            chosenRoom.customer[roomChoice]=1;
            chosenRoom.vacantRooms--;
        }
        for (int k=0;k<people;k++){
            System.out.println("Enter name");
            String name=scanner.next();
            System.out.println("Enter age");
            int age=scanner.nextInt();
        }
        System.out.println("Total Bill: " +(rooms*chosenRoom.price));
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String choice="yes";
        HotelBooking hotelBooking=new HotelBooking();
        User user1= new User("Sarthak",19,199301246,"helloworld",hotelBooking);
        User user2= new User("user2",22,199301247,"hello",hotelBooking);
        hotelBooking.users.add(user1);
        hotelBooking.users.add(user2);
        while (choice.equals("yes")){
            User user=hotelBooking.signUp_signIn();
            System.out.println("");
            user.run();
            System.out.println("Continue yes/no");
            choice=scanner.next();
        }
    }
}
