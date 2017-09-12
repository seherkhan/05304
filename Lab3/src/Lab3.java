/**
 * Created by Seher Khan on 9/12/2017.
 */
public class Lab3 {
    //Testing Person and Name classes
    public static void main(String[] args) {
        //setup
        Name sk = new Name("Seher","A","Khan");
        Name sk1 = new Name("Seher","A","Khan");
        Name hk = new Name("Hina", "S", "Khan");
        Name mt = new Name("Maryam", "A", "Tajalli");
        Name sh = new Name("Sara","K","Hashim");
        Person P1=new Person(534,sk);
        Person P2=new Person(489,hk);
        Person P3=new Person(534,sk1);
        Person P4=new Person(123,mt);
        Person P5=new Person(114,sh);
        Person P6=new Person(114,sh,MartialStatus.MARRIED,Department.MARKETING,Grade.THREE);

        Person[] ppl=new Person[6];

        //name format methods
        System.out.print("sk in first-last format: ");
        sk.flFormat();
        System.out.print("\nsk in last-first-mInitial format: ");
        sk.lfmFormat();
        System.out.print("\nsk in first-mInitial-last format: ");
        sk.fmlFormat();


        //testing equals method of Name
        System.out.println("\nThe result of comparing sk to sk1 is: "+sk.equals(sk1)); //expect true (equal)
        System.out.println("The result of comparing sk to hk is: "+sk.equals(hk)); //expect false (unequal)

        //testing compareTo method of Person
        System.out.println("The result of comparing P1 to P2 is: "+P1.compareTo(P2)); //expect 1 (unequal)
        System.out.println("The result of comparing P1 to P3 is: "+P1.compareTo(P3)); //expect 0 (equal)
        System.out.println("The result of comparing P5 to P6 is: "+P1.compareTo(P3)); //expect 1 (equal), this indicates a loop hole in our current definition of compareTo

        ppl[0]=P1;
        ppl[1]=P2;
        ppl[2]=P3;
        ppl[3]=P4;
        ppl[4]=P5;
        ppl[5]=P6;

        System.out.println("Record of ID 534 occurs at: "+Person.hashFunction(534,ppl)); //expect 0
        System.out.println("Record of ID 123 occurs at: "+Person.hashFunction(123,ppl)); //expect 3
        System.out.println("Record of ID 100 occurs at: "+Person.hashFunction(100,ppl)); //expect -1





    }
}
