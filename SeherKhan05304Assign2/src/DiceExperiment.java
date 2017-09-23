/**
 * Created by Seher Khan on 9/21/2017.
 * Creates an experiment which can roll a pair of dice a given number of times and stores the frequency of each total
 */
public class DiceExperiment {
    int numRolls;
    int[] total;

    /**
     * Constructor creates a DiceExperiment object with a given number of dice rolls and intializing the total int array with size 13.
     * @param numRolls
     */
    public DiceExperiment(int numRolls){
        this.numRolls=numRolls;
        total=new int[13]; //0th and 1st index will remain 0
    }
    /**
     * Performs the experiment by rolling dice numRolls times and then updating the frequencies of each sum in total array
     */
    public void perform(){
        Dice dice=new Dice();
        for(int i=0;i<numRolls;i++){
            dice.roll();
            total[dice.readResult()]+=1;
        }
    }
    /**
     * Gives the percentage of times a particular sum occurred during the experiment
     * @param i
     * @return percentage of i's occurrence
     */
    public double getPercent(int i){
        int sum=0;
        for(int j=2;j<total.length;j++){
            sum+=total[j];
        }
        return total[i]*100.0/sum;
    }
    /**
     * Getter method for the total array
     * @return array of frequencies of the sums
     */
    public int[] getTotalArr(){
        return total;
    }
    /**
     * Calculates and returns an array with relative frequencies of sums that occurred during the experiment
     * @return array of relative frequencies of the sums
     */
    public double[] getPercentArr(){
        double[] totalPercent=new double[13];
        for(int i=2;i<totalPercent.length;i++){
            totalPercent[i]=getPercent(i);
        }
        return totalPercent;
    }

}
