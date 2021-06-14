public class DeleteDupli {
    public static void main(String[] args) {
       int [] arr={3,4,1,3,5,5,3};
       int size= arr.length;
       for (int i=0;i<size;i++){
           for (int j=i+1;j<size;j++){
               if (arr[j]==arr[i]){
                   for (int k=j;k<size-1;k++){
                       arr[k]=arr[k+1];
                   }
               size--;
               }
           }
       }
       for (int i=0;i<size;i++){
           System.out.println(arr[i]);
       }
        int a[][] = {
                {1, 2, 3},
                {4, 5, 6, 9},
                {7},
        };
    }
}
