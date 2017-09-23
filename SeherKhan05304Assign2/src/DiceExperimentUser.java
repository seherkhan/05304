import java.util.Scanner;

/**
 * Created by Seher Khan on 9/21/2017.
 * This program allows a user to carry out a dice experiment by creating a DiceExperiment object after prompting the user to input the desired number of rolls.
 * After the experiment is performed the program display bar charts depicting the absolute and relative frequencies of each sum that occurred.
 */
public class DiceExperimentUser {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of rolls: ");
        int n=Integer.parseInt(s.next());
        DiceExperiment diceExp = new DiceExperiment(n);
        diceExp.perform();

        System.out.println("FREQUENCY OF TOTALS\nEach * represents an occurrence");
        for(int i=2; i<13;i++){
            System.out.print(i+": ");
            if(i<=9)
                System.out.print(" ");
            for(int j=0;j<diceExp.getTotalArr()[i];j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.println("\nRELATIVE FREQUENCY OF TOTALS\nEach * represents a 1% occurrence");
        for(int i=2; i<13;i++){
            System.out.print(i+": ");
            if(i<=9)
                System.out.print(" ");
            for(int j=0;j<diceExp.getPercentArr()[i];j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
