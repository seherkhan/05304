/**
 * Created by Seher Khan 05304 on 9/16/2017 as a part of Assignment 2, Question 1.
 * This class is used to create objects that consist of two integers which denote the first and last terms of the summation series, respectively.
 */
public class Summation {
    private int i;
    private int j;

    /**
     * This constructor creates a Summation object by taking two int arguments
     * @param i is the first term of the summation series
     * @param j is the last term of the summation series
     * Pre-conditions: i and j are integer numbers
     * Post-conditions: an object of type Summation exists in memory
     */
    public Summation(int i, int j){
        this.i=i;
        this.j=j;
    }
    /**
     * This method computes and returns the summation of the series represented by this Summation object.
     * Pre-conditions: the calling object is type Summation and is not null.
     * Post-conditions: an integer representing sum of the series represented by the calling object is produced.
     * @return summation of the series
     */
    public int total(){
        int sum=0;
        for(int x=i;x<=j;x++){
            sum+=x;
        }
        return sum;
    }
}
