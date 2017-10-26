package Task2;

import java.util.*;

/**
 * Provides methods to find min, max and sum of a list
 * Created by Seher Khan on 10/12/2017.
 */
public class MyCollection {
    /**
     * Finds max of given list without ordering the original list
     * @param lst
     * @param comparator
     * @param <T>
     * @return maximum element
     */
    public static <T> T max(List<T> lst, Comparator<T> comparator){
        if(lst.isEmpty())
            return null;
        List<T> templst = lst;
        Collections.sort(templst,comparator);
        return lst.get(lst.size()-1);
    }

    /**
     * Finds min of given list without ordering the original list
     * @param lst
     * @param comparator
     * @param <T>
     * @return minimum element
     */
    public static <T> T min(List<T> lst,Comparator<T> comparator){
        if(lst.isEmpty())
            return null;
        List<T> templst = lst;
        Collections.sort(templst,comparator);
        return lst.get(0);
    }

    /**
     * Method 1:
     * Finds the "sum" of the given list.
     * @param lst
     * @param <T>
     * @return sum (e.g. concatenation in case of String, addition in case of Integer)
     */
    public static <T> T sum(List<T> lst, Summer<T> summer){
        if(lst.isEmpty())
            return null;
        else{
            return (T) summer.sum(lst);
        }
    }

    /**
     * Method 2:
     * Finds the "sum" of the given list.
     * @param lst
     * @param <T>
     * @return sum (e.g. concatenation in case of String, addition in case of Integer)
     */
    public static <T> T sum(List<T> lst){
        if(lst.isEmpty())
            return null;
        if(lst.get(0) instanceof String) {
            String sum = "";
            for(int i=0;i<lst.size();i++)
                sum+=(String)lst.get(i);
            return (T) sum;
        }
        else if(lst.get(0) instanceof Integer) {
            Integer sum = 0;
            for(int i=0;i<lst.size();i++)
                sum+=(Integer)lst.get(i);
            return (T) sum;
        }
        else if(lst.get(0) instanceof Double){
            Double sum = 0.0;
            for(int i=0;i<lst.size();i++)
                sum+=(Double)lst.get(i);
            return (T) sum;
        }
        //Can add for other types
        return null;
    }
}
