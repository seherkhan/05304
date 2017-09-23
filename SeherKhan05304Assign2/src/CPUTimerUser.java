import java.util.Scanner;

/**
 * Created by Seher Khan on 9/21/2017.
 * This program allows the user to compute the time taken for a program to run. The user can choose in what way s/he would like to compute the result.
 */

public class CPUTimerUser {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Select an option: ");
        System.out.println("Option 1");
        System.out.println("Option 2");
        System.out.println("Option 3");
        int i = Integer.valueOf(s.nextLine());
        CPUTimer cpuTimer;
        switch (i){
            case 1:
                System.out.print("Enter Instruction Count: ");
                int a=Integer.parseInt(s.nextLine());
                System.out.print("\nCycles per Instruction: ");
                int b=Integer.parseInt(s.nextLine());
                System.out.print("\nSpeed of the clock in MHz: ");
                int c=Integer.parseInt(s.nextLine());
                cpuTimer= new CPUTimer(a,b,c);
                System.out.println("Result: "+cpuTimer.getSec()+" seconds");
                System.out.println("\nRe-run program? (Y/N)");
                System.out.println("\nTo re-run program type Y, to exit press any other key.");
                if(s.nextLine().toLowerCase().equals("y"))
                    main(args);
                else
                    System.exit(0);
            case 2:
                System.out.print("Enter Instruction Count: ");
                int a1=Integer.parseInt(s.nextLine());
                System.out.print("\nSeconds per Instruction: ");
                int b1=Integer.parseInt(s.nextLine());
                cpuTimer= new CPUTimer(a1,b1);
                System.out.println("Result: "+cpuTimer.getSec()+" seconds");
                System.out.println("\nTo re-run program type Y, to exit press any other key.");
                if(s.nextLine().toLowerCase().equals("y"))
                    main(args);
                else
                    System.exit(0);
            case 3:
                System.exit(0);
        }
    }

}
