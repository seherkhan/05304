package Task2;

import java.util.List;

/**
 * Created by Seher Khan on 10/24/2017.
 */
public class StringSummer implements Summer<String> {
    @Override
    public String sum(List<String> lst) {
        String sum="";
        for(String i : lst)
            sum+=i;
        return sum;
    }
}
