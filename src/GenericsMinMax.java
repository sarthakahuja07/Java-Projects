interface inter<T extends Comparable<T>>{
    T min();
    T max();
}
class Myclass<T extends Comparable<T>> implements inter<T>{
    T[] values;
    T v;
    Myclass(T[] o){
        values=o;
    }
    public T min(){
        v= values[0];
        for(int i=1; i<values.length;i++){
            if(values[i].compareTo(v)<0){
                v=values[i];
            }
        }
        return v;
    }
    public T max(){
        v= values[0];
        for(int i=1; i<values.length;i++){
            if(values[i].compareTo(v)>0){
                v=values[i];
            }
        }
        return v;
    }
}

public class GenericsMinMax {
    public static void main(String[] args) {
        Integer arr1[]={1,35,5235,26,26,25252};
        Double arr2[]={1.0,2.0,321.0,41.7,14.5,980.8};
        Myclass<Integer> iob= new Myclass<Integer>(arr1);
        Myclass<Double> dob= new Myclass<Double>(arr2);
        System.out.println(iob.min());
        System.out.println(iob.max());
        System.out.println(dob.min());
        System.out.println(dob.max());

    }
}
