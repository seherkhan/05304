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

    public Queue(Queue o){
        q=new char[o.q.length];
        for(int i=0;i<o.q.length;i++)
            q[i]=o.q[i];
        putLoc=o.q.length;
        getLoc=o.q.length-1;
    }

    public Queue(char[] arr){
        q=new char[arr.length];
        for(int i=0;i<arr.length;i++)
            q[i]=arr[i];
        putLoc=arr.length;
        getLoc=arr.length-1;
    }

    public char getLast() throws QueueEmptyException{
        if(getLoc==-1){
            throw new QueueEmptyException("Queue is empty.");
        }
        else
            return q[getLoc];
    }

    public void put(char ch) throws QueueFullException{
        if(putLoc<q.length) {
            q[putLoc] = ch;
            getLoc++;
            putLoc++;
        }
        else
            throw new QueueFullException("Queue is full.");
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