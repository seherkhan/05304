/**
 * Created by Seher Khan on 9/21/2017.
 * Creates a CPUTimer object which contains information on how fast a program will run on a computer.
 */
public class CPUTimer {
    private int instructionCount;
    private int instructionsPerSecond;
    /**
     * Constructor creates an object by taking three inputs: instructionCount, cyclesPerInstruction, cyclesPerSecond
     * It stores the instructionCount in the object's variable directly and computes instructionsPerSecond from the two remaining parameters before also storing it
     * Pre-conditions: cyclesPerSecond must be in MHz
     * @param instructionCount
     * @param cyclesPerInstruction
     * @param cyclesPerSecond
     */
    public CPUTimer(int instructionCount, int cyclesPerInstruction, int cyclesPerSecond){
        this.instructionCount=instructionCount;
        this.instructionsPerSecond=cyclesPerSecond*1000000/cyclesPerInstruction;
    }
    /**
     * Constructor creates an object by taking two inputs: instructionCount and instructionsPerSecond
     * It stores the both parameters in the object's variables directly
     * @param instructionCount
     * @param instructionsPerSecond
     */
    public CPUTimer(int instructionCount, int instructionsPerSecond){
        this.instructionCount=instructionCount;
        this.instructionsPerSecond=instructionsPerSecond;
    }
    /**
     * getter method for the instruction count
     * @return instruction count
     */
    public int getIC(){
        return instructionCount;
    }
    /**
     * Calculates and returns the seconds per instruction
     * @return seconds per instruction
     */
    public double getSPI(){
        return (double) 1/instructionsPerSecond;
    }
    /**
     * Calculates and returns the seconds per program
     * @return seconds per program
     */
    double getSec(){
        return (double) instructionCount*getSPI();
    }

}
