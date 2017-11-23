package Task5;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Seher Khan on 11/23/2017.
 */
public class BracesParsing {
    private static Stack<Character> openBraces = new Stack<>();
    public static boolean parsable(String str){
        for(Character c : str.toCharArray()){
            if(c=='{'||c=='['||c=='('){
                openBraces.push(c);
            }
            else if(!openBraces.isEmpty()){
                if((openBraces.peek()=='{'&&c=='}') || (openBraces.peek()=='['&&c==']') || (openBraces.peek()=='('&&c==')'))
                    openBraces.pop();
            }
        }
        if(!openBraces.isEmpty())
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        System.out.println(parsable("2+4"));
        System.out.println(parsable("(2+4)"));
        System.out.println(parsable("2+4+{8}"));
        System.out.println(parsable("2+(4+{8}"));
    }
}
