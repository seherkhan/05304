package Task1;

/**
 * Creates Queue
 * @author 5304
 */
public class Queue<T> {
    private T[] q;
    private int putLoc;
    private int getLoc;

    /**
     * Constructor creates queue of given size
     * @param size
     */
    public Queue(int size){
        q=(T[])new Object[size];
        putLoc=0;
        getLoc=-1;
    }

    /**
     * Constructor creates queue with a given queue
     * @param o
     */
    public Queue(Queue<T> o){
        q=(T[])new Object[o.q.length];
        for(int i=0;i<o.q.length;i++)
            q[i]=o.q[i];
        putLoc=o.q.length;
        getLoc=o.q.length-1;
    }

    /**
     * Constructor creates queue with a given array
     * @param arr
     */
    public Queue(T[] arr){
        q=(T[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            q[i]=arr[i];
        putLoc=arr.length;
        getLoc=arr.length-1;
    }

    /**
     * @return last element
     * @throws QueueEmptyException
     */
    public T getLast() throws QueueEmptyException{
        if(getLoc==-1){
            throw new QueueEmptyException("Task1.Queue is empty.");
        }
        else
            return q[getLoc];
    }

    /**
     * Adds element to the back of the queue
     * @param ch
     * @throws QueueFullException
     */
    public void put(T ch) throws QueueFullException{
        if(putLoc<q.length) {
            q[putLoc] = ch;
            getLoc++;
            putLoc++;
        }
        else
            throw new QueueFullException("Task1.Queue is full.");
    }

    /**
     * @return String representation
     */
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