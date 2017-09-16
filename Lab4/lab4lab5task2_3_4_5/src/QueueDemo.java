/**
 * Created by Seher Khan on 9/14/2017.
 */
public class QueueDemo {
    public static void main(String[] args) {
        try {
            Queue q1 = new Queue(2);
            q1.put('1');
            q1.put('w');
            System.out.println("Queue 1: "+q1);

            //Task 2:
            Queue q2 = new Queue(q1); //using the constructor Queue(Queue q1) creates a copy of q1
            System.out.println("Queue 2: "+q2);

            char[] chArr = new char[5];
            chArr[0]='a';
            chArr[1]='*';
            chArr[2]=41;
            chArr[3]='+';
            chArr[4]='\u2601';
            Queue q3 = new Queue(chArr); //using the constructor Queue(char[] chArr) allows you to directly add an array to Queue instead of using put for each item
            System.out.println("Queue 3: "+q3);

            q3.put('f'); //size of q1 is 2 but a third item is being inserted in the queue
            System.out.println(q3.getLast()); //this line will not run because above line throws a QueueFullException exception

        }
        //Task 3:
        catch (QueueEmptyException e) {
            e.printStackTrace();
        }
        catch (QueueFullException e) {
            e.printStackTrace();
        }

    }
}
