public class BinarySearch {
    public static int search(int arr[], int number){
        int high,low,mid,answer=0;
        low=0;
        high=arr.length-1;
        do {
            //System.out.println("hi");
            mid=(low+high)/2;
            if (arr[mid]==number){
                answer=mid+1;
            }
            else if(number>arr[mid]){
                low=mid+1;
                high=high;
                //System.out.println(low);
                //System.out.println(high);

            }
            else if (number<arr[mid]){
                high=mid-1;
                low=low;
                //System.out.println(low);
                //System.out.println(high);

            }
        }while (number!=arr[mid] && low<=high);
        return answer;
    }

    public static void main(String[] args) {
        int arr[]={3,6,9,12,56,101};
        int answer=search(arr,12);
        if (answer==0){
            System.out.println("not found");
        }
        else {
            System.out.println(answer);
        }
    }
}
