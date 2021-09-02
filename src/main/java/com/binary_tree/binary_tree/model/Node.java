package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString
// Generating the class with Attributes
public class Node {
    private Boy data;
    private Node left;
    private Node right;
    private int grade;

// generating constructor method
    public Node(Boy data) {
        this.data = data;
        this.grade = 1;
    }

    // addBoy method signature (throws Exception in case of a mistake)
    public void addBoy(Boy data) throws BinaryTreeException
    {
        // if the Node ID is < root ID
        if(data.getIdentification() < this.getData().getIdentification())
        {
            // if root Left == null
            if(this.getLeft()==null)
            {
                // root Left receives the Node
                this.setLeft(new Node(data));
            }
            // if root Left has something...
            else
            {
                // move to the Left and call the method AGAIN!
                this.left.addBoy(data);
            }
        }
        // if the Node is > root ID
        else if (data.getIdentification() > this.getData().getIdentification())
        {
            // if root Right == null
            if(this.getRight()==null)
            {
                // the Node goes to the Right side
                this.setRight(new Node(data));
            }
            // if the root Right has something...
            else
            {
                // move to the Right and call the method AGAIN!
                this.right.addBoy(data);
            }
        }
        // if the Node ID is EQUAL TO root ID
        else
        {
            // A node with that ID already exists. (Exception)
            throw new BinaryTreeException("A Boy with that ID already exists!");
        }
    }

    // ----- Sort Methods -----

    // Method preOrder
    public List<Boy> listBoysPreOrder() {
        // Generate a new List to append Boys
        List<Boy> listBoysPreOrder = new ArrayList<>();
        // List appends the root
        listBoysPreOrder.add(this.getData());
        // if root Left has something...
        if(this.getLeft() != null){
            // move to the Left and call the method AGAIN! and add ALL
            listBoysPreOrder.addAll(this.getLeft().listBoysPreOrder());
        }
        // if root Right has something...
        if(this.getRight() != null){
            // move to the Right and call the method AGAIN! and add ALL
            listBoysPreOrder.addAll(this.getRight().listBoysPreOrder());
        }
        // Once finished return the List
        return  listBoysPreOrder;
    }

    public List<Boy> listBoysInOrder(){
        // Generate a new List
        List<Boy> listBoysInOrder = new ArrayList<>();
        // if root Left has something...
        if(this.getLeft() != null){
            // move to the Left and call the method AGAIN! and add ALL
            listBoysInOrder.addAll(this.getLeft().listBoysInOrder());
        }
        // add root to the List
        listBoysInOrder.add(this.getData());

        // if the root Right has something...
        if(this.getRight() != null){
            // move to the Right and call the method AGAIN! and add ALL
            listBoysInOrder.addAll(this.getRight().listBoysInOrder());
        }
        // Once finished return the List
        return listBoysInOrder;
    }

    public List<Boy> listBoysPostOrder(){
        // Generate a new List
        List<Boy> listBoysPostOrder = new ArrayList<>();
        // if root Left has something...
        if(this.getLeft() != null){
            // move to the Left and call the method AGAIN! and add ALL
            listBoysPostOrder.addAll(this.getLeft().listBoysPostOrder());
        }
        // if the root Right has something...
        if(this.getRight() != null){
            // move to the Right and call the method AGAIN! and add ALL
            listBoysPostOrder.addAll(this.getRight().listBoysPostOrder());
        }
        // add the root to the List
        listBoysPostOrder.add(this.getData());
        // Once finished return the List
        return listBoysPostOrder;
    }

    // method to return which boys' IDs end in a certain number given by user
    public List<Boy> listEqualNum(int number)
    {
        // Creating a new List...
        List<Boy> listEqualNum = new ArrayList<>();
        // Validate if root ends in number
        if(this.getData().getIdentification() %10 == number)
        {
            listEqualNum.add(this.getData());
        }
        // if root Left has something...
        if (this.getLeft() != null)
        {
            // if root Left ends in number...
            if (this.getData().getIdentification() % 10 == number)
            {
                // add to the List and move to the Left and call the method AGAIN!
                listEqualNum.addAll(this.getLeft().listEqualNum(number));
            }
        }
        // if root Right has something...
        if (this.getRight() != null)
        {
            // if root Right ends in number...
            if (this.getData().getIdentification() % 10 == number)
            {
                // add to the List and move to the Right and call the method AGAIN!
                listEqualNum.addAll(this.getRight().listEqualNum(number));
            }
        }
        // Once finished return the List
        return listEqualNum;
    }

    // validate if the Node is a Leaf
    public boolean isLeaf()
    {
        // return TRUE if the Node has Left & Right == null
        return left ==null && right==null;
    }

    // Method to get All existing Leaves
    public List<Boy> getLeaves() {
        // Generate a new List
        List<Boy> getLeaves = new ArrayList<>();
        // if root is a Leaf...
        if (this.isLeaf()) {
            getLeaves.add(this.getData());
        }
        else
        {
            // if root Left has something...
            if (this.getLeft() != null)
            {
                // add to the List and move to the Left and call the method AGAIN!
                getLeaves.addAll(this.getLeft().getLeaves());
            }
            // if root Right has something...
            if (this.getRight() != null)
            {
                // add to the List and move to the Right and call the method AGAIN!
                getLeaves.addAll(this.getRight().getLeaves());
            }
        }
        // Once finished return the List
        return getLeaves;
    }

    // Method to prune all existing Leaves in the Tree
    public void prune()
    {
        // if root Left has something...
        if (this.getLeft() != null)
        {
            // ir root Left is a Leaf...
            if (this.getLeft().isLeaf())
            {
                // set root Left as null
                this.setLeft(null);
            }
            else
            {
                // move to the Left and call the Method AGAIN!
                this.getLeft().prune();
            }
        }
        // if root Right has something...
        if (this.getRight() != null)
        {
            // is root Right is a Leaf...
            if (this.getRight().isLeaf())
            {
                // set root Right as null
                this.setRight(null);
            }
            else
            {
                // move to the Right and call the Method AGAIN!
                this.getRight().prune();
            }
        }
    }

    //REVIEW THIS ONE
    public int calculateGrade()
    {
        this.grade = 1;
        int gradeLeft = 0;
        int gradeRight = 0;
        if(this.getLeft() != null)
        {
            // finish this one!!!
            return 0;
        }
        return 0;
    }

    //REVIEW THIS ONE
    public List<Boy> isEqualAndLeaf(int number)
    {
        List<Boy> listEqualAndLeaf = new ArrayList<>();
        List<Boy> listEqual = new ArrayList<>();

        return listEqualAndLeaf;
    }
}
