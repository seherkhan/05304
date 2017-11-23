package Task4;

import java.util.Stack;

/**
 * Created by Seher Khan on 11/23/2017.
 */
public class MaxStack {
    private int[] stk;
    private int top;
    public MaxStack(int size){
        stk = new int[size];
        top=-1;
    }
    public Integer pop(){
        if(!isEmpty()){
            int i = stk[top];
            top--;
            return i;
        }
        return null;
    }
    public void push(int i){
        if(!isFull()){
            if(isEmpty()){
                top++;
                stk[top]=i;
                return;
            }
            else if(i>stk[top]){
                top++;
                stk[top]=i;
                return;
            }
            else {
                Stack<Integer> popped = new Stack<>();
                while(!isEmpty()&&getMax()>i){
                    popped.push(pop());
                }
                top++;
                stk[top] = i;
                while (!popped.isEmpty())
                    push(popped.pop());
                return;
            }
        }
    }
    public Integer getMax(){
        if(isEmpty())
            return null;
        else
            return stk[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==stk.length-1;
    }
    public void display(){
        System.out.print("[ ");
        for (int i: stk)
            System.out.print(i+" ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        MaxStack s = new MaxStack(10);
        s.display();
        System.out.println(s.getMax());
        s.push(10);
        s.push(11);
        s.display();
        System.out.println(s.getMax());
        s.push(9);
        s.display();
        System.out.println(s.getMax());
        s.pop();
        s.display();
        System.out.println(s.getMax());

    }

}
