import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Details{
    String type;
    float rating;
    String director;
    String[] actorsArray;

    @Override
    public String toString() {
        return
                ", rating=" + rating +
                ", director='" + director + '\'' +
                ", actorsArray=" + Arrays.toString(actorsArray) +
                '}';
    }
}

class Content{
    private String name;
    int time;
    private String production_company;
    Details details=new Details();
    Content(String name, int time, String production_company) {
        this.name = name;
        this.time = time;
        this.production_company = production_company;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public String getProduction_company() {
        return production_company;
    }

    public void setProduction_company(String production_company) {
        this.production_company = production_company;
    }

    @Override
    public String toString() {
        return "Content{" +
                "type='" + details.type + '\'' +
                ", rating=" + details.rating +
                ", director='" + details.director + '\'' +
                ", actorsArray=" + Arrays.toString(details.actorsArray) +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", production_company='" + production_company + '\'' +
                '}';
    }
}

class Movie extends Content{

    Movie(String name, int time, String production_company,String type,float rating,String director,String...actors) {
        super(name, time, production_company);
        details.type=type;
        details.director=director;
        details.rating=rating;
        details.actorsArray= new String[actors.length];
        int j=0;
        for (String a:actors){
            details.actorsArray[j++]=a;
        }
    }
}
class Season{
        Details SeasonDetails = new Details();
        int season_number;
        Season(int season_number,float rating,String director,String... actors){
            this.season_number=season_number;
            SeasonDetails.rating=rating;
            SeasonDetails.director=director;
            SeasonDetails.actorsArray= new String[actors.length];
            int j=0;
            for (String i: actors){
                SeasonDetails.actorsArray[j++]=i;
            }
        }

    @Override
    public String toString() {
        return
                "SeasonDetails=" + SeasonDetails +
                '}';
    }
}

class Show extends Content{
    int no_of_seasons;
    Season[] seasons;
    Show(String name, int time, String production_company, String type, int no_of_seasons) {
        super(name, time, production_company);
        details.type=type;
        this.no_of_seasons=no_of_seasons;
        seasons=new Season[no_of_seasons];
    }

    @Override
    public String toString() {
        ArrayList<String > casts=new ArrayList<>();
        for (int i=0; i<no_of_seasons;i++){
            casts.add("Season "+(i+1)+":"+seasons[i].toString()+"\n");
        }
        return "{name=" +getName()+
                ",time="+getTime()+
                ",type='" + details.type + '\'' +
                ", production_company='" + getProduction_company()+ '\'' +
                ", no_of_seasons=" + no_of_seasons+'\n' +casts+"}" ;
    }
}

class Audio_book extends Content{
    String narrator;
    String Author;
    Audio_book(String name, int time, String production_company,float rating,String type,String narrator,String author) {
        super(name, time, production_company);
        this.narrator=narrator;
        this.Author=author;
        details.type=type;
        details.rating=rating;
    }

    @Override
    public String toString() {
        return "Audio_book{" +
                ",name=" +getName()+
                ",time="+getTime()+
                ",type='" + details.type + '\'' +
                ", rating=" + details.rating +
                ", production_company='" + getProduction_company()+ '\'' +
                ", narrator='" + narrator + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}

class Customer{
    String name;
    private Long number;
    Customer(String name, long number){
        this.name=name;
        this.number=number;
    }
    public Long getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

class myException extends RuntimeException{
    myException(String e){
        super(e);
    }
}

public class MovieStreaming {
    Movie movie1,movie2;
    Show show1,show2;
    Audio_book audio_book1;
    Audio_book audio_book2;
    static ArrayList<Content> contents= new ArrayList<>();
    static ArrayList<Customer> customers= new ArrayList<>();
    MovieStreaming(){
        movie1=new Movie("Godfather",10680,"paramount pictures","Thriller",9.2f,"francis ford","AL Pacino","Marlon Brandon","James Caan");
        movie2=new Movie("ForrestGump",8520,"Sony","Drama",8.8f,"Robert","Tom Hanks","Robin Wright");
        show1=new Show("BreakingBad",223200,"AMC","Thriller",2);
        show1.seasons[0]=new Season(1,8.8f,"vince","Bryan Cranston","Aaron Paul");
        show1.seasons[1]=new Season(2,9.0f,"Vince","Bryan cranston","Anna Gunn");
        show2=new Show("GameOfThrones",105360,"HBO","Drama",2);
        show2.seasons[0]=new Season(1,9.3f,"Alan Taylor","Sean Bean","Lena Heady");
        show2.seasons[1]=new Season(2,9.2f,"Alik Sakharov","Emilia Clarke","Kit Harrington");
        audio_book1=new Audio_book("RiversOfLondon",90560,"Sony Pictures",9.0f,"mystery","Kobna","Ben");
        audio_book2=new Audio_book("TheHandmaid'sTale",11302,"Sony Pictures",8.2f,"comedy","David Sedaris","George Saunders");
        Content[] contentsArray= new Content[]{movie1, movie2, show1, show2, audio_book1, audio_book2};
        contents.addAll(Arrays.asList(contentsArray));
        Customer[] customersArray= new Customer[]{new Customer("A", 961819512), new Customer("B", 916916015), new Customer("C", 889150153)};
        customers.addAll(Arrays.asList(customersArray));
    }
    static Scanner scanner= new Scanner(System.in);
    static int index=0;
    static boolean searchContent(String name){
        index=0;
        boolean found=false;
        try{
            for (Content i:contents){
                if (i.getName().equals(name)){
                    System.out.println(i.toString());
                    found=true;
                    break;
                }
                index++;
            }
            if (!found){
                throw new myException("Content Not Found");
            }
        }catch (myException e) {
            System.out.println(e.toString());
        }
        return found;

    }
    static boolean searchCustomer(long number){
        index=0;
        boolean found=false;
        try{
            for (Customer c: customers){
                if (c.getNumber()==number){
                    System.out.println(c.toString());
                    found=true;
                    break;
                }
                index++;
            }
            if (!found){
                throw new myException("Customer Not Found");

            }
        }catch (myException e) {
            System.out.println(e.toString());
        }
        return found;
    }
    static void addOrDeleteCustomer(){
        System.out.println("1: Add customer \n2: Delete Customer");
        int choice=scanner.nextInt();
        if(choice==1){
            System.out.println("Enter name");
            String name=scanner.next();
            System.out.println("Enter number");
            long number=scanner.nextLong();
            try {
                boolean found=searchCustomer(number);
                if(found){
                    throw new myException("Customer already present");
                }else {
                    customers.add(new Customer(name,number));
                    System.out.println("Customer Added");
                }
            }catch (myException e){
                System.out.println(e.toString());
            }

        }else if(choice==2){
            System.out.println("Enter number");
            long number=scanner.nextLong();
            try {
                boolean found=searchCustomer(number);
                if(found){
                    customers.remove(index);
                    System.out.println("Customer Deleted");
                }else {
                    throw new myException("No Customer Found");
                }
            }catch (myException e){
                System.out.println(e.toString());
            }
        }
    }
    static void addOrDeleteContent(){
        System.out.println("1: Add content \n2: Delete content");
        int choice=scanner.nextInt();
        if(choice==1){
            System.out.println("Enter name");
            String name=scanner.next();
            System.out.println("Enter time");
            int time=scanner.nextInt();
            System.out.println("Enter production");
            String production=scanner.next();
            try {
                boolean found=searchContent(name);
                if(found){
                    throw new myException("Content already present");
                }else {
                    contents.add(new Content(name,time,production));
                    System.out.println("Content Added");
                }
            }catch (myException e){
                System.out.println(e.toString());
            }
        }else if(choice==2){
            System.out.println("Enter name");
            String name=scanner.next();
            try {
                boolean found=searchContent(name);
                if(found){
                    contents.remove(index);
                    System.out.println("Content Deleted");
                }else {
                    throw new myException("No Content Found");
                }
            }catch (myException e){
                System.out.println(e.toString());
            }
        }
    }
    static void editContent(){
        System.out.println("Enter the name of Content you want to change ");
        String name=scanner.next();
        boolean found =searchContent(name);
        if(!found){
            throw new myException("No Content Found");
        }else{
            System.out.println("1: change name \n2:change time \n3: change production");
            int choice=scanner.nextInt();
            if(choice==1 || choice==2){
                throw new myException("Cant edit this field");
            }else{
                System.out.println("Enter new Production name");
                String newName= scanner.next();
                contents.get(index).setProduction_company(newName);
                System.out.println("Edited Content: "+ contents.get(index));

            }
        }
    }
    static void editCustomer(){
        System.out.println("Enter the number of customer you want to change ");
        long number=scanner.nextLong();
        boolean found =searchCustomer(number);
        if(!found){
            throw new myException("No customer Found");
        }else{
            System.out.println("1: change name \n2:change number");
            int choice=scanner.nextInt();
            if(choice==2){
                throw new myException("Cant edit this field");
            }else{
                System.out.println("Enter new name");
                String newName= scanner.next();
                customers.get(index).setName(newName);
                System.out.println("Edited Customer: "+ customers.get(index));
            }
        }
    }
    public static void main(String[] args) {
        MovieStreaming movieStreaming=new MovieStreaming();
        boolean exit=false;
        do {
            System.out.println(" Menu \n1: search content\n2: search customer\n3: add or delete content\n" +
                    "4: add or delete customer\n5: Edit content\n6: Edit customer\n7: exit\n **Already Entered some of the contents and customers in MovieStreaming()**");
            int newChoice=scanner.nextInt();
            switch (newChoice){
                case 1:{
                    System.out.println("Enter name");
                    String name= scanner.next();
                    searchContent(name);
                    break;
                }
                case 2:{
                    System.out.println("Enter number");
                    long number= scanner.nextLong();
                    searchCustomer(number);
                    break;
                }
                case 3:{
                    addOrDeleteContent();
                    break;
                }
                case 4:{
                    addOrDeleteCustomer();
                    break;
                }
                case 5:{
                    editContent();
                    break;
                }
                case 6:{
                    editCustomer();
                    break;
                }

                case 7: exit=true;
                break;
            }

        }while (!exit);

    }

}
