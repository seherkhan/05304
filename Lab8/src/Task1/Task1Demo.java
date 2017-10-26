package Task1;

/**
 *
 * @author 5304
 */
public class Task1Demo {
    public static void main(String[] args) {
        try {
            Queue<Integer> q1 = new Queue<Integer>(2);
            q1.put(1);
            q1.put(4);
            System.out.println("Queue 1: "+q1);

            Queue q2 = new Queue(q1); //using the constructor Queue(Queue q1) creates a copy of q1
            System.out.println("Queue 2: "+q2);

            Character[] chArr = new Character[5];
            chArr[0]='a';
            chArr[1]='*';
            chArr[2]=41;
            chArr[3]='+';
            chArr[4]='\u2601';
            Queue<Character> q3 = new Queue<Character>(chArr); //using the constructor Queue(char[] chArr) allows you to directly add an array to Queue instead of using put for each item
            System.out.println("Queue 3: "+q3);

            q3.put('f'); //size of q1 is 2 but a third item is being inserted in the queue
            System.out.println(q3.getLast()); //this line will not run because above line throws a QueueFullException exception

        }

        catch (QueueEmptyException e) {
            e.printStackTrace();
        }
        catch (QueueFullException e) {
            e.printStackTrace();
        }

    }
}
