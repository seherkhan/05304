package Task1;

/**
 * Created by Seher Khan on 9/26/2017.
 */
public class UndergraduateStudent extends Student {
    /**
     * Constructor for creating a UndergraduateStudent object
     * @param name
     */
    public UndergraduateStudent(String name){
        super(name);
    }
    /**
     * Computes grade by setting grade as pass if score is >=60, else setting grade as fail
     * Preconditions:test score is always positive and less than equal to 100
     */
    @Override
    public void computeGrade() {
        if(getTestScore()>=70)
            setGrade("pass");
        else
            setGrade("fail");
    }
}

