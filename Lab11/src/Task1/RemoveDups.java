package Task1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Seher Khan on 11/21/2017.
 */
public class RemoveDups {
    public static void removeDuplicates(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader br = new BufferedReader(fileReader);
        FileWriter fileWriter;
        BufferedWriter bw;
        try {
            String[] strs = br.readLine().split(",");
            Set<Integer> noDups = new HashSet<>();
            for(String str : strs){
                noDups.add(Integer.parseInt(str));
            }
            fileWriter = new FileWriter(filename);
            bw = new BufferedWriter(fileWriter);
            for(Integer i : noDups){
                bw.write(i+",");
            }
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            br.close();
            fileReader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        removeDuplicates("resources/task1File");
    }

}
