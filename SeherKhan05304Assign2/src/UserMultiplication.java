import java.util.Scanner;

/**
 * Created by Seher Khan 05304 on 9/16/2017 as a part of Assignment 2, Question 2.
 * This is a program which allows the user to input two integers to create a Multiplication object which represents a multiplication series and use the object to find its product.
 */
public class UserMultiplication {
    /**
     * Prompts user to provide two integer inputs.
     * Creates a Multiplication object using those inputs.
     * Calls and prints the product() method on the Summation object.
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int intI=Integer.valueOf(s.nextLine());
        System.out.print("Enter the second integer: ");
        int intJ=Integer.valueOf(s.nextLine());
        Multiplication multiplication=new Multiplication(intI,intJ);
        System.out.println("The product is: "+multiplication.product());
    }

}
