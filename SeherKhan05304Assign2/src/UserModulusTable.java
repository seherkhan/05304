import java.util.Scanner;

/**
 * Created by Seher Khan 05304 on 9/16/2017 as a part of Assignment 2, Question 3.
 * This is a program which allows the user to input two integers (m and n) to create a ModulusTable object which represents the m*m modulo-n multiplication table.
 */
public class UserModulusTable {
    /**
     * Prompts user to provide two integer inputs.
     * Creates a ModulusTable object using those inputs.
     * Calls the toString() method on the ModulusTable object.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the value of modulus: ");
        int mod=Integer.valueOf(s.nextLine());
        System.out.print("Enter the table size: ");
        int tabSize=Integer.valueOf(s.nextLine());
        ModulusTable modulusTable=new ModulusTable(mod,tabSize);
        System.out.println(modulusTable);
    }
}
