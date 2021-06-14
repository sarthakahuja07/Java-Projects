public class Insertion {
    public static int[] insert(int arr[],int element, int pos){
        for(int i= arr.length-1; i>=pos;i--){
            arr[i]=arr[i-1];
        }
        arr[pos-1]=element;
        return arr;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int arr2[];
        arr2=insert(arr,9,3);
        for (int i=0;i< arr2.length;i++){
            System.out.println(arr2[i]);
        }
    }
}
