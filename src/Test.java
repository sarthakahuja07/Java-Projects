import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
class Stack {

    int tos;
    int a[];

    Stack(int size) {
        a=new int[size];
        tos= -1;
    }

    void push(int z) {
        if (tos == a.length - 1) {
            System.out.println("full");
        } else {
            a[++tos] = z;

        }
    }
    int pop(){
        return a[tos--];
    }
}



public class Test {
    public static void main(String[] args) {

        Stack stack=new Stack(20);
        stack.push(4);
        stack.push(5);
        stack.push(8);
        stack.push(5);
        stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());




    }

    private void set() {
    }
}
