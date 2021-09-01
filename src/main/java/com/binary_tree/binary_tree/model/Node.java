package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString
public class Node {
    private Boy data;
    private Node left;
    private Node right;
    private int grade;


    public Node(Boy data) {
        this.data = data;
        this.grade = 1;
    }

    public boolean isLeaf()
    {
        return left ==null && right==null;
    }

    public void addNode(Boy data) throws BinaryTreeException
    {
        if(data.getIdentification() < this.getData().getIdentification())
        {
            if(this.getLeft()==null)
            {
                this.setLeft(new Node(data));
            }
            else
            {
                this.left.addNode(data);
            }
        }
        else if (data.getIdentification() > this.getData().getIdentification())
        {

            if(this.getRight()==null)
            {
                this.setRight(new Node(data));
            }
            else
            {

                this.right.addNode(data);
            }
        }
        else
        {
            throw new BinaryTreeException("Ya existe un niño con esa identificación");
        }

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
        return  listBoysPreOrden;
    }

    public List<Boy> listBoysInOrden(){

        List<Boy> listBoysInOrden = new ArrayList<>();
        if(this.getLeft() != null){
            listBoysInOrden.addAll(this.getLeft().listBoysInOrden());

        }

        listBoysInOrden.add(this.getData());

        if(this.getRight() != null){
            listBoysInOrden.addAll(this.getRight().listBoysInOrden());

        }

        return listBoysInOrden;
    }

    public List<Boy> listBoysPostOrden(){
        List<Boy> listBoysPostOrden = new ArrayList<>();
        if(this.getLeft() != null){
            listBoysPostOrden.addAll(this.getLeft().listBoysPostOrden());

        }

        if(this.getRight() != null){
            listBoysPostOrden.addAll(this.getRight().listBoysPostOrden());

        }

        listBoysPostOrden.add(this.getData());


        return listBoysPostOrden;
    }

    public List<Boy> listEqualNum(int number) {
        List<Boy> listEqualNum = new ArrayList<>();

        listEqualNum.add(this.getData());

        if (this.getLeft() != null) {
            if (this.getData().getIdentification() % 10 == number) {

                listEqualNum.addAll(this.getLeft().listEqualNum(number));
            }
        }

        if (this.getRight() != null) {
            if (this.getData().getIdentification() % 10 == number) {
                listEqualNum.addAll(this.getRight().listEqualNum(number));

            }
        }
        return listEqualNum;

    }


    public List<Boy> getLeafs() {
        List<Boy> getLeafs = new ArrayList<>();
        if (this.isLeaf()) {
            getLeafs.add(this.getData());
        } else {
            if (this.getLeft() != null) {
                getLeafs.addAll(this.getLeft().getLeafs());


            }
            if (this.getRight() != null) {
                getLeafs.addAll(this.getRight().getLeafs());
            }

        }
        return getLeafs;
    }

    //REVIEW THIS ONE
    public List<Boy> isEqualAndLeaf(int number)
    {
        List<Boy> listEqualAndLeaf = new ArrayList<>();
        List<Boy> listEqual = new ArrayList<>();

        return listEqualAndLeaf;
    }

    public void prune() {
        if (this.getRight() != null) {
            if (this.getRight().isLeaf()) {
                this.setRight(null);
            } else {
                this.getRight().prune();
            }
        }
        if (this.getLeft() != null) {
            if (this.getLeft().isLeaf()) {
                this.setLeft(null);
            } else {
                this.getLeft().prune();
            }
        }
    }

    public int calculateGrade()
    {
        this.grade = 1;
        int gradeLeft = 0;
        int gradeRight = 0;
        if(this.getLeft() != null)
        {

        }
    }
}
