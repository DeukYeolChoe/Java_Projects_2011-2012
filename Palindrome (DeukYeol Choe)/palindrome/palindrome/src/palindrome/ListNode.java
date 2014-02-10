package palindrome;

class ListNode
{
    // package access data so class List can access it directly
    Object data;
    ListNode next;
    // Constructor: Create a ListNode that refers to Object o.
    ListNode( Object o )
    {
        this( o, null );
    }
    // Constructor: Create a ListNode that refers to Object o and
    // to the next ListNode in the List.
    ListNode( Object o, ListNode nextNode )
    {
        data = o; // this node refers to Object o
        next = nextNode; // set next to refer to next
    }
    // Return a reference to the Object in this node
    Object getObject()
    {
        return data;
    }
    // Return the next node
    ListNode getNext()
    {
        return next;
    }
}