package Veterinarians;

public class BadInputException extends RuntimeException
{
    public BadInputException()
        {
            super( "This is a BadInputException" );
        }
}