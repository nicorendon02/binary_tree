package com.binary_tree.binary_tree.model;

import lombok.Data;
import lombok.NoArgsConstructor;

// using the Lombok Annotations
@Data
public class AVLNode {
    private Boy data;
    private NodeAvl right;
    private NodeAvl left;
    private int  height;
    private int balance;

    public NodeAvl(Boy data, int height) {
        this.data = data;
        this.height = height;

    }

    public void addNode(Boy data, int height, int balance) throws BinaryTreeException {

        if (data.getIdentification() < this.getData().getIdentification()) {
            if (this.getLeft() == null) {
                this.setLeft(new NodeAvl(data, height));
            } else {
                this.left.addNode(data, height + 1, 0);

            }
        } else if (data.getIdentification() > this.getData().getIdentification()) {

            if (this.getRight() == null) {

                this.setRight(new NodeAvl(data, height));
            } else {

                this.right.addNode(data, height + 1, 0);
            }
        } else {
            throw new BinaryTreeException("No hay ninos");
        }

        int leftHeight = getLeftHeight();
        int rightHeight = getRightHeight();
        balance = leftHeight - rightHeight;

        if (balance == 1 || balance == -1 || balance == 0) {
            System.out.println(this.getData() + " balance " + balance + " height " + height);
            System.out.println("Tree Balanced");
        }

        if (balance > 1) {
            System.out.println(this.getData() + " balance " + balance + " height " + height);
            System.out.println("rotacion simple derecha");
            RightRotateTree();
        }


        if (balance < -1) {
            System.out.println(this.getData());
            System.out.println("rotacion simple izquierda" + " balance " + balance + " height " + height);
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
        NodeAvl temp = new NodeAvl(this.data, height);
        temp.left = this.left;
        temp.right = this.right.left;
        this.data = this.right.data;
        this.right = this.right.right;
        this.left = temp;
    }

    private void RightRotateTree() {
        NodeAvl temp = new NodeAvl(this.data, height);
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
