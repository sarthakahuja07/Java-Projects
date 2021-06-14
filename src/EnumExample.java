import javax.naming.Name;

enum Names{
    sarthak(7),akshay(6),anku(4),latika(10),pooja(5);
    int length;
    Names(int a){
        length=a;
    }
    int getLength(){
        return length;
    }
}

public class EnumExample {
    public static void main(String[] args) {
        Names name1, name2, name3;
        name1=Names.sarthak;
        name2=Names.anku;
        name3=Names.akshay;
        System.out.println(name1.ordinal());
        System.out.println(name2.ordinal());
        System.out.println(name3.ordinal());
        if(name1.compareTo(name2)<0){
            System.out.println("small");
        }
        Names names[]=Names.values();
        for (Names name:names){
            System.out.println(name);
        }
        Names name4=Names.valueOf("latika");
        Names name5=Names.valueOf(name4.toString());
        System.out.println(name4);
        System.out.println(name5);

    }
}
