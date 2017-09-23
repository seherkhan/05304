/**
 * Created by Seher Khan on 9/21/2017.
 * Creates a pair of Dice
 */
public class Dice {
    int total;
    int value1;
    int value2;
    /**
     * Constructor initializes total sum of dice to 0
     */
    public Dice(){
        total=0;
    }
    /**
     * Rolls both dice and stores the sum of their faces in total
     */
    public void roll(){
        Die die1=new Die();
        die1.roll();
        value1=die1.readResult();

        Die die2= new Die();
        die2.roll();
        value2=die2.readResult();

        total=value1+value2;
    }
    /**
     * Gets the value of total
     * @return total
     */
    public int readResult(){
        return total;
    }

    /**
     * @return true if dice rolled and have equal face values
     */
    public boolean pair(){
        if(value1!=0&&value1==value2){
            return true;
        }
        else
            return false;
    }
    /**
     * @return true if dice rolled and both have face value 1
     */
    public boolean duces(){
        if(value1==1&&value1==value2){
            return true;
        }
        else
            return false;
    }
    /**
     * @return true if dice rolled and the sum of their face values is 7
     */
    public boolean sevens(){
        if(total==7){
            return true;
        }
        else
            return false;
    }
}
