interface stackInter{
    void push(int a);
    int pop();
}
class Dynamic implements stackInter{
    int stck[];
    int tos;

    Dynamic(int size){
        tos=-1;
        stck=new int[size];

    }

    @Override
    public void push(int a) {
        if(tos== stck.length-1){
            int temp[]=new int[stck.length*2];
            for (int i=0;i<stck.length; i++){
                temp[i]=stck[i];
            }
            stck=temp;
            stck[++tos]=a;
        }
        else {
            stck[++tos]=a;
        }
    }

    @Override
    public int pop() {

        return stck[tos--];
    }
}
public class DynStack {
    public static void main(String[] args) {
        Dynamic dynamic= new Dynamic(5);
        dynamic.push(1);
        dynamic.push(2);
        dynamic.push(3);
        dynamic.push(4);
        dynamic.push(5);
        dynamic.push(6);
        dynamic.push(4);

        System.out.println(dynamic.pop());
        System.out.println(dynamic.pop());
        System.out.println(dynamic.pop());
        System.out.println(dynamic.pop());
        System.out.println(dynamic.pop());
        System.out.println(dynamic.pop());


    }

}
