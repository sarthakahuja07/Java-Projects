import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File {
    public static void main(String[] args) {
        int i;
        FileInputStream fileInputStream;

//        if(args.length!=1){
//            System.out.println("length error");
//            return;
//        }
        try {
            fileInputStream=new FileInputStream("Test.txt");
        }catch (FileNotFoundException e){
            System.out.println("error opening");
            return;
        }

        try {
            do {
                i = fileInputStream.read();
                if (i != -1)
                    System.out.print((char) i);

            }while(i!=-1);
        }catch (IOException e){
            System.out.println("IO 1");
        }finally {
            try {
                fileInputStream.close();
            }catch (IOException e){
                System.out.println("IO 2");
            }

        }

    }
}
