package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AVLNode {
    private Boy data;
    private AVLNode right;
    private AVLNode left;
    private int  height;
    private int balance;

    public AVLNode(Boy data, int height) {
        this.data = data;
        this.height = height;

    }

    public void addNode(Boy data, int height, int balance) throws BinaryTreeException {

        if (data.getIdentification() < this.getData().getIdentification()) {
            if (this.getLeft() == null) {
                this.setLeft(new AVLNode(data, height));
            } else {
                this.left.addNode(data, height + 1, 0);

            }
        } else if (data.getIdentification() > this.getData().getIdentification()) {

            if (this.getRight() == null) {

                this.setRight(new AVLNode(data, height));
            } else {

                this.right.addNode(data, height + 1, 0);
            }
        } else {
            throw new BinaryTreeException("There are no Users");
        }

        int leftHeight = getLeftHeight();
        int rightHeight = getRightHeight();
        balance = leftHeight - rightHeight;

        if (balance == 1 || balance == -1 || balance == 0) {
            //System.out.println(this.getData() + " balance " + balance + " height " + height);
            //System.out.println("Tree Balanced");
        }

        if (balance > 1) {
            //System.out.println(this.getData() + " balance " + balance + " height " + height);
            //System.out.println("Right Simple Rotation");
            RightRotateTree();
        }


        if (balance < -1) {
            //System.out.println(this.getData());
            //System.out.println("Left Simple Rotation" + " balance " + balance + " height " + height);
            LeftRotateTree();
        }
    }

    public int getLeftHeight() {
        if(this.getLeft() != null){
            return 1 + this.getLeft().getLeftHeight();
        }else{
            return 1;
        }
    }

    public int getRightHeight(){
        if(this.getRight() != null){
            return 1 + this.getRight().getRightHeight();
        }else{
            return 1;
        }
    }

    private void LeftRotateTree() {
        AVLNode temp = new AVLNode(this.data, height);
        temp.left = this.left;
        temp.right = this.right.left;
        this.data = this.right.data;
        this.right = this.right.right;
        this.left = temp;
    }

    private void RightRotateTree() {
        AVLNode temp = new AVLNode(this.data, height);
        temp.right = this.right;
        temp.left = this.left.right;
        this.data = this.left.data;
        this.left = this.left.left;
        this.right = temp;
    }


    public List<Boy> listBoysPreOrden() {
        List<Boy> listBoysPreOrden = new ArrayList<>();
        listBoysPreOrden.add(this.getData());
        if(this.getLeft() != null){
            listBoysPreOrden.addAll(this.getLeft().listBoysPreOrden());

        }
        if(this.getRight() != null){

            listBoysPreOrden.addAll(this.getRight().listBoysPreOrden());

        }
        return listBoysPreOrden;
    }
}