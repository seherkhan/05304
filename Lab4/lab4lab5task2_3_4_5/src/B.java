/**
 * Created by Seher Khan on 9/14/2017.
 */
public class B extends A {
    public int i; //made public for Task 5
    public B(int i){
        super(i);
        System.out.println("Constructing B");
    }


    //created the following method to create a confusion I had in Task 5
    public void foo(){
        System.out.println("B's foo.");
    }
}
