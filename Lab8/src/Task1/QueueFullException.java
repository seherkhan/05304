package Task1;

/**
 * Exception to indicate queue is full
 * @author 5304
 */
public class QueueFullException extends Exception {
    public QueueFullException(String message){
        super(message);
    }
}
