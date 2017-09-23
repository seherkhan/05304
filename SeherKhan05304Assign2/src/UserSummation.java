import java.util.Scanner;

/**
 * Created by Seher Khan 05304 on 9/16/2017 as a part of Assignment 2, Question 1.
 * This is a program which allows the user to input two integers to create a Summation object which represents a summation series and use the object to find its sum.
 */
public class UserSummation {
    /**
     * Prompts user to provide two integer inputs.
     * Creates a Summation object using those inputs.
     * Calls and prints the total() method on the Summation object.
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int intI=Integer.valueOf(s.nextLine());
        System.out.print("Enter the second integer: ");
        int intJ=Integer.valueOf(s.nextLine());
        Summation summation=new Summation(intI,intJ);
        System.out.println("The sum is: "+summation.total());
    }

}
