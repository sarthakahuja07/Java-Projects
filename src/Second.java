public class Second {
    public static void main(String[] args) {
        int arr[]={1,4,6,2,10,75,34};
        int smallest=arr[0],secondSmallest=arr[1],largest=arr[0],secondLargest=arr[1];
        for (int i=1; i< arr.length;i++){
            if (arr[i]<smallest){
                secondSmallest=smallest;
                smallest=arr[i];
            }
            else if (arr[i]<secondSmallest) {
                secondSmallest = arr[i];
            }
            if (arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
            else if (arr[i]>secondLargest) {
                secondLargest = arr[i];
            }

        }
        System.out.println(smallest);
        System.out.println(secondSmallest);
        System.out.println(largest);
        System.out.println(secondLargest);
    }

}
