package Task2;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Seher Khan on 11/23/2017.
 */
public class GetNegs {
    public static LinkedList<Integer> findNegatives(String filename) throws IOException {
        LinkedList<Integer> negs = new LinkedList<>();
        FileReader fileReader = new FileReader(filename);
        BufferedReader br = new BufferedReader(fileReader);
        try {
            String[] strs = br.readLine().split(",");
            for(String str : strs){
                int i=Integer.parseInt(str);
                if(i<0)
                    negs.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            br.close();
            fileReader.close();
        }
        System.out.println(negs);
        return negs;
    }

    public static void main(String[] args) throws IOException {
        findNegatives("resources/task2File");
    }
}
