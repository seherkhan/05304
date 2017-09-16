/**
 * Created by Seher Khan on 9/14/2017.
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        //queue.q[0]=100; //ascii 100 represents char d
        //The above does not work because q is a private variable.
        //This can be addressed by:
        //- make q public (not recommended)
        // OR
        //- setting value at index 0 by using the put method

        //queue.put(100);
        //The above also doesn't work because the method .put expects a char while 100 is int
        //solve this by explicit casting
        queue.put((char) 100);

        System.out.println(queue);
    }
}

