/**
 * Created by Seher Khan on 9/14/2017.
 */
public class Queue {
    private char[] q;
    private int putLoc;
    private int getLoc;

    public Queue(int size){
        q=new char[size];
        putLoc=0;
        getLoc=-1;
    }

    public Character getLast(){
        if(getLoc==-1){
            System.out.println("Queue is empty.");
            return null;
        }
        return q[getLoc];
    }

    public boolean put(char ch){
        if(putLoc<q.length) {
            q[putLoc] = ch;
            getLoc++;
            putLoc++;
            return true;
        }
        System.out.println("Overflow! Char not added");
        return false;
    }
    public String toString(){
        String str="";
        if(getLoc==-1)
            return str;
        for(int i=0;i<=getLoc;i++){
            str+=q[i]+" ";
        }
        return str;
    }
}
