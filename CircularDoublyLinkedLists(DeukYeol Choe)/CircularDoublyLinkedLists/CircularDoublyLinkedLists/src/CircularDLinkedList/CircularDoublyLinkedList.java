package CircularDLinkedList;

/*
 * CircularDoublyLinkedList.java
 */

import java.io.Serializable;
import java.util.*;

/**
 * A Circular-Doubly Linked List class
 * @author DeukYeol Choe
 * @version 1.0
 * Test Environment: JDK 1.7.0_03 on Windows 7, i3 CPU<br />
 * @param <E> the data type
 */
public class CircularDoublyLinkedList<E>  extends AbstractList<E>
    implements List<E>, Cloneable, Serializable
{
    public static final int ITEM_NOT_FOUND = -1;
    /**
     * Inner class Node
     * @param <E> the data type
     */
    protected class Node<E>
    {
        protected E element;
        protected Node<E> next;
        protected Node<E> previous;

        /**
         * constructor
         * @param element the data element
         */
        protected Node(E element)
        {
            this.element = element;
            next = null;
            previous = null;
        }

        /**
         * accessor for element
         * @return the element
         */
        protected E getElement()
        {
            return element;
        }
        
        /**
         * constructor
         * @param element the data element
         * @param previous reference to the previous Node 
         * @param next reference to the next Node
         */
        protected Node(E element, Node<E> previous, Node<E> next)
        {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        /**
         * Return the data as a string
         * @return the data as a string
         */
        @Override
        public String toString()
        {
            return "->" + element.toString();
        }
        
    } // the end of Node
   
    /**
     * Inner class CircularDoublyLinkedListIterator
     */
    protected class CircularDoublyLinkedListIterator<E> implements Iterator<E>
    {
        protected Node<E> node;
        protected int index = 0;
        protected int checkAddOrRemove = -1;    // This variable is to check whether or not 
                                                       // a user uses add mehtod or remove method
                                                       // This is necessary to correct index. 
        protected CircularDoublyLinkedListIterator()
        {
            node = (Node<E>)head;
        }

        /** 
        *  Returns the element this Iterator object was (before this call) 
        *  positioned at, and advances this Iterator object.
        *                    
        *  @return - the element this Iterator object was positioned at.
        *
        *  @throws NoSuchElementException if this Iterator object was
        *    not positioned at an element before this call.Or when index equals length, it occurs
        */                            
        @Override
        public E next()
        {
            if(0 == length)
                throw new NoSuchElementException();  
            try
            {           
                E element = node.element;
                node = node.next;
                index++;
                checkAddOrRemove = index;
                return element;    
            }
            catch(IndexOutOfBoundsException e)
            {
                throw new NoSuchElementException();
            }
        }
        
       /**
        *  Determines if this Iterator object is positioned at an element in this
        *  Collection.
        *  @return true - if this Iterator object is positioned at an element; 
        *    otherwise, false.                        
        */                   
        @Override
        public boolean hasNext() 
        {       
            return (index != size());
        }
        
        /**
        * Removes from the underlying collection the last element returned by this
        *   iterator (optional operation). This method can be called only once per
        *   call to next(). The behavior of an iterator is unspecified if the
        *   underlying collection is modified while the iteration is in progress in
        *   any way other than by calling this method.
        * 
        * @throws UnsupportedOperationException - if the remove operation is not
        *   supported by this iterator
        * @throws IllegalStateException - if next() had not been called before
        *   this call to remove(), or if there had been an intervening call 
        *   to remove() between the most recent call to next() and this call.                
        */
        @Override
        public void remove()
        { 
            if(checkAddOrRemove < 0 )
                throw new IllegalStateException();
            try
            {
                CircularDoublyLinkedList.this.remove(index-1);    // this remove method means that the remove(int index) in the CircularDoublyLinkedList
                                                                // , not in the CircularDoublyLinkedListIterator class.
                if(checkAddOrRemove < index)    // index and checkAddOrRemove should have same value.
                    index --;                   //  if not, that means liked list is removed or added, so need to corret index.
                
                checkAddOrRemove = -1;  // when using remove(), checkAddOrRemove becomes -1
            }
            catch(IndexOutOfBoundsException e)
            {
                throw new UnsupportedOperationException(); 
            }
            
        }
    }   // CircularDoublyLinkedListIterator
    
    /**
     * Inner class ListIteratorClass
     */
    public class ListIteratorClass extends CircularDoublyLinkedListIterator<E> implements ListIterator<E>
    {        
        /**
        * constructor
        */
        protected ListIteratorClass()
        {
            node = (Node<E>)head;
        }
        
        /**
        * constructor
        * @param index the data index
        */       
        protected ListIteratorClass(int index)
        {
            node = getNodeAt(index);
            this.index = correctIndex(index); // "this.index" means the index variable in the CircularDoublyLinkedListIterator
        }
        
       /**
        *  Determines if this ListIterator object is positioned at an element in this Collection
        *  @return true - if this ListIterator object is positioned at an element; 
        *    otherwise, false.                        
        */            
        public boolean hasPrevious()
        {
            return (length > 0);
        }
        
        /**
         * Returns the previous element in the list and moves the cursor position backwards. 
         *  This method may be called repeatedly to iterate through the list backwards, 
         *  or intermixed with calls to next() to go back and forth. (Note that alternating 
         *  calls to next and previous will return the same element repeatedly.)
         * 
         * @return the previous element in the list
         * @throws NoSuchElementException - if the iteration has no previous element
         */
        public E previous()
        {
            try
            {
                node = node.previous;
                E element = node.element;
                index--;
                return element;
            }
            catch(IndexOutOfBoundsException e)
            {
                throw new NoSuchElementException();
            }
        }
        
        /**
         * Returns the index of the element that would be returned by a subsequent call to next(). 
         *  (Returns list size if the list iterator is at the end of the list.)
         * 
         * @return the index of the element that would be returned by a subsequent call to next, 
         *  or list size if the list iterator is at the end of the list
         */
        public int nextIndex()
        {
            return index;   
        }  
        
        /**
         * Returns the index of the element that would be returned by a subsequent call to previous(). 
         *  (Returns -1 if the list iterator is at the beginning of the list.)
         * 
         * @return the index of the element that would be returned by a subsequent call to previous, 
         *  or -1 if the list iterator is at the beginning of the list
         */
        public int previousIndex()
        {
            return (index - 1);
        }
        
        /**
         * Replaces the last element returned by next() or previous() with the specified element 
         *  (optional operation). This call can be made only if neither remove() 
         *  nor add(E) have been called after the last call to next or previous.
         * 
         * @param e the element with which to replace the last element returned by next or previous
         * @throws IllegalStateException - if neither next nor previous have been called, 
         * or remove or add have been called after the last call to next or previous
         * @throws UnsupportedOperationException - if the set operation is not supported by this list iterator
         */
        public void set(E e)
        {
            if(checkAddOrRemove < 0)
                throw new IllegalStateException();
            try
            {
                CircularDoublyLinkedList.this.set(index-1, e);  // Calling set(int index, E element) 
                                                                // in the CircularDoublyLinkedList class
            }
            catch(IndexOutOfBoundsException event)
            {
                throw new UnsupportedOperationException();
            }
        }

        /**
         * Inserts the specified element into the list (optional operation). 
         *  The element is inserted immediately before the element that would be returned by next(), 
         *  if any, and after the element that would be returned by previous(), 
         *  if any. (If the list contains no elements, the new element becomes the sole element on the list.) 
         *  The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, 
         *  and a subsequent call to previous would return the new element. (This call increases by one the value 
         *  that would be returned by a call to nextIndex or previousIndex.)
         * 
         * @param e the element to insert
         * @throws IllegalArgumentException - if some aspect of this element prevents it from being added to this list
         */
        @Override
        public void add(E e) {
            try
            {                
                int temp = index;
                CircularDoublyLinkedList.this.add(e);
                checkAddOrRemove = -1;
                index = temp + 1;
            }
            catch(IndexOutOfBoundsException event)
            {
                throw new IllegalArgumentException();
            }
        }
    }   // ListIteratorClass    
    
    /**
     * default constructor -- creates an empty list
     */
    public CircularDoublyLinkedList()
    {
    }
 
    /**
     * Appends the specified element to the end of this list.
     * @param e element to be appended to this list
     * @return true (as specified by Collection.add(E))
     * @throws ClassCastException if the class of the specified element
     *   prevents it from being added to this list
     * @throws IllegalArgumentException if some property of this element
     *   prevents it from being added to this list   
     */
    @Override
    public boolean add(E e) throws ClassCastException, IllegalArgumentException
    {        
        if(head == null)
        {
            head = new Node<E>(e);
            head.next = head;
            head.previous = head;
            length++;
            return true;
        }        
        Node<E> tail = head.previous;               // This is possible because it is circular linked list.
        head.previous = new Node(e, tail, head);    // (data, previous, next), head.previous points to last node
        tail.next = head.previous;  
        length++;  
        return true;
    }
     
    /**
     * Inserts the specified element at the specified position in this list.
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException  if the add operation is not
     *   supported by this list
     * @throws ClassCastException if the class of the specified element
     *   prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *   list does not permit null element
     * @throws IllegalArgumentException if some property of this element
     *   prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index > size())
     */
    @Override
    public void add(int index, E element) throws UnsupportedOperationException,
        ClassCastException, NullPointerException, IllegalArgumentException,
        IndexOutOfBoundsException
    {
        int getIndex = correctIndex(index);

        if(head == null )
        {
            head = new Node<E>(element);
            head.next = head;
            head.previous = head;
        }
        else
        {
            Node<E> nodeAtPrevious = getNodeAt(getIndex - 1);
            Node<E> nodeAtNext = nodeAtPrevious.next;

            nodeAtPrevious.next =  new Node<E>(element, nodeAtPrevious, nodeAtNext);   // Appends a new node at a spcified index.
            nodeAtNext.previous = nodeAtPrevious.next;
        }
        length++;
    }

    /**
     * Appends all of the elements in the specified collection to the end
     * of this list, in the order they are returned by the specified
     * collection's iterator (optional operation)
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws UnsupportedOperationException if the addAll operation is not
     *   supported by this list
     * @throws ClassCastException if the class of an element of the specified
     *   collection prevents it from being added to this list
     * @throws NullPointerException if the specified collection contains one or
     *   more null elements and this list does not permit null elements, or if
     *   the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     *   specified collection prevents it from being added to this list
     */
    @Override
    public boolean addAll(Collection<? extends E> c)
            throws UnsupportedOperationException,
            ClassCastException, NullPointerException, IllegalArgumentException
    {
        if(length < 0)
           throw new UnsupportedOperationException();
        int count = 0;
        for(E element : c)
        {
            add(element);
            count++;
        }
        
        return (count > 0);  
    }
    
     /**
     * Inserts all of the elements in the specified collection into this list
     * at the specified position (optional operation).
     * @param c collection containing elements to be added to this list
     * @param index index at which to insert the first element from the
     *   specified collection
     * @return true if this list changed as a result of the call
     * @throws UnsupportedOperationException if the addAll operation is not
     *   supported by this list
     * @throws ClassCastException if the class of an element of the specified
     *   collection prevents it from being added to this list
     * @throws NullPointerException if the specified collection contains one or
     *   more null elements and this list does not permit null elements, or if
     *   the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     *   specified collection prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index < 0 || index > size())
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c)
            throws UnsupportedOperationException,
            ClassCastException, NullPointerException, IllegalArgumentException,
            IndexOutOfBoundsException
    {
        Object[] o = c.toArray();
        int addedNumber = o.length;
        Node<E> preNode = getNodeAt(index-1); 
        Node<E> nextNode = preNode.next;
        
        if(addedNumber < 0)
           throw new UnsupportedOperationException(); 
        if(addedNumber == 0)
            return false;
   
        for(int i = 0; i < addedNumber; i++)
        {
            if(head == null)
            {
                head = new Node<E>((E)o[0]);
                head.previous = head;
                head.next = head;
                preNode = head;
                nextNode = head;
            }
            else
            {
                Node<E> node = new Node<E>((E)o[i], preNode, nextNode);
                preNode.next = node;
                preNode = node;
            }
        }
        nextNode.previous = preNode;    // After adding all collection elements, links the added last node with preNode.
        length += addedNumber;
        
        return true;             
    }

    /**
     * Removes all of the elements from this list.
     * @throws UnsupportedOperationException if the clear operation is not
     *   supported by this list
     */
    @Override
    public void clear() throws UnsupportedOperationException
    {
        ListIterator<E> itr = listIterator(0);
        for(int i = 0; i < length; i++)
        {
            itr.next();
            itr.remove();
        }
       head = null;
       length = 0;
    }
    
    /**
     * Returns a shallow copy of this LinkedList.
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        CircularDoublyLinkedList clone = new CircularDoublyLinkedList();
        clone.addAll(this);
        return clone;
    }
    
    /**
     * Returns true if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element.
     */
    @Override
    public boolean contains(Object o)
    {
        int size = 0;
        for(Node<E> current = head; size < length; current = current.next)
        {
            if(o == null)
            {
                if(current.element == null)
                    return true;
            }
            else
                if(current.element.equals(o))
                    return true;
            size++;
        }
        return false;
    }
    
    /**
     * Returns true if this list contains all of the elements
     * of the specified collection.
     * @param c collection containing elements whose presence in this list are
     *   to be tested
     * @return return true if this list contains all of the specified elements.
     * @throws ClassCastException if the types of one or more elements in the
     *   specified collection are incompatible with this list (optional)
     * @throws NullPointerException if the specified collection contains one or
     *   more null elements and this list does not permit null elements
     *   (optional), or if the specified collection is null
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {
        if(c == null)
            throw new NullPointerException();
        int max = c.size();
        Object array[] = c.toArray();
        
        for(int i = 0; i < max; i++)
        {
            if(!contains(array[i]))
                return false;
        }
        return true;
    }
    
    /**
     * Compares the specified object with this list for equality.
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o)
    {
        ListIterator<E> listItr = listIterator();
        ListIterator listItrCompared = ((List)o).listIterator();
        int size = 0;
        
        while(listItr.hasNext() && listItrCompared.hasNext())
        {
            E element = listItr.next();
            Object obElement = listItrCompared.next();
            if(element.equals(null) || obElement.equals(null))
                return false;   // There is nothing to compare each element
                
            if(element.equals(obElement))
                size++ ;
        }
        if(size == size())
            return true;
        
        return false;
    }
  
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index < 0 || index >= size())
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException
    {
         int getIndex = correctIndex(index);
         Node<E> node = getNodeAt(getIndex);
         return node.getElement();     
    }
 
    /**
     * Returns the hash code value for this list.
     * @return the hash code value for this list
     */
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + this.length;
        return hash;  
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * n this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *   this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element is
     *   incompatible with this list (optional)
     * @throws NullPointerException if the specified element is null and this
     *   list does not permit null elements (optional)
     */
    @Override
    public int indexOf(Object o)throws ClassCastException, NullPointerException
    {
        int count = 0;
        if(o == null)
        {
            for(Node<E> current = head; current != null; current = current.next)
            {
                if(current.getElement() == null)
                    return count;
                count++;
            }   
        }else
        {
            E searchElement = (E)o;
            for(Node<E> current = head; current != null; current = current.next)
            {
                if(searchElement.equals(current.getElement()))
                    return count;
                count++;
            }
        }
        return ITEM_NOT_FOUND;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty()
    {
        if(length == 0)
            return true;
        return false;
    }
    
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator()
    {
         return new CircularDoublyLinkedListIterator<E>();    
    }
    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *   this list, or -1 if this list does not contain the element
     * @throws ClassCastException - if the type of the specified element is
     *   incompatible with this list (optional)
     * @throws NullPointerException - if the specified element is null and this
     *   list does not permit null elements (optional)
     */
    @Override
    public int lastIndexOf(Object o) throws ClassCastException,
        NullPointerException
    {  
        return lastIndexOf((E)o, head, 0);
    }

    /**
     * Returns the index of the last occurrence of the specified element --
     *   recursive
     * @param searchElement element to search for
     * @param node reference to current node
     * @param index the current index
     * @return the index of the last occurrence of the specified element in
     *   this list, or -1 if this list does not contain the element
     * @throws IndexOutOfBoundsException if (index < 0 || index >= length)
     */
    protected int lastIndexOf(E searchElement, Node<E> node, int index)
            throws IndexOutOfBoundsException
    { 
         int FoundIndex = ITEM_NOT_FOUND;
         if(node == null || searchElement == null)
            return FoundIndex;   
         
         for(node = head.previous; index < length; node = node.previous)
         {  
            if(node.element.equals(searchElement))
            {
                FoundIndex = length - index -1;
                return FoundIndex;
            }
                index++;
         }
         return FoundIndex;
    }

    /**
     * Returns a list iterator over the elements in this list
     *   (in proper sequence).
     * @return a list iterator over the elements in this list
     *   (in proper sequence)
     */
    @Override
    public ListIterator<E> listIterator()
    {
         return listIterator(0);    
    }
    
    /**
     * Returns a list-iterator of the elements in this list
     * (in proper sequence), starting at the specified position in the list.
     * @param index index of the first element to be returned from the list
     *   iterator (by a call to next)
     * @return a list iterator over the elements in this list
     *   (in proper sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index < 0 || index > size())
     */
    @Override
    public ListIterator<E> listIterator(int index)
            throws IndexOutOfBoundsException
    {
        return new ListIteratorClass(index);
    }

 
    /**
     * Removes the element at the specified position in this list.
     * @param index index of the first element to be returned from the list
     *   iterator (by a call to next)
     * @return a list iterator over the elements in this list
     *   (in proper sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index < 0 || index > size())
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException
    {
        int getIndex = correctIndex(index);
        if(getIndex == 0)
        {
            Node<E> node = head;
            head = head.next;
            return node.getElement();
        }
        Node<E> nodeBefore = getNodeAt(getIndex - 1);
        Node<E> node = nodeBefore.next;
        nodeBefore.next = node.next;
        nodeBefore = node.next.previous;
        length--;
        return node.getElement();      
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     * @throws ClassCastException - if the type of the specified element is
     *   incompatible with this list (optional)
     * @throws NullPointerException - if the specified element is null and this
     *   list does not permit null elements (optional)
     * @throws UnsupportedOperationException - if the remove operation is
     *   not supported by this list
     */
    @Override
    public boolean remove(Object o) throws ClassCastException,
        NullPointerException, UnsupportedOperationException
    {
        if(o.equals(null))
        {
            throw new UnsupportedOperationException();
        }
        else
        {
            int index = indexOf(o);
            remove(index);
        }
        return true;
    }

    /**
     * Removes from this list all of its elements that are contained
     * in the specified collection (optional operation).
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     * @throws UnsupportedOperationException if the removeAll operation is not
     *   supported by this list
     * @throws ClassCastException if the class of an element of this list is
     *   incompatible with the specified collection (optional) 
     * @throws NullPointerException if this list contains a null element and the
     *   specified collection does not permit null elements (optional), or if
     *   the specified collection is null
     */
    @Override
    public boolean removeAll(Collection<?> c)
            throws UnsupportedOperationException
    {
        Object[] o = c.toArray();
        int removedNumber = o.length;
        
        if(removedNumber < 0 )
            throw new UnsupportedOperationException();
        if(removedNumber == 0)
            return false;
        
        int index = 0;
        int i;      
        
        for(Node<E> node = head; index < length; node = node.next)
        {
                if(node.element.equals((E)o[0]))
                {
                     for(i = 0; i < removedNumber; i++)
                     {
                        remove(index);
                     }
                }
            index++ ;
        }  
        return true;
    }

    /**
     * Retains only the elements in this list that are contained
     * in the specified collection (optional operation).
     * @param c collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     * @throws UnsupportedOperationException if the retainAll operation is not
     *   supported by this list
     * @throws ClassCastException if the class of an element of this list is
     *   incompatible with the specified collection (optional)
     * @throws  NullPointerException if this list contains a null element and
     *   the specified collection does not permit null elements (optional),
     *   or if the specified collection is null
     */
    @Override
    public boolean retainAll(Collection<?> c)
            throws UnsupportedOperationException, ClassCastException,
            NullPointerException
    {
        Node<E> node = head;
        boolean result = false;
        if(c == null)
            throw new NullPointerException();
        if(head == null)
            return false;
        
        for(int n = 0; n < length; n++)
        {
            if(c.contains(node.element) == false)   // if "node.element" does not equal to c's elements
            {                                       // , then elements in the node should be removed.
                if(length <= 1)
                {
                    head = null;
                    return false;
                }
                else
                {
                    if(node == head)
                        head = node.next;   // if head is removed, the linked list does not work.
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                }
                result = true;
                length--;
                n--;    // n should be decreased because length is also decreased. If not, it would be out of range.
            }
            node = node.next;
        }
        return result;
    }
    
    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the set operation is not
     *   supported by this list
     * @throws ClassCastException if the class of the specified element prevents
     *   it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *   list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *   element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index < 0 || index >= size()) 
     */
    @Override
    public E set(int index, E element) throws UnsupportedOperationException,
        ClassCastException, NullPointerException, IllegalArgumentException,
        IndexOutOfBoundsException
    {
        if(element == null)
            throw new UnsupportedOperationException();
        int getIndex = correctIndex(index);
        
        Node<E> node = getNodeAt(getIndex);
        E oldElement = node.element;
        node.element = element;
        return oldElement;  // Showing what value is changed.
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size()
    {
       return length;       
    }

    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *   (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex)
            throws IndexOutOfBoundsException
    {
        List<E> list = new LinkedList<E>();
        if(fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        int from = 0;
        int to = 0;
        from = correctIndex(fromIndex);
        to = correctIndex(toIndex);
        
        Node<E> node;
        int size = to - from + 1;
        for(int n = 0 ; n < size;  n++)
        {
            node = getNodeAt(from + n);
            list.add(node.element);    
        }                   
        return list;
    }
    
    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     * @return an array containing all of the elements in this list
     *   in proper sequence
     */
    @Override
    public Object[] toArray()
    {
        Object[] array = new Object[length];
        Node<E> node = head;
        for(int i = 0; i < length; i++)
        {
            array[i] = node.element;
            node = node.next;
        }  
        return array;     
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     * @param a the array into which the elements of this list are to be stored,
     *   if it is big enough; otherwise, a new array of the same runtime type is
     *   allocated for this purpose.
     * @return an array containing the elements of this list
     */
    @Override
    public <T> T[] toArray(T[] a)
    {
        if(a.length > length)
            throw new IndexOutOfBoundsException();
        T[] b = a;
        Node<E> node = head;
        for(int i = 0; i < length; i++)
        {
            b[i] = (T)node.element;
            node = node.next;
        }
        return b;  
    }
    
    /**
    * Return the data as a string
    * @return the data as a string
    */
    @Override
    public String toString()
    {
        String string = "";
        int n = 0;
        for(Node<E> current = head; n < length; current = current.next)
        {
            string += current.toString();
            n++;
        }
        return string;
    }
       
    /**
     * Returns a reference to the last Node
     * @return a reference to the last Node
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *   (fromIndex < 0 || toIndex > size)
     */
    protected Node<E> getNodeAt(int index) throws IndexOutOfBoundsException
    {       
        int getIndex = correctIndex(index);        
        Node<E> node = head;
        
        if(index <= (length / 2))
        {
            for(int i = 0; i < index; i++)
                node = node.next; 
        }
        else
        {
            for(int i = length; i > index; i--)
                node = node.previous;
        }
        return node;
    }
    
    protected int correctIndex(int index)
    {
        if(index == 0)
            return 0;
        if(index > size())
            index = index - size();
        if(index < 0)
            index = size() + index + 1;
        return index;
    }
    
    protected int length = 0;
    protected Node<E> head;
}
