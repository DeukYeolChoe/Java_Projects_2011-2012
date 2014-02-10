package stack;

public class StackDriver
{
    public static void main( String[] args )
    {
        Stack s = new Stack( 3 );

        // test peeking into an empty stack
        try
        {
            System.out.println("Trying to peek into an empty stack");
            s.peek();
        }
        catch( EmptyStackException x )
        {
            System.out.println( x );
        }

        // test popping an empty stack
        try
        {
            System.out.println("Trying to pop an empty stack");
            s.pop();
        }
        catch( EmptyStackException x )
        {
            System.out.println( x );
        }

        try
        {
            s.push( 20 );
            System.out.println( s.peek() );
            System.out.println( s.pop() );
            System.out.println( s.isEmpty() );
            s.push( 30 );
            s.push( 31 );
            s.push( 32 );
            System.out.println( "Is stack full? " + s.isFull() );
        }
        catch( StackException x )
        {
            System.out.println( x );
        }

        // test pushing a full stack
        try
        {
            System.out.println("Trying to push onto a full stack");
            s.push( 33 );
        }
        catch( FullStackException x )
        {
            System.out.println( x );
        }
    }
}