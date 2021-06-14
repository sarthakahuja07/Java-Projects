import java.util.Arrays;
import java.util.Scanner;

class item_detail
{
    int price;
    String[] ingredients;
    // Create an array to keep detail of the ingredient used in an item
    String name;
    int id;
    static int total_order=0;
    item_detail(int price, String name,int id,String... args) /*create a constructor to initialize the class variable, make use of variable length arguments for input of ingredient*/
    {
        total_order++;
        this.price=price;
        this.name=name;
        this.id=id;
        int j=0;
        ingredients=new String[args.length];
        for (String i:args){
            ingredients[j++]=i;
        }
    }

    @Override
    public String toString() {
        return "item_detail{" +
                "price=" + price +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

// end of class

class person

{
    String name;
    long mobile_no;
    int order_no;
    item_detail[] history=new item_detail[20];
    int j=0;
// create an array to keep track of items the person order during his/her visit, a person can visit restaurant multiple time

    person(String name,long mobile_no)
    {
        this.name=name;
        this.mobile_no=mobile_no;
        order_no=0;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", mobile_no=" + mobile_no +
                ", order_no=" + order_no +
                '}';
    }

    void placeOrder(item_detail[] a) // this method will accept the item_detail for one order and store the detail in order history
    {
        for (item_detail i:a){
            history[j++]=i;
        }
    }
    void displayHistory() {

        for (item_detail i : history) {
            if(i==null){
                return;
            }
            System.out.println(i.name);
        }
    }

// this method will traverse array and display the detail of order the person has placed

}

// end of class

class Restaurant {
    // create an array to store the item serve by the restaurant
    item_detail[] menu = new item_detail[5];
    // create an array that will hold the detail of the customer that visit restaurant
    person[] customers = new person[10];
    int j = 0;

    Restaurant() // this constructor will initialize the menu of the restaurant
    {
        menu[0] = new item_detail(150, "burger", 20, "bun", "cheese", "patty");
        menu[1] = new item_detail(500, "pizza", 10, "base", "cheese", "sauce");
        menu[2] = new item_detail(200, "pasta", 11, "pasta", "cheese", "sauce");
        menu[3] = new item_detail(700, "cake", 44, "cream", "chocolate");
        menu[4] = new item_detail(100, "fries", 23, "potato", "cheese", "sauce");
    }


    void addCustomer(person p) // this method will add customer to the restaurant
    {
        customers[j++] = p;
    }

    void placeOrder(person p) // this method will accept person object and update the order placed by the person in his/her order history
    {

        //p.placeOrder(item_detail[] items);
    }

    void DisplayPersonHistory(person p) // this method will display the detail of the order placed by the person
    {
        p.displayHistory();
    }

    void DisplayMenu() // this method will display the item served by the restaurant
    {
        for (item_detail i : menu) {
            System.out.println(i.name);
        }
        System.out.println();
    }

    void DisplayBill(person p) // this method will display the bill of a person
    {
        int bill = 0;

        for (int k = 0; k < p.history.length; k++) {
            if(p.history[k]==null){
                break;
            }
                bill += p.history[k].price;
        }
        System.out.println("Bill : " + bill);
    }

    void totalRevenue() // this method will display the total revenue of the restaurant
    {
        int revenue = 0;
        for (person p : customers) {
            if(p==null){
                break;
            }
            for (int k = 0; k < p.history.length; k++) {
                if(p.history[k]==null){
                    break;
                }
                revenue+= p.history[k].price;
            }
        }
        System.out.println("Revenue : " + revenue+ "\n");
    }

    void displayPremiumCustomer()// this method will display the customer who has spent more than 1000 rs in the restaurant
    {   System.out.println("premium customers: ");
        for (person p : customers) {
            int bill = 0;
            if(p==null){
                break;
            }
            for (int k = 0; k < p.history.length; k++) {
                if (p.history[k]==null){
                    break;
                }
                bill += p.history[k].price;
            }
            if (bill > 1000) {
                System.out.println(p.toString());
            }
        }
    }
}

//end of class
public class Practice{
    public static void main(String[] args) {
        Restaurant restaurant=new Restaurant();
        System.out.println("MENU: \n");
        restaurant.DisplayMenu();
        person a=new person("abc",8151032);
        person b=new person("def",9160151);
        person c=new person("xyz",8196016);
        restaurant.addCustomer(a);
        restaurant.addCustomer(b);
        restaurant.addCustomer(c);
        a.placeOrder(new item_detail[]{restaurant.menu[0], restaurant.menu[2], restaurant.menu[4]});
        b.placeOrder(new item_detail[]{restaurant.menu[0],restaurant.menu[0],restaurant.menu[3]});
        c.placeOrder(new item_detail[]{restaurant.menu[3],restaurant.menu[2],restaurant.menu[1]});
        restaurant.totalRevenue();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name, mobile number and order number ");
        String name=scanner.nextLine();
        long number=scanner.nextLong();
        person p=new person(name,number);
        restaurant.addCustomer(p);
        int order=0;
        item_detail[] orderArray=new item_detail[10];
        int j=0;
        while (true){
            System.out.println("Enter you order from menu, Press 6 to exit ");
            order=scanner.nextInt();
            if(order!=6){
                orderArray[j++]=restaurant.menu[order-1];
            }else {
                break;
            }
        }
        p.placeOrder(orderArray);
        System.out.println("\n");
        restaurant.DisplayPersonHistory(p);
        System.out.println("\n");
        restaurant.DisplayBill(p);
        restaurant.totalRevenue();
        restaurant.displayPremiumCustomer();
    }
}
// create a main class that will display option to user for viewing menu of the restaurant.

// view total revenue of the restaurant

// view order history of a person and current bill of a person, a person is identified by his/her mobile number

// view premium customer

// place order

//add customer