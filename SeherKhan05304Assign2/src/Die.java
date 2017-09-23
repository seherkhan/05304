/**
 * Created by Seher Khan on 9/21/2017.
 * This program creates a Die object which has a face value
 */
public class Die {
    private int face;
    /**
     * Constructor initializes face to 0
     */
    public Die(){
        face=0; //indicates Die was not rolled
    }
    /**
     * Rolls the Die object and assigns a random value from 1 to 6 (inclusive) to its face
     */
    public void roll(){
        face=(int)(Math.random()*6)+1;
    }
    /**
     * Used to view face of the Die object
     * preconditions: Die object has been rolled at least once
     * @return int face of the Die object
     */
    public int readResult(){
        if(face==0)
            System.out.println("Die was not rolled!");
        return face;
    }

}
