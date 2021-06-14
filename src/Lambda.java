import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

interface Myinter {
    double show();
}
interface  Myint2 {
    int calc(int n);
}
public class Lambda {
    public static void main(String[] args) throws IOException {
        Myinter myinter;
        myinter= () -> 34;
        System.out.println(myinter.show());
        Random rand = new Random();
        myinter= () -> rand.nextDouble() *100;
        System.out.println(myinter.show());
        System.out.println(myinter.show());
        Myint2 myint2;
        myint2 = (n) -> n/2;
        System.out.println(myint2.calc(6));
        myint2= (n)-> {

            int a=1;
            for (int i=1; i<=n;i++){
                a*=i;
            }
            return a;
        };
        System.out.println(myint2.calc(5));

    }

}
