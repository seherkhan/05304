/**
 * Created by Seher Khan on 9/14/2017.
 */
public class ConstructorDemo {
    public static void main(String[] args) {
        A objA= new A(3);
        System.out.println();
        B objB= new B(5);
        System.out.println();
        C objC= new C(30);

        //Task 4: compiler inserts "super()" in the first line of any constructor.
        //Hence when I call C(), it calls B() which in turn calls A() which returns, then B() returns, and finally C() returns

        //Task 5a): when I change constructor B after changing A(), it says no default constructor found in super class.
        //This happens because compiler is automatically inserting super() in first line of B(int i) but cannot find A() in class A
        //To counter this I will manually type super(int i) in the constructor B(int i) of class B
        //Similarly, I will manually type super(int i) in the constructor C(int i) of class C

        //Task 5b):
        A obj= new B(5);
        System.out.println("obj of Ref A and Type B gives obj.i="+obj.i);

        //The constructor of B is assigning value to A's i only. So A's i is 5 and B's i remains 0.

        //At compile time obj's reference type (A) is known and program compiles because I made A's i public for this task
        //At runtime obj's object type (B) is known. I thought this would mean obj.i would return B's i, i.e. 0
        //however instead obj.i returned A's i, i.e. 5

        //On the other hand. If I called foo() on obj,
        //At compile time obj's reference type (A) is known and program compiles because foo() exists in A
        //At runtime obj's object type (B) is known and thus obj.foo() calls foo() of B
        obj.foo();

    }
}
