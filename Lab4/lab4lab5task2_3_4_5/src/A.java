/**
 * Created by Seher Khan on 9/14/2017.
 */
public class A {
    //private final int i;
    public final int i; //changed to public for Task 5
    public A(int i){
        System.out.println("Constructing A");
        this.i=i;
        //since i is final, it must be set once in the constructor before it becomes immutable
    }


    //created the following method to create a confusion I had in Task 5
    public void foo(){
        System.out.println("A's foo.");
    }
}
