package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.controller.dto.BoyGradeDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
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
    public List<Boy> listEndEqualNum(int number) //throws DataNotFoundException
    {
        // Creating a new List...
        List<Boy> listEndEqualNum = new ArrayList<>();
        // Validate if root ends in number
        if(this.getData().getIdentification() %10 == number)
        {
            listEndEqualNum.add(this.getData());
        }
        // if root Left has something...
        if (this.getLeft() != null)
        {
            // if root Left ends in number...
            if (this.getData().getIdentification() % 10 == number)
            {
                // add to the List and move to the Left and call the method AGAIN!
                listEndEqualNum.addAll(this.getLeft().listEndEqualNum(number));
            }
        }
        // if root Right has something...
        if (this.getRight() != null)
        {
            // if root Right ends in number...
            if (this.getData().getIdentification() % 10 == number)
            {
                // add to the List and move to the Right and call the method AGAIN!
                listEndEqualNum.addAll(this.getRight().listEndEqualNum(number));
            }
        }

        // HELP WITH THIS VALIDATION!!
        /*
        if(listEqualNum.isEmpty()){
            throw new DataNotFoundException("no hay niños terminados en ese numero");
        }
         */

        // Once finished return the List
        return listEndEqualNum;
    }

    // Method to count how many Boys' ID end in a certain number given by the user
    public int countEndEqualNum(int number)
    {
        // set a new variable with the list that the method above returns...
        List<Boy> listBoysEndEqualNum = listEndEqualNum(number);
        // return the list Size (int)...
        return listBoysEndEqualNum.size();
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

    // Method to calculate Tree Grade
    public int calculateTreeGrade()
    {
        int gradeLeft = 0, gradeRight = 0;
        // if the current Node is a Leaf...
        if(this.isLeaf())
        {
            return 1;
        }
        // if the current Node has kids...
        else
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // calculate grade on the Left and save the number in gradeLeft
                gradeLeft = this.getLeft().calculateTreeGrade();
            }
            // if current on the Right has something...
            if(this.getRight() != null)
            {
                // calculate grade on the Right and save the number in gradeRight
                gradeRight = this.getRight().calculateTreeGrade();
            }
        }
        // ---- RETURN 1 + MY LARGEST CHILD ----
        // if current on the Left is >= current on the Right...
        if(gradeLeft >= gradeRight)
        {
            // return current (1) + current Left Grade
            return 1 + gradeLeft;
        }
        // if current on the Left < current on the Right...
        else
        {
            // return current (1) + current Right Grade
            return 1 + gradeRight;
        }
    }

    // Method to get Boys Grade using a DataTransferObject
    public List<BoyGradeDTO> getBoysGrade()
    {
        // Generating a List of BoyGradeDTO
        List<BoyGradeDTO> listBoys = new ArrayList<>();
        int gradeLeft = 0, gradeRight = 0;
        // if the current Node is a Leaf...
        if(this.isLeaf())
        {
            // create a DTO with currentNodeData and current grade (int)
            listBoys.add(new BoyGradeDTO(this.data,this.grade));
        }
        // if the current Node has kids...
        else
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // calculate grade on the Left and save the number in gradeLeft
                gradeLeft = this.getLeft().calculateTreeGrade();
                // call the Method again and add All Boys on the Left
                listBoys.addAll(this.getLeft().getBoysGrade());
            }
            // if current on the Right has something...
            if(this.getRight() != null)
            {
                // calculate grade on the Right and save the number in gradeRight
                gradeRight = this.getRight().calculateTreeGrade();
                // call the Method again and add All Boys on the Right
                listBoys.addAll(this.getRight().getBoysGrade());
            }

            // ---- RETURN 1 + MY LARGEST CHILD ----
            // if current on the Left is >= current on the Right...
            if(gradeLeft >= gradeRight)
            {
                // return current (1) + current Left Grade
                listBoys.add(new BoyGradeDTO(this.data,1 + gradeLeft));
            }
            // if current on the Left < current on the Right...
            else
            {
                // return current (1) + current Right Grade
                listBoys.add(new BoyGradeDTO(this.data,1 + gradeRight));
            }
        }
        return listBoys;
    }

    //REVIEW THIS ONE (LOGIC ERRORS!)
    // Method to get All Boys of a certain Level given by user
    public List<Boy> getBoysByLevel(int currentLevel, int wantedLevel)
    {
        // Generating a List...
        List<Boy> listBoysLevel= new ArrayList<>();
        // if current level is equal to wanted level...
        if(currentLevel == wantedLevel)
        {
            // add current to the List
            listBoysLevel.add(this.data);
        }
        else
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // call the Method again and add all on the Left (go down 1 level)
                listBoysLevel.addAll(this.getLeft().getBoysByLevel(currentLevel+1, wantedLevel));
            }
            // if current on the Right has something...
            if(this.getRight() != null)
            {
                // call the Method again and add all on the Right (go down 1 level)
                listBoysLevel.addAll(this.getRight().getBoysByLevel(currentLevel+1, wantedLevel));
            }
        }
        return listBoysLevel;
    }

    // Method to get Boys that end in a certain number and are Leaves
    public List<Boy> isEqualAndLeaf(int number)
    {
        // Generating the List...
        List<Boy> listEqualAndLeaf = new ArrayList<>();
        // if current ends in the number and is a Leaf
        if(this.getData().getIdentification() %10 == number && this.isLeaf())
        {
            // add current to the List
            listEqualAndLeaf.add(this.data);
        }
        // if current on the Left has something...
        if(this.getLeft() != null)
        {
            // call the Method again and add All on the Left
            listEqualAndLeaf.addAll(this.getLeft().isEqualAndLeaf(number));
        }
        // if current on the Right has something...
        if(this.getRight() != null)
        {
            // call the Method again and add All on the Right
            listEqualAndLeaf.addAll(this.getRight().isEqualAndLeaf(number));
        }
        return listEqualAndLeaf;
    }

    // Method to find the Largest ID of the Tree
    public Boy findLargestId()
    {
        // if current on the Right has something...
        if(this.getRight() == null)
        {
            return this.getData();
        }
        // Move to the Right until the Method finds a Node without kids on the Right
        return this.getRight().findLargestId();
    }

    // Method to find the Largest ID of the Tree (returns the Node)
    public Node findLargestIdNode()
    {
        // if current on the Right has something...
        if(this.getRight() == null)
        {
            return this;
        }
        // Move to the Right until the Method finds a Node without kids on the Right
        return this.getRight().findLargestIdNode();
    }

    // Method to find the Smallest ID of the Tree
    public Boy findSmallestId()
    {
        // if current on the Left has something...
        if(this.getLeft() == null)
        {
            return this.getData();
        }
        // Move to the Left until the Method finds a Node without kids on the Left
        return this.getLeft().findSmallestId();
    }

    // Method to find the Smallest ID of the Tree (returns the Node)
    public Node findSmallestIdNode()
    {
        // if current on the Left has something...
        if(this.getLeft() == null)
        {
            return this;
        }
        // Move to the Left until the Method finds a Node without kids on the Left
        return this.getLeft().findSmallestIdNode();
    }

    // Method to find the father of a certain Boy' ID
    public Boy findMyFather(int id)
    {
        // if the requested ID < current ID
        if(id < this.getData().getIdentification())
        {
            // if current has something on the Left...
            if(this.getLeft() != null)
            {
                // if current ID == requested ID
                if(this.getLeft().getData().getIdentification() == id)
                {
                    // current is the father
                    return this.getData();
                }
                // move to the Left and ask again
                return this.getLeft().findMyFather(id);
            }
            // if current has nothing on the Left
            return null;
        }
        // if current has something on the Right
        if(this.getRight() != null)
        {
            // if current ID == requested ID
            if(this.getRight().getData().getIdentification() == id)
            {
                // current is the father
                return this.getData();
            }
            // Move to the Right and ask again
            return this.getRight().findMyFather(id);
        }
        // if current has nothing on the Right
        return null;
    }

    // Method to delete a Boy by ID
    public void deleteBoy(int idToDelete) throws DataNotFoundException
    {
        // if idToDelete < current ID
        if(idToDelete < this.data.getIdentification())
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // if my Left child ID is the Boy to delete
                if(this.getLeft().getData().getIdentification() == idToDelete)
                {
                    // if my Left child is a Leaf...
                    if(this.getLeft().isLeaf())
                    {
                        // delete my Left child
                        this.setLeft(null);
                    }
                    // if my Left child on his Left is null and on his Right has something...
                    else if(this.getLeft().getLeft() == null && this.getLeft().getRight() != null)
                    {
                        // my Left will be my Left child's Right
                        this.setLeft(this.getLeft().getRight());
                    }
                    // if my Left child on his Left has something and on his Right is null...
                    else if(this.getLeft().getLeft() != null && this.getLeft().getRight() == null)
                    {
                        // my Left will be my Left child's Left
                        this.setLeft(this.getLeft().getLeft());
                    }
                    else
                    {
                        // Here the Boy to delete has his Left & Right != null
                        // my Left child's Left finds his LargestBoy to capture the data
                        Boy dataTransfer = this.getLeft().getLeft().findLargestId();
                        // my Left child deletes that largestBoy
                        this.getLeft().deleteBoy(dataTransfer.getIdentification());
                        // replace my Left child's data with dataTransfer
                        this.getLeft().setData(dataTransfer);
                    }
                }
                // if my Left child is not the Boy to delete...
                else
                {
                    // move to the Left and ask again
                    this.getLeft().deleteBoy(idToDelete);
                }
            }
            // if the Method couldn't find the Boy to delete...
            else
            {
                throw new DataNotFoundException("This Boy does not exist");
            }
        }
        // if idToDelete > current ID
        // find on my Right...
        else
        {
            // if my Right has something...
            if(this.getRight() != null)
            {
                // if my Right child is the Boy to delete...
                if(this.getRight().getData().getIdentification() == idToDelete)
                {
                    // if my Right child is a Leaf...
                    if(this.getRight().isLeaf())
                    {
                        // delete my Right
                        this.setRight(null);
                    }
                    // if my Right child has his Left null and his Right has something...
                    else if(this.getRight().getLeft() == null && this.getRight().getRight() != null)
                    {
                        // my Right will be my Right child's Right
                        this.setRight(this.getRight().getRight());
                    }
                    // if my Right child has his Left has something and his Right is null...
                    else if(this.getRight().getLeft() != null && this.getRight().getRight() == null)
                    {
                        // my Right will be my Right child's Left
                        this.setRight(this.getRight().getLeft());
                    }
                    // if the Boy to delete has his Left & Right != null
                    else
                    {
                        // my Right child's Left finds his largestBoy to capture
                        Boy dataTransfer = this.getRight().getLeft().findLargestId();
                        // my Right child deletes that largestBoy
                        this.getRight().deleteBoy(dataTransfer.getIdentification());
                        // replace my Right child's data with dataTransfer
                        this.getRight().setData(dataTransfer);
                    }
                }
                // if my Right child is not the Boy to delete
                else
                {
                    // move to the Right and ask again
                    this.getRight().deleteBoy(idToDelete);
                }
            }
            // if the Method couldn't find the Boy to delete...
            else
            {
                throw new DataNotFoundException("This Boy does not exist");
            }
        }
    }
}
