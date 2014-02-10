/*
 * HuffmanTree.java
 *
 * Created on May 21, 2007, 2:16 PM
 */

package makingalicesmall;
import java.util.*;
/**
 * binary tree for Huffman coding
 * @author pbladek
 */
public class HuffmanTree<T extends Comparable<? super T>>
        extends BinaryTree<HuffmanData<T>>
{
    private final T MARKER = null;
    SortedMap<T, String> codeMap;
    SortedMap<String, T> keyMap;
    private int leafCount = 0;    
    ArrayList<BinaryNode<HuffmanData<T>>> aList = 
            new ArrayList<BinaryNode<HuffmanData<T>>>();
    /**
     * Creates a new instance of HuffmanTree
     */
    public HuffmanTree() 
    {
        super();
    }
   
    /**
     * Creates a new instance of HuffmanTree
     * from an array of Huffman Data
     * @param dataArray n array of Huffman Data
     */
    public HuffmanTree(HuffmanData<T>[] dataArray) 
    {
        sortArray(dataArray);
        for(int i = 0; i < dataArray.length; i++)
        {
            aList.add(new BinaryNode<HuffmanData<T>>(dataArray[i]));
        }
        createHuffman();
        keyMap = new TreeMap<String, T>();
        codeMap = new TreeMap<T, String>();
        setMaps(getRootNode(), "");
        //to be removed
        System.out.println(keyMap.values());    
        System.out.println(codeMap.values()); 
    } 
    /** 
     * creates two new HuffmanTrees and adds them to the root of this tree
     * @param left 
     * @param rightt
     */
    private void add(BinaryNode<HuffmanData<T>> left,
            BinaryNode<HuffmanData<T>> right)
    {  
         HuffmanTree<T> leftTree = new HuffmanTree<T>();
         leftTree.setRootNode(left); 
         HuffmanTree<T> rightTree = new HuffmanTree<T>();
         rightTree.setRootNode(right);
         setTree(new HuffmanData<T>
                 (MARKER, left.getData().getOccurances()
                 + right.getData().getOccurances()), leftTree, rightTree);
    }
    
    /** 
     * adds 2 new elements to this tree<br>
     *  smaller on the left
     * @param element1
     * @param element2
     */
    private void firstAdd(HuffmanData<T> element1, HuffmanData<T> element2)
    {
         BinaryNode<HuffmanData<T>> left = new 
                 BinaryNode<HuffmanData<T>>(element1);
         BinaryNode<HuffmanData<T>> right = new 
                 BinaryNode<HuffmanData<T>>(element2);
         add(left,right);
    }
    /**
     * Creates the huffman tree using the huffman data array.
     * Takes first two elements in the arraylist, and adds them to the root.
     * The latest created root replaces the previous, but the reference of it 
     * is saved to the arraylist as a binary node.
     */
     private void createHuffman()
     {
         while(aList.size() > 1)
         {
             add(aList.get(0), aList.get(1));
             BinaryNode<HuffmanData<T>> temp = (BinaryNode<HuffmanData<T>>) getRootNode();
             aList.remove(0);
             aList.remove(0);
             addAt(temp);
             System.out.println("temp: " + temp.getData().getOccurances());
         }
         //to be removed
         System.out.println("Root " + ((BinaryNode<HuffmanData<T>>) getRootNode()).getData().getOccurances());
         System.out.println("aList.size(): " + aList.size());
         System.out.println(aList.get(0).getData().getData());
         System.out.println(aList.get(0).getData().getOccurances());
     }
     
     private void addAt(BinaryNode<HuffmanData<T>> temp)
     {
         for(int i = 0; i < aList.size(); i++)
         {
             if(temp.getData().getOccurances() <= aList.get(i).getData().getOccurances())
             {
                 aList.add(i,temp);
                 return;
             }  
         }
         aList.add(temp);
     }
     /** 
      * set up the 2 maps
      * @param node
      * @param codeString
      */
     private void setMaps(BinaryNodeInterface<HuffmanData<T>> node,
             String codeString)
     { 
         if(node.hasLeftChild())
         {
             setMaps(node.getLeftChild(),codeString + "0");     // Recursion.          
         }
         if(node.hasRightChild())
         {
              setMaps(node.getRightChild(),codeString + "1");
         }
         if(node.getData().getData() != null)  // getData twice?
         {
              keyMap.put(codeString, node.getData().getData()); // a character representation of the chars
              codeMap.put(node.getData().getData(), codeString); // a string representation of the binary digits 
         }
     }
     
     private void sortArray(HuffmanData<T>[] data)
     {
         HuffmanData smallest;
        for (int i = 0; i < data.length; i++){
            int smallestIndex = i;
            smallest = data[i];
            for (int j = i + 1; j < data.length; j++){
                if (data[j].compareTo(smallest) < 0){
                    smallestIndex = j;
                    smallest = data[j];
                }
            }
            
            if (i != smallestIndex){
                HuffmanData temp = data[i];
                data[i] = smallest;
                data[smallestIndex] = temp;
            }
        }
     }
     
    /*
     * accessor for codeMap
     * @ return codeMap
     */
    public SortedMap<T, String> getCodeMap()
    {
        return codeMap;
    }
    
    /*
     * accessor for keyMap
     * @ return keyMap
     */
    public SortedMap<String, T> getKeyMap()
    {
        return keyMap;
    }

}
