class Box{
    int height;
    int width;
    int breadth;
    int volume;
    Box(){
        this(1,1,1);
    }
    Box(int h,int w,int b){
        this.height=h;
        this.width=w;
        this.breadth=b;
    }
    Box(int length){
        this.height=this.breadth=this.width=length;
    }

    Box(Box o){
        height=o.height;
        width=o.width;
        breadth=o.breadth;
    }
    int calcVolume(){
        volume=breadth*height*width;
        return volume;
    }
}
class BoxWeight extends Box {
    int weight;
    BoxWeight(int h,int w,int b,int m){
        super(h,w,b);
        weight=m;
    }
    BoxWeight(int l,int m){
        super(l);
        weight=m;
    }
    BoxWeight(BoxWeight bo){
        super(bo);
        weight=bo.weight;
    }
    BoxWeight(){
        super();
        weight=-1;
    }
    int calcWeight(){
        return (weight*10);
    }

}

public class Inherit {
    public static void main(String[] args) {
        BoxWeight boxWeight=new BoxWeight(10,5,5,20);
        BoxWeight boxWeight2=new BoxWeight(10,5);
        BoxWeight boxWeight3=new BoxWeight(boxWeight);
        BoxWeight boxWeight4=new BoxWeight();
        System.out.println(boxWeight.calcVolume());
        System.out.println(boxWeight2.calcVolume());
        System.out.println(boxWeight3.calcVolume());
        System.out.println(boxWeight4.calcVolume());
        System.out.println(boxWeight.calcWeight());
        System.out.println(boxWeight2.calcWeight());
        System.out.println(boxWeight3.calcWeight());
        System.out.println(boxWeight4.calcWeight());




    }
}
