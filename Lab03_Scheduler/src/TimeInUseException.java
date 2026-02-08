public class TimeInUseException extends Exception
{
    public TimeInUseException()
    {
        super("This time slot has already been filled. Please try another.");
    }

    public TimeInUseException(String message)
    {
        super(message);
    }
}
