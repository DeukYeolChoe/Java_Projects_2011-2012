/*
 * BinaryNode.java
 *
 * Created on May 21, 2007, 1:08 PM
 */

package makingalicesmall;
import java.io.Serializable;
/**
 *
 * @author Carrano
 */
public class  BinaryNode < T > implements BinaryNodeInterface < T >, 
        Serializable
{
    private T data;
    private BinaryNode < T > left;
    private BinaryNode < T > right;
    
    /**
     * default constructor
     */
    public BinaryNode ()
    {
        this (null);  // call next constructor
    } // end default constructor

 
    /**
     * constructor
     * @param dataPortion the data portion
     */
    public BinaryNode (T dataPortion)
    {
        this (dataPortion, null, null); // call next constructor
    } // end constructor

    /**
     * constructor
     * @param leftChild The left child
     * @param rightChild The Right child
     */
    public BinaryNode (T dataPortion, BinaryNode < T > leftChild, 
            BinaryNode <T> rightChild)
    {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    } // end constructor

    /**
     * Accessors for the data
     * @return data
     */
    @Override
    public T getData ()
    {
        return data;
    } // end getData

    /**
     * Set a new data
     * @param newData new element or data
     */
    @Override
    public void setData (T newData)
    {
        data = newData;
    } // end setData

    /**
     * Accessors for a left child
     * @return A left child
     */
    @Override
    public BinaryNodeInterface < T > getLeftChild ()
    {
        return left;
    } // end getLeftChild

    /**
     * Set a left child
     * @param leftChild Element to be the left child 
     */
    @Override
    public void setLeftChild (BinaryNodeInterface < T > leftChild)
    {
        left = (BinaryNode < T > ) leftChild;
    } // end setLeftChild

    /**
     * Checking if a left child exist
     * @return True if a left child existed; otherwise, return False
     */
    @Override
    public boolean hasLeftChild ()
    {
        return left != null;
    } // end hasLeftChild

    /**
     * Checking a node if it is leaf
     * @return True if the node is a leaf; otherwise, return false
     */
    @Override
    public boolean isLeaf ()
    {
        return (left == null) && (right == null);
    } // end isLeaf

    /**
     * Accessors for right child
     * @return The right child
     */
    @Override
    public BinaryNodeInterface < T > getRightChild ()
    {
        return right;
    } // end getRightChild

    /**
     * Set a right child
     * @param rightChild Element to be the right child 
     */
    @Override
    public void setRightChild (BinaryNodeInterface < T > rightChild)
    {
        right = (BinaryNode < T > ) rightChild;
    } // end setRightChild

    /**
     * Checking if a right child exist
     * @return True if a right child existed; otherwise, return False
     */
    @Override
    public boolean hasRightChild ()
    {
        return right != null;
    } // end hasRightChild

    /**
     * Implementations of getRightChild, setRightChild, and hasRightChild are 
     * analogous to their left-child counterparts.
     * @return 
     */
    @Override
    public BinaryNodeInterface < T > copy ()
    {
        BinaryNode < T > newRoot = new BinaryNode <> (data);
        if (left != null)
            newRoot.left = (BinaryNode < T > ) left.copy ();
        if (right != null)
            newRoot.right = (BinaryNode < T > ) right.copy ();
        return newRoot;
    } // end copy


    /**
     * Get the height of the tree
     * @return the height of the tree
     */
    @Override
    public int getHeight ()
    {
        return getHeight (this); // call private getHeight
    } // end getHeight

    /**
     * Get the height of the tree beginning from a specific node
     * @param node
     * @return 
     */
    private int getHeight (BinaryNode < T > node)
    {
        int height = 0;
        if (node != null)
            height = 1 + Math.max (getHeight (node.left),
                    getHeight (node.right));
        return height;
    } // end getHeight

    /**
     * Get the number of nodes in the tree
     * @return the number of the nodes
     */
    @Override
    public int getNumberOfNodes ()
    {
        int leftNumber = 0;
        int rightNumber = 0;
        if (left != null)
            leftNumber = left.getNumberOfNodes ();
        if (right != null)
            rightNumber = right.getNumberOfNodes ();
        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes          
} // end BinaryNode