import javax.swing.*;
import java.util.Scanner;

public class TwoDmin {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a[][]=new int[3][3];
        int rowMin[]=new int[3];
        int columnMin[]=new int[3];
        int min;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                a[i][j]=scanner.nextInt();
            }
        }
        for (int i=0;i<3;i++){
            min=a[i][0];
            for (int j=0;j<3;j++){
                if (a[i][j]<min){
                    min=a[i][j];
                }
            }
            rowMin[i]=min;
        }
        for (int i=0;i<3;i++){
            min=a[0][i];
            for (int j=0;j<3;j++){
                if (a[j][i]<min){
                    min=a[j][i];
                }
            }
            columnMin[i]=min;
        }
        System.out.println("Row min");
        for (int i=0;i<3;i++){
            System.out.println(rowMin[i]);
        }
        System.out.println("column min");
        for (int i=0;i<3;i++){
            System.out.println(columnMin[i]);
        }
    }
}
