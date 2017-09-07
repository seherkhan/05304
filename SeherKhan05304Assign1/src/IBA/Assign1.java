package IBA;

import java.util.Scanner;

/**
 * Created by Seher Khan on 9/7/2017.
 */
public class Assign1 {
    static Scanner s = new Scanner(System.in);

    //given a number n in the range [0,+inf), gives the sum 1+2+3+...+n
    public static void sum(){
        System.out.println("Enter integer in the interval [0,+inf): ");
        int n=Integer.parseInt(s.nextLine());
        int sum=n;
        for(int i=n-1;i>0;i--){
            sum+=i;
        }
        System.out.println("The sum is: "+sum);
    }

    //given a number n in the range [0,+inf), finds n!
    public static void factorial(){
        System.out.println("Enter integer in the interval [0,+inf): ");
        int n=Integer.parseInt(s.nextLine());
        int fact=n;
        for(int i=n-1;i>0;i--){
            fact*=i;
        }

        System.out.println("The factorial is: "+fact);
    }

    //given a number in the range (1,+inf), displays the 12*12 n-modulo multiplication table
    public static void moduloTable(){
        System.out.println("Enter integer in the interval (1,+inf): ");
        int n=Integer.parseInt(s.nextLine());
        int[][] modTab = new int[13][13];
        for(int j=0; j<13;j++){
            modTab[0][j]=j;
            modTab[j][0]=j+1;
            System.out.print(modTab[0][j]+" ");
        }
        System.out.print("\n");

        for(int i=1;i<13;i++){
            System.out.print(modTab[i-1][0]+" ");
            for(int j=1;j<13;j++){
                modTab[i][j]=(i*j)%n;
                System.out.print(modTab[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void timeToSlice(){
        int slicesPerSecond=3;
        double secondsPerLoaf=(double)1/slicesPerSecond;
        double slicesPerLoaf=6.5;
        int loavesInBatch=100;
        double time=loavesInBatch*slicesPerLoaf*secondsPerLoaf;
        System.out.println("Takes "+Math.floor(time)+" seconds");
    }


    public static void timeToRun(){
        System.out.println("Select a menu by typing the corresponding number: ");
        System.out.println("Option 1\nOption 2\nOption 3");
        String inputStr=s.nextLine();
            switch(Integer.parseInt(inputStr)){
                case(1):{
                    System.out.println("The time to run is "+FirstOption()+" seconds");
                    timeToRun();
                }
                case(2):{
                    System.out.println("The time to run is "+SecondOption()+" seconds");
                    timeToRun();
                }
                case(3):
                    timeToRun();

            }

        }

    private static double FirstOption(){
        System.out.println("Enter Instruction Count: ");
        int inCount=Integer.parseInt(s.nextLine());
        System.out.println("Enter Number of Cycles per Instruction: ");
        double cyPerIn=Double.valueOf(s.nextLine());
        System.out.println("Enter Clock Speed in MHz: ");
        double clockSpeed=Integer.parseInt(s.nextLine());

        double ticksPerSec=clockSpeed*1000000;
        double timePerTick=ticksPerSec/ticksPerSec;
        return inCount*cyPerIn*timePerTick;

    }
    private static double SecondOption(){
        System.out.println("Enter Instruction Count: ");
        int inCount=Integer.parseInt(s.nextLine());
        System.out.println("Enter Number of Cycles per Instruction: ");
        int cyPerIn=Integer.parseInt(s.nextLine());
        int clockSpeed=120;
        double ticksPerSec=clockSpeed*1000000;
        double timePerTick=ticksPerSec/ticksPerSec;
        return inCount*cyPerIn*timePerTick;
    }

    public static void DieRoll(){
        int[] countSums= new int[12];
        System.out.println("Enter number of rolls: ");
        int numRolls=Integer.parseInt(s.nextLine());
        for(int a=0;a<12;a++){
        for(int n=0;n<numRolls;n++) {
                countSums[a] += (int) Math.floor(Math.random() * 6) + 1;
            }
        }
        for (int i = 0; i < 12; i++)
            System.out.print(countSums[i]+" ");
            for(int i=0; i<countSums[i];i++) System.out.print("*");
            System.out.println();
    }

    public static void main(String[]args){

        //sum();
        //factorial();
        //moduloTable();
        //timeToSlice();
        //timeToRun();
        DieRoll();
    }



}
