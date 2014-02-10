package makingalicesmall;

/*
 * BinaryTree.java
 *
 * Created on May 21, 2007, 1:12 PM
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Carrano
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> ,
    java.io.Serializable
{
    private BinaryNodeInterface<T> root;
    
    /**
     * default constructor
     */
    public BinaryTree ()
    {
        root = null;
    } // end default constructor

    /**
     * constructor
     * @param rootData data for root node
     */
    public BinaryTree (T rootData)
    {
        root = new BinaryNode <> (rootData);
    } // end constructor

    /**
     * constructor
     * @param rootData data for root node
     * @param leftTree left subtree to attach
     * @param leftTree right subtree to attach
     */
    public BinaryTree (T rootData, BinaryTree<T> leftTree,
            BinaryTree<T> rightTree)
    {
        privateSetTree (rootData, leftTree, rightTree);
    } // end constructor

    /**
     * sets the root node
     * @param rootData data for root node
     */
    @Override
    public void setTree (T rootData)
    {
        root = new BinaryNode <> (rootData);
    } // end setTree

    /**
     * sets the root node
     * @param rootData data for root node
     * @param leftTree left subtree to attach
     * @param leftTree right subtree to attach
     */
    @Override
    public void setTree (T rootData, BinaryTreeInterface < T > leftTree,
            BinaryTreeInterface < T > rightTree)
    {
        privateSetTree (rootData, (BinaryTree < T > ) leftTree,
                (BinaryTree < T > ) rightTree);
    } // end setTree

    /**
     * @return copy of the tree
     */
    public BinaryNodeInterface<T> copy ()
    {
        BinaryNode < T > newRoot = new BinaryNode <> (root.getData());
        if (root.getLeftChild() != null)
            newRoot.setLeftChild((BinaryNode <T>)root.getLeftChild().copy());
        if (root.getRightChild() != null)
            newRoot.setRightChild((BinaryNode <T>)root.getRightChild().copy());
        return newRoot;
    } // end copy

    /*
     * Gets the tree height
     * @return height of tree
     */
    @Override
    public int getHeight()
    {
        return root.getHeight();
    } // end getHeight

    /*
     * gets the number of nodesw
     * @return numberOfNodes
     */
    @Override
    public int getNumberOfNodes()
    {
        return root.getNumberOfNodes();
    } // end getNumberOfNodes
 
    private void privateSetTree(T rootData, BinaryTree < T > leftTree,
            BinaryTree < T > rightTree)
    {
        root = new BinaryNode <> (rootData);
        if ((leftTree != null) && !leftTree.isEmpty ())
            root.setLeftChild (leftTree.root.copy ());
        if ((rightTree != null) && !rightTree.isEmpty ())
            root.setRightChild (rightTree.root.copy ());
    } // end privateSetTree

    /**
     * Accessors for the root data
     * @return A root data
     */
    @Override
    public T getRootData ()
    {
        T rootData = null;
        if (root != null)
            rootData = root.getData ();
        return rootData;
    } // end getRootData

    /**
     * Checking if the tree is empty
     * @return True if the tree is empty; otherwise, return false
     */
    @Override
    public boolean isEmpty ()
    {
        return root == null;
    } // end isEmpty

    /**
     * Clear the binary tree
     */
    @Override
    public void clear ()
    {
        root = null;
    } // end clear

    /**
     * Setup a root data for the binary tree
     * @param rootData Supposely to be the root
     */
    protected void setRootData (T rootData)
    {
        root.setData (rootData);
    } // end setRootData

    /**
     * Setup a root data for the binary tree
     * @param rootNode Supposely to be the root
     */
    protected void setRootNode (BinaryNodeInterface < T > rootNode)
    {
        root = rootNode;
    } // end setRootNode

    /**
     * Accessors for the root
     * @return 
     */
    protected BinaryNodeInterface<T> getRootNode ()
    {
        return root;
    } // end getRootNode
    
    /**
     * In Order Traversal
     */
    public void inorderTraverse ()
    {
        Stack< BinaryNodeInterface<T>> nodeStack =
                new Stack<>();
        BinaryNodeInterface < T > currentNode = root;
        while (!nodeStack.isEmpty () || (currentNode != null))
        {
            // find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push (currentNode);
                currentNode = currentNode.getLeftChild ();
            } // end while
            // visit leftmost node, then traverse its right subtree
            if (!nodeStack.isEmpty ())
            {
                BinaryNodeInterface < T > nextNode = nodeStack.pop ();
                assert nextNode != null; // since nodeStack was not empty
                // before the pop
                System.out.println (nextNode.getData ());
                currentNode = nextNode.getRightChild ();
            } // end if
        } // end while
    } 

    /**
     *  Internal iterator
     */
    private class InorderIterator implements Iterator<T>
    {
        private Stack<BinaryNodeInterface<T>> nodeStack;
        private BinaryNodeInterface < T > currentNode;

        /**
         *  Default constructor
         */
        public InorderIterator ()
        {
            nodeStack = new Stack<>();
            currentNode = root;
        }

        /**
         * Returns true if there is a next element; false otherwise
         * @return true if there is a next element; false otherwise
         */
        @Override
        public boolean hasNext ()
        {
            return !nodeStack.isEmpty () || (currentNode != null);
        }

        /**
         * Returns the next element and moves forward
         * @return the next element
         */
        @Override
        public T next ()
        {
            BinaryNodeInterface < T > nextNode = null;
            // find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push (currentNode);
                currentNode = currentNode.getLeftChild ();
            } // end while
            // get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty ())
            {
                nextNode = nodeStack.pop ();
                assert nextNode != null; // since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild ();
            }
            else
                throw new NoSuchElementException ();
            return nextNode.getData ();
        } // end next

        /**
         * unsupported
         */
        @Override
        public void remove ()
        {
            throw new UnsupportedOperationException ();
        }

    }

   /**
    * returns a new iterator over the class
    * @return a new iterator
    */
    @Override
   public InorderIterator getInOrderIterator()
   {
       return new InorderIterator();
   }
}

