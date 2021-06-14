public class Delete {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int pos=3;
        int size=5;
        for (int i=pos;i< size;i++){
            arr[i-1]=arr[i];
        }
        size--;
        for (int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
}
