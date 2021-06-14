import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleCopy {
    public static void main(String[] args) {
        int i;
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;

        try {
            fileInputStream=new FileInputStream("Test.txt");
            fileOutputStream=new FileOutputStream("Test2.txt");

            do {
                i=fileInputStream.read();
                if (i!=-1){
                    fileOutputStream.write(i);
                }
            }while (i!=-1);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO "+ e);
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            }catch (IOException e){
                System.out.println("closing error");
            }
        }

    }
}
