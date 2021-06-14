import java.util.Scanner;

public class TwoDarraySort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] arr =new int[4][4];
        int small;
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        for (int i=0;i<4;i++){
            for (int j=0;j<3;j++){
                small=arr[i][j];
                int pos=j;
                for (int k=j+1;k<4;k++){
                    if (arr[i][k]<small){
                        small=arr[i][k];
                        pos=k;
                    }
                }
                int temp=arr[i][pos];
                arr[i][pos]=arr[i][j];
                arr[i][j]=temp;
            }
        }
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(arr[i][j]+" 3");
            }
            System.out.println();
        }
//        char[] chars={'a','b','4','g',65};
//        System.out.println(chars[0]);
//        System.out.println(chars[1]);
//        System.out.println(chars[2]);
//        System.out.println(chars[3]);
//        System.out.println(chars[4]);
//        System.out.println(chars);
        
    }
}
