public class InvalidTimeException extends Exception
{
    public InvalidTimeException()
    {
        super("This time slot entered is invalid. Please try another.");
    }

    public InvalidTimeException(String message)
    {
        super(message);
    }
}
