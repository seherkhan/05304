package Task2;

import java.util.List;

/**
 * Created by Seher Khan on 10/24/2017.
 */
public class DoubleSummer implements Summer<Double> {

    @Override
    public Double sum(List<Double> lst) {
        Double sum=0.0;
        for(Double i : lst)
            sum+=i;
        return sum;
    }
}