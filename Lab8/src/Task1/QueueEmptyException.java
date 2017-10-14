package Task1;

/**
 * Exception to indicate queue is empty
 * @author 5304
 */
public class QueueEmptyException extends Exception{
    public QueueEmptyException(String message){
        super(message);
    }
}
