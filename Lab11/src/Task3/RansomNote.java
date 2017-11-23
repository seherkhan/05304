package Task3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Seher Khan on 11/23/2017.
 */
public class RansomNote {
    private Map<Character,Image> alphabets;
    private Image[] ransomNote;
    public RansomNote() throws IOException {
        populateAlphabets();
    }
    public void populateAlphabets() throws IOException {
        alphabets= new HashMap<>();
        File folder = new File("resources/alphabets");
        File[] alphabetFiles = folder.listFiles();
        for(File imageFile: alphabetFiles) {
            Image image = ImageIO.read(imageFile);
            alphabets.put(imageFile.getName().charAt(0), image);
        }
    }

    public boolean canMakeRansom(String noteText){
        char[] noteTextChar = noteText.toUpperCase().toCharArray();
        ransomNote = new Image[noteTextChar.length];
        int i = 0;
        for(char c: noteText.toUpperCase().toCharArray()){
            if(c!=' '){
                if(alphabets.containsKey(c)){
                    ransomNote[i] = alphabets.get(c);
                }
                else
                    return false;
            }
            else
                ransomNote[i]=null;
            i++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canMakeRansom("fad be"));
        System.out.println(ransomNote.canMakeRansom("fad bze"));
    }
}
