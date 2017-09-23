/**
 * Created by Seher Khan 05304 on 9/16/2017 as a part of Assignment 2, Question 2.
 * This class is used to create objects that consist of two integers which denote the first and last terms of the multiplication series.
 */
public class Multiplication {
    private int i;
    private int j;

    /**
     * This constructor creates a Multiplication object by taking two int arguments
     * @param i is the first term of the multiplication series
     * @param j is the last term of the multiplication series
     * Pre-conditions: i and j are integer numbers
     * Post-conditions: an object of type Multiplication exists in memory
     */
    public Multiplication(int i, int j){
        this.i=i;
        this.j=j;
    }
    /**
     * This method computes and returns the product of the series represented by this Multiplication object.
     * Pre-conditions: the calling object is type Multiplication and is not null.
     * Post-conditions: an integer representing product of the series represented by the calling object is produced.
     * @return product of the series
     */
    public int product(){
        int sum=1;
        for(int x=i;x<=j;x++){
            sum*=x;
        }
        return sum;
    }
}
