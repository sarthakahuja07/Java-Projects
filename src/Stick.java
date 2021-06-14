import java.lang.*;

public class Stick {

    // Complete the cutTheSticks function below.

    static int[] cutTheSticks(int[] arr) {
        int[] ar,arTemp;
        int length=arr.length;
        arTemp=new int[length];
        boolean isBreak=false,innerBreak=false;
        int j=0,i,count=0,sum=0;
        int arr2[]=new int[length];
        for (i=0;i<length;i++){
            arr2[i]=0;
        }
        while(isBreak==false)
        {   innerBreak=false;
            //System.out.println("in loop");
            count++;
            sum=0;
            int small;
            int c=0;
            if(arr[0]!=0){
               small=arr[0];
                for(i=0;i<length;i++)
                {
                    if(arr[i]<small && arr[i]!=0)
                        small=arr[i];
                }
            }else{
                small=0;
                while (innerBreak==false){
                    small++;
                    for (i=0;i<length;i++){
                        if(arr[i]==small){
                            small=arr[i];
                            //System.out.println(small);
                            innerBreak=true;
                            break;
                        }
                    }
                }
            }

            for(i=0;i<length;i++)
            {
                if(arr[i]!=0){
                    arr[i]=arr[i]-small;
                    c++;
                }
            }
            //System.out.println(c);
            arTemp[j]=c;
            j++;
            for (i=0;i<length;i++){
               sum+=arr[i];
            }
            //System.out.println("sum "+ sum);

            if(sum==0){
                //System.out.println("break");
                isBreak=true;
            }

        }
        ar=new int[count];
        for (i=0;i<count;i++){
            ar[i]=arTemp[i];
        }
        return ar ;
    }


    public static void main(String[] args)  {
          int arr[]={5,4,4,2,2,8};
          int ar[];
      ar=cutTheSticks(arr);
         for(int element :ar){
           System.out.println(element);
       }
    }
}