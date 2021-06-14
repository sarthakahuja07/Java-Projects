public class SelectionSort {
    public static void main(String[] args) {
        int small,pos;
        int[] arr={3,5,2,25,1,23,6};
        for (int i=0;i<arr.length-1;i++){
            pos=i;
            small=arr[i];
            for (int j=i+1;j<arr.length;j++){
                //System.out.println("hi");
                if (arr[j]<small){
                    small=arr[j];
                    pos=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[pos];
            arr[pos]=temp;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
