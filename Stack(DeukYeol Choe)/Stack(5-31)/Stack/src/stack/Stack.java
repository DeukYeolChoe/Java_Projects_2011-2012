package stack;
class Stack
{
    protected int[] contents;
    private int elements;

    public Stack(int size)
    {
        contents = new int[size];
        elements = 0;
    }

    public boolean isFull()
    {
        if(elements == contents.length)
          return true;
        else
          return false;
    }

    public boolean isEmpty()
    {
        if(elements == 0)
            return true;
        else
            return false;
    }

    public int peek() throws EmptyStackException
    {
        if( isEmpty() )
        {
            throw new EmptyStackException();
        }
        return contents[elements-1];
    }

    public int pop() throws EmptyStackException
    {
        if( isEmpty() )
        {
            throw new EmptyStackException();
        }
        contents[elements-1] = 0;
        elements--;
        return contents[elements];
    }

    public void push(int newElement) throws FullStackException
    {
        if( isFull() )
        {
            throw new FullStackException();
        }
        contents[elements] = newElement;
        elements++;
    }
}