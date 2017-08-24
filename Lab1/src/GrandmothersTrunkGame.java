import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Seher Khan on 8/24/2017.
 */
public class GrandmothersTrunkGame {
    public static void main(String[] args) throws IOException {
        String str="In my Grandmother's trunk, I packed";
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        String move;


        for(int i=1;i<5;i++){
            System.out.print("Player "+i+", what did you pack? ");
            move = in.readLine();
            str+=", "+move;
        }
        System.out.print("Player 5, what did you pack? ");
        move = in.readLine();
        str+=" and "+move;
        str+=".";

        System.out.println("Result: "+str);
        System.out.println("End of game.");
    }
}
