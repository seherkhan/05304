import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Seher Khan on 9/6/2017.
 */
public class SlotMachineReflection {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        //In this I have created an instance of SlotMachine using keyword new and also through reflection for time comparision.
        //After creating SlotMachine instance I have timed the whole execution of all methods being invoked through reflection.

        //create an instance of SlotMachine using keyword new
        long startDir1;
        long endDir1;
        long timeDir1;
        startDir1=System.nanoTime();
        SlotMachine mySlotD = new SlotMachine();
        endDir1=System.nanoTime();
        timeDir1=endDir1-startDir1;
        System.out.println("*Time taken to create SlotMachine through keyword new is "+timeDir1+" ns.");

        //create an instance of SlotMachine using reflection
        long startRef1;
        long endRef1;
        long timeRef1;
        startRef1=System.nanoTime();
        Object mySlot=Class.forName("SlotMachine").newInstance();
        endRef1=System.nanoTime();
        timeRef1=endRef1-startRef1;
        System.out.println("*Time taken to create SlotMachine through reflection is "+timeRef1+" ns.");

        System.out.print("*Creating by ");
        if(timeDir1<timeRef1) System.out.print("keyword new ");
        else System.out.print("reflection ");
        System.out.println("takes less time.");

        long startRef;
        long endRef;
        long timeRef;

        startRef=System.nanoTime();
        int bet;

        //get fields using reflection
        Field creditF =Class.forName("SlotMachine").getField("credit");

        //call methods via reflection
        Method getBetm=Class.forName("SlotMachine").getMethod("getBet");
        Method pullLeverm=Class.forName("SlotMachine").getMethod("pullLever");
        Method computeWiningsm=Class.forName("SlotMachine").getMethod("computeWinnings", int.class);
        Method readSlotm=Class.forName("SlotMachine").getMethod("readSlot");


        System.out.println("Welcome to the Slot Machine!!!\nYou have "+ creditF.get(mySlot)+" credits.\n");
        //why dont i have to cast int above

        bet = (int)getBetm.invoke(mySlot);

        //play until bet<=0
        int timesRan=0;
        while(bet>0){

            //if bet is greater than current credit, set bet=current credit
            if(bet>(int)creditF.get(mySlot))
                bet=(int)creditF.get(mySlot);


            //pull lever
            pullLeverm.invoke(mySlot);

            //display slot
            System.out.println(readSlotm.invoke(mySlot));

            //compute winnings and update credit
            creditF.set(mySlot,(int)creditF.get(mySlot)+(int)computeWiningsm.invoke(mySlot,bet));

            System.out.println("Credit is now " + creditF.get(mySlot) + "\n");

            timesRan++;

            //ADDED: to keep loop from running when credit=0
            if((int)creditF.get(mySlot)==0){
                System.out.println("You are out of credit.");
                break;
            }

            //new bet
            bet = (int)getBetm.invoke(mySlot);

        }
        endRef=System.nanoTime();
        timeRef=endRef-startRef;

        System.out.println("Time taken for game to run "+timesRan+" times without reflection is "+timeRef+" ns");

    }
}

