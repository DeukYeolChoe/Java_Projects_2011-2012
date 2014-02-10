package CircularDLinkedList;

/*
 * CircularDriver.java
 */

import java.util.*;


/**
 * Test Driver for the CircularDoublyLinkedList Class
 * @author DeukYeol Choe
 * @version 1.0
 * Test Environment: JDK 1.7.0_03 on Windows 7, i3 CPU<br />
 * @author pbladek
 */
public class CircularDriver {
    
     /**
     * main program
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            int index = CircularDoublyLinkedList.ITEM_NOT_FOUND;
            CircularDoublyLinkedList<String> aList =  new CircularDoublyLinkedList<String>();
            CircularDoublyLinkedList<String> cList =  new CircularDoublyLinkedList<String>();
            boolean success = false;
            
            // Testing add method
            System.out.println("<<<Testing Add(Index, Element)>>>");
            aList.add("This");
            System.out.println(aList);          
            aList.add(1, "is");
            System.out.println(aList);
            aList.add(2, "a");
            System.out.println(aList);
            aList.add(3, "Test");           
            System.out.println(aList);
            aList.add(-1, "!!"); 
            System.out.println("Should be: ->This->is->a->Test->!!");
            System.out.println(aList);
            
            // Testing addAll method
            System.out.println("\n<<<Testing addAll(Index, Collection)>>>");
            cList.add("AAAA");  
            cList.add("BBBB");
            cList.add("CCCC");
            success = aList.addAll(2, cList);
            cList.clear();
            System.out.println("Should be: ->This->is->AAAA->BBBB->CCC->a->Test->!!");
            System.out.println(aList);
            if(success == true)
                System.out.println("AddAll method works successfully");
            else
                System.out.println("AddAll method does not work successfully");
            
            // Testing listIterator
            int i = aList.size();
            ListIterator itr = aList.listIterator();
            System.out.println("\nChecking lists from the very first node to the very last node");
            for(int n = 0; n < i; n++)
            {
                System.out.println("(" + itr.next() + ") " );
            }
            System.out.println("\nChecking lists from the very last node to the very first node");
            for(int n = 0; n < i; n++)
            {
                System.out.println("(" + itr.previous() + ") " );
            }
            
            // Testing set method
            System.out.println("\n<<<Testing Set(Index, Element)>>>");
            aList.set(2, "not");
            System.out.println("Should be: ->This->is->not->BBBB->CCCC->a->Test->!!");
            System.out.println(aList);
            
            // Testing get method
            System.out.println("\n<<<Testing Get(Index)>>>");
            System.out.println("Should be: not");
            System.out.println("Showing the element of index 10: " + aList.get(10));   //  This index is overnumber but it works because it is a circular listed list
            
            // Testing remove method
            System.out.println("\n<<<Testing Remove(Object)>>>");
            aList.remove("!!");
            System.out.println("Should be: ->This->is->AAAA->BBBB->CCC->a->Test");
            System.out.println(aList);
            
            // Testing removeAll method
            System.out.println("\n<<<Testing RemoveAll(Collection<?> c)>>>");
            cList.add("BBBB");
            cList.add("CCCC");
            success = aList.removeAll(cList);
            cList.clear();
            if(success == true)
                System.out.println("RemoveAll method works successfully");
            else
                System.out.println("RemoveAll method does not work successfully");
            System.out.println("Should be: ->This->is->not->a->Test");
            System.out.println(aList);
            
            // Testing subList method
            System.out.println("\nTesting subList(1,2)");
            System.out.println("Should be: [is, not]");
            System.out.println(aList.subList(1, 2));
            
            // Testing containsAll method
            System.out.println("\n<<<Testing containsAll(Collection<?> c)>>>");
            cList.add("is");
            cList.add("not");
            success = aList.containsAll(cList);
            cList.clear();
            if(success == true)
                System.out.println("ContainsAll method works successfully");
            else
                System.out.println("ContainsAll method does not work successfully");
            
            // Testing equals method
            System.out.println("\n<<<Testing Equals(Object)>>>");
            System.out.println(aList);
            System.out.println("Checking the list with: This is not a Test");
            cList.add(0, "This");
            cList.add(1, "is");
            cList.add(2, "not");
            cList.add(3, "a");
            cList.add(4, "Test");
            success = aList.equals(cList);
            cList.clear();
            if(success == true)
                System.out.println("Equals method works successfully");
            else
                System.out.println("Equals method does not work successfully");  
            
            // Testing clone method
            System.out.println("\n<<<Testing clone()>>>");
            System.out.println("Should be: ->This->is->not->a->Test");        
            System.out.println(aList.clone());
            
            // Testing indexOf method
            System.out.println("\n<<<Testing indexOf()>>>");
            System.out.println("Should be: 2");
            System.out.println("The index of not in aList: " + aList.indexOf("not"));
            
            // Testing lastIndexOf method
            System.out.println("\n<<<Testing lastIndexOf()>>>");
            cList.add("not");
            cList.add("is");
            cList.add("not");
            cList.add("?");
            System.out.println(cList);
            System.out.println("Should be: 2");
            System.out.println("The index of Test in aList: " + cList.lastIndexOf("not"));
            cList.clear();
            
            // Testing retainAll method
            System.out.println("\n<<<Testing retainAll()>>>");
            cList.add("This");
            cList.add("is");
            aList.retainAll(cList);
            cList.clear();
            System.out.println("Should be: This is");
            System.out.println(aList);
            
            // Testing size method
            System.out.println("\n<<<Testing size()>>>");
            System.out.println("Should be: 2");
            System.out.println("aList's size is: " + aList.size());
            
            // Testing toArray method
            System.out.println("\n<<<Testing toArray()>>>");
            System.out.println("Should be: This is");
            Object[] array = aList.toArray();
            for(int n = 0; n < array.length; n++)
            {
                System.out.println(array[n] + " ");
            }
            
            // Testing clear method
            System.out.println("\n<<<Testing clear()>>>");
            aList.clear();
            System.out.println("aList: " + aList);
            
            // Testing isEmpty method
            System.out.println("\n<<<Testing isEmpty()>>>");
            success = aList.isEmpty();
            if(success == true)
                System.out.println("This is Empty");
            else
                System.out.println("This is not Empty"); 

        }   // try
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }   // catch
     }
}
