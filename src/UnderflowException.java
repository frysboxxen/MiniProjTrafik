

@SuppressWarnings("serial")
public class UnderflowException extends RuntimeException
{
    /**
     * Constructs a EmptyStackException with no detail message.
     */
    public UnderflowException()
    {
    }
    
    /*
     * Constructs a EmptyStackException with a detail message.
     * @param msg the detail mesage pertaining to this exception.
     */
    public UnderflowException( String msg )
    {
        super( msg );
    }
}