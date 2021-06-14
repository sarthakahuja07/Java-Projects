import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            char c;

            do {
                c =((char) br.read());
            }while(c!='q');
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
