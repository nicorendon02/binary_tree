package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// using the Lombok Annotations
@Data
@NoArgsConstructor

// Generating the class with Attributes
public class BinaryTree {
    private Node root;
    private int count;

    // method that calls the one in the Node Model later on...
    public void addBoy(Boy data) throws BinaryTreeException
    {
        // validate whether the root is empty
        if(root==null)
        {
            // set a new root
            root = new Node(data);
        }
        // if the root already exists...
        else
        {
            // Call the method in the Node class to locate the Boy in the correct position!
            root.addBoy(data);
        }
        // the BoysCount increases when finished.
        count ++;
    }

    // method to ListBoys using Sorting Methods
    public List<Boy> listBoys(int which) throws DataNotFoundException
    {
        if (root == null)
        {
            throw new DataNotFoundException("There are no boys to show");
        }
        else {
            // Call to a certain method according to an Option...
            switch (which) {
                case 1:
                    return root.listBoysPreOrder();
                case 2:
                    return root.listBoysInOrder();
                case 3:
                    return root.listBoysPostOrder();
            }
            // if the List is empty
            throw new DataNotFoundException("No data to show");
        }
    }

    // Method to count how many Boys are in there
    public int count() throws DataNotFoundException
    {
        if(this.getCount() != 0)
        {
            return this.getCount();
        }
        throw new DataNotFoundException("The counter is empty");
    }

    // Method to show the Boys ending in a certain number given by the user
    public List<Boy> listEqualNum(int number) throws DataNotFoundException
    {
        // if root has something...
        if (root!=null)
        {
            return root.listEqualNum(number);
        }
        throw new DataNotFoundException("There are no Boys yet");
    }

    // REVIEW THIS ONE
    public int counterEqualNum(Node node, int number)throws BinaryTreeException{
        if(node != null){
            int cont=0;
            if(node.getData().getIdentification()%10 == number){
                cont = 1;

            }
            return cont + counterEqualNum(node.getLeft(), number) + counterEqualNum(node.getRight(),number);
        }
        throw new BinaryTreeException("No existen datos con este numero en comun");
    }

    // Method to show all existing Leaves in the Tree
    public List<Boy> getLeaves() throws DataNotFoundException
    {
        // if root has something...
        if(root!=null)
        {
            // call the method in Node
            return root.getLeaves();
        }
        else
        {
            throw new DataNotFoundException("The tree is empty");
        }
    }

    // Method to prune the existing Leaves
    public boolean prune() throws DataNotFoundException
    {
        // if root has something...
        if(root!=null)
        {
            // if root is a Leaf...
            if(root.isLeaf())
            {
                // set root as null
                root=null;
                return true;
            }
            else
            {
                // call the Method in Node
                root.prune();
                return true;
            }
        }
        throw new DataNotFoundException("There are no data to prune");
    }
}
