import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Seher Khan on 9/6/2017.
 */
public class SlotMachine {

    //make timer to see how long each method is taking



    public static final int INITIAL_CREDITS=10;

    private int credit;
    private Dial[] dials =new Dial[3];

    public SlotMachine(){
        this.credit=INITIAL_CREDITS;
    }

    public int getBet() throws IOException{
        //Question: Why is System.console() returning null and how to work around this?

        //USING SCANNER
        Scanner c = new Scanner(System.in);
        /*
        //USING CONSOLE is giving NullPointerException
        Console c = System.console();

        if(c==null){
            System.err.println("No console.");
            System.exit(1);
        }
        */
        //prompt user
        System.out.println("Please enter a bet amount (or zero/a negative number to quit): ");
        //String stringBet = c.nextLine();
        String stringBet = c.nextLine();

        //read and save input
        int intBet= Integer.parseInt(stringBet);
        return intBet;
    }

    //spins all dials
    public void pullLever(){
        for(int i=0;i<3;i++){
            dials[i]=new Dial();
            dials[i].spin();
        }
    }

    //displays all dials
    public String readSlot(){
        String read="";
        for(int i=0;i<3;i++){
            read+=dials[i].getPicture();
        }
        return read;
    }

    public int computeWinnings(int bet){
        int d0 =dials[0].getValue();
        int d1 =dials[1].getValue();
        int d2 =dials[2].getValue();

        if(d0==d1&&d0==d2){
            return bet;
        }
        else if(d0!=d1&&d0!=d2&&d1!=d2){
            return -bet;
        }
        else
            return 0;

    }

    public static void main(String[] args) throws IOException
    {
        //create an instance of SlotMachine
        SlotMachine mySlot = new SlotMachine();

        int bet;

        System.out.println("Welcome to the Slot Machine!!!\nYou have "+mySlot.credit+" credits.\n");

        bet = mySlot.getBet();

        //play until bet<=0
        while(bet>0){
            //System.out.println("bet: "+bet+", credit: "+mySlot.credit); //for debugging

            //if bet is greater than current credit, set bet=current credit
            if(bet>mySlot.credit)
                bet=mySlot.credit;

            //System.out.println("bet: "+bet+", credit: "+mySlot.credit);//for debugging

            //pull lever
            mySlot.pullLever();

            //display slot
            System.out.println(mySlot.readSlot());

            //compute winnings and update credit
            mySlot.credit+=mySlot.computeWinnings(bet);

            System.out.println("Credit is now " + mySlot.credit + "\n");

            //ADDED: to keep loop from running when credit=0
            if(mySlot.credit==0){
                System.out.println("You are out of credit.");
                break;
            }

            //new bet
            bet = mySlot.getBet();
        }

    }
}
