class Pro<T>{
    T ob;
    Pro(T o){
        ob=o;
    }
    String type(){
        return ob.getClass().getName();
    }
    T pass(){
        return ob;
    }
    boolean comp(Pro<?> ob){
        if(type()==ob.type()){
            return true;
        }else{
            return false;
        }
    }

}
public class Generics {
    public static void main(String[] args) {
        Pro<String> stringpro = new Pro<String>("hello sarthak");
        Pro<Integer> integerPro= new Pro<>(30);
        Pro<Integer> integerPro2= new Pro<>(40);
        String str= stringpro.pass();
        System.out.println(str);
        stringpro.type();
        integerPro.type();
        System.out.println(stringpro.comp(integerPro));
        System.out.println(integerPro.comp(integerPro2));

    }


}
