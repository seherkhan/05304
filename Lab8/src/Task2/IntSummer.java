package Task2;

import java.util.List;

/**
 * Created by Seher Khan on 10/24/2017.
 */
public class IntSummer implements Summer<Integer> {

    @Override
    public Integer sum(List<Integer> lst) {
        Integer sum=0;
        for(Integer i : lst)
            sum+=i;
        return sum;
    }
}
