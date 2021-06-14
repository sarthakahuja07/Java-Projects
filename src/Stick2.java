public class Stick2 {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        int[] ar, arTemp;
        int length=arr.length;

        arTemp=new int[length];
        int i,h=0;
        int large=arr[1];
        int small;
        int j=0;
        int hi=0;
        int countLoop=0;

        while(large!=0)
        {   countLoop++;
            int count=0;
            small=large;
            for(i=0;i<length && arr[i]!=0;i++)
            {
                if(small>=arr[i])
                {
                    small=arr[i];
                }
            }
            //System.out.println(small);

            for(i=0;i<length && arr[i]!=0;i++)
            {
                if(large<arr[i])
                {
                    //System.out.println("hi");
                    large=arr[i];
                }
            }
            //System.out.println(large);

            for(i=0;i<length ;i++)
            {   if(arr[i]!=0){
                arr[i]=arr[i]-small;
                count++;
            }

            }
            System.out.println(count);
            arTemp[j]=count;
            j++;
            large=large-small;
            hi++;
        }
        ar=new int[countLoop];
        for (i=0;i<countLoop;i++){
            ar[i]=arTemp[i];
        }
        return ar;
    }


    public static void main(String[] args)  {
        int arr[]={5,4,4,2,2,8};
        int ar[];
        ar=cutTheSticks(arr);

    }
}