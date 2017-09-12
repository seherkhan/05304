import java.util.Scanner;

//This program asks the user to input the radius of a circle and then asks and calculates the diameter, area or circumference
public class Circle {
    public static void main(String[] args) {
        float pi=(float)3.14159265;
        Scanner s= new Scanner(System.in);
        float radius;
        char reqOut; //to store required output
        String reqOutStr="";
        float ans=0;

        System.out.println("Enter radius: ");
        radius=Float.parseFloat(s.nextLine());

        System.out.println("Enter required output (A for area, C for circumference, D for diameter): ");
        reqOut=s.nextLine().toLowerCase().charAt(0); //toLowerCase() ensures program will work with a, c or d too

        //based on output variable specified by user, make calculation
        switch(reqOut){
            case 'd':
                ans=2*radius;
                reqOutStr+="diameter";
                break;
            case 'c':
                ans=2*pi*radius;
                reqOutStr+="circumference";
                break;
            case 'a':
                ans=pi*radius*radius;
                reqOutStr+="area";
                break;
        }

        //return result
        System.out.println("The "+reqOutStr+" of a circle with radius "+radius+" is "+Math.round(ans*100.0)/100.0+".");

    }
}

