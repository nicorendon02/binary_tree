package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.controller.dto.BoyGradeDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    public List<Boy> listEndEqualNum(int number) throws DataNotFoundException
    {
        // if root has something...
        if (root!=null)
        {
            if(root.listEndEqualNum(number).isEmpty())
            {
                throw new DataNotFoundException("There are no Boys with that condition");
            }
            // call the method in Node
            return root.listEndEqualNum(number);
        }
        throw new DataNotFoundException("There are no Boys yet");
    }

    // Method to count Boy's ID that end in the same number
    public int countEndEqualNum(int number) throws DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            // if the counter found boys ending in that number...
            if(root.countEndEqualNum(number) != 0)
            {
                // call the method in Node
                return root.countEndEqualNum(number);
            }
            // if the counter couldn't find boys ending in that number...
            else
            {
                throw new DataNotFoundException("There are no boys ending in that number");
            }
        }
        throw new DataNotFoundException("There are no boys yet");
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

    public int calculateTreeGrade() throws DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            return root.calculateTreeGrade();
        }
        throw new DataNotFoundException("There are no boys yet");
    }

    // Get All Boys Grade
    public List<BoyGradeDTO> getBoysGrade() throws DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            return root.getBoysGrade();
        }
        throw new DataNotFoundException("There are no boys yet");
    }

    // get Boys by Level
    public List<Boy> getBoysByLevel(int wantedLevel) throws DataNotFoundException,BinaryTreeException
    {
        // if root has something...
        if(root!=null)
        {
            // if wanted Level exists...
            if(wantedLevel <= root.calculateTreeGrade())
            {
                return root.getBoysByLevel(1, wantedLevel);
            }
            throw new BinaryTreeException("This level does not exist");
        }
        throw new DataNotFoundException("There are no boys yet");
    }

    // get Boys that end in a certain number and are Leaves
    public List<Boy> isEqualAndLeaf(int number) throws DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            // if the Method returns an Empty List...
            if(root.isEqualAndLeaf(number).isEmpty())
            {
                throw new DataNotFoundException("There are no Boys with that condition");
            }
            return root.isEqualAndLeaf(number);
        }
        throw new DataNotFoundException("There are no boys yet");
    }

    // Method to find the Largest ID of the Tree
    public Boy findLargestId() throws DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            return root.findLargestId();
        }
        throw new DataNotFoundException("There are no Boys yet");
    }

    // Method to find the Smallest ID of the Tree
    public Boy findSmallestId() throws DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            return root.findSmallestId();
        }
        throw new DataNotFoundException("There are no Boys yet");
    }

    // Method to find the father of a certain Boy' ID
    public Boy findMyFather(int id) throws BinaryTreeException, DataNotFoundException
    {
        // if root has something...
        if(root != null)
        {
            // if root ID == requested ID
            if(root.getData().getIdentification() == id)
            {
                throw new BinaryTreeException("This Boy has no father");
            }
            // if the Method in Node returns NULL
            else if(root.findMyFather(id) == null)
            {
                throw new DataNotFoundException("That Boy' ID does not exist");
            }
            return root.findMyFather(id);
        }
        throw new DataNotFoundException("There are no Boys yet");
    }

    // Method to delete a Boy by ID
    public void deleteBoy(int idToDelete) throws DataNotFoundException
    {
        // if the root has something
        if(root != null)
        {
            // if root is the Boy to delete
            if(root.getData().getIdentification() == idToDelete)
            {
                // create a temporal Node and set the original root on his Left
                Node temp = new Node(new Boy(root.getData().getIdentification()+1,
                        "temp",(byte) 1,"Manizales"));
                temp.setLeft(root);
                // call the Method from temp to delete the original root
                temp.deleteBoy(idToDelete);
                // once deleted, change the pointer to the new root
                root = temp.getLeft();
            }
            // if root is not the Boy to delete
            else
            {
                root.deleteBoy(idToDelete);
            }
        }
        else
        {
            throw new DataNotFoundException("There are no Boys yet");
        }
    }

}
