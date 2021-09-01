package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BinaryTree {
    private Node root;
    private int count;

    public void addBoy(Boy data) throws BinaryTreeException
    {
        if(root==null)
        {
            root = new Node(data);
        }
        else
        {
            root.addBoy(data);
        }
        count ++;
    }

    public List<Boy> getLeafs() throws BinaryTreeException
    {
        if(root!=null)
        {
            return root.getLeafs();
        }
        else
        {
            throw new BinaryTreeException("El arbol esta vacio");
        }
    }

    public List<Boy> listBoys(int which) throws BinaryTreeException{
        List<Boy> listBoys = new ArrayList<>();
        switch (which){
            case 1:
                return root.listBoysPreOrden();
            case 2:
                return root.listBoysInOrden();
            case 3:
                return root.listBoysPostOrden();
        }

        throw new BinaryTreeException("No hay datos que mostrar");
    }

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


    public List<Boy> listEqualNum(int number) throws BinaryTreeException{
        List<Boy> listEqualNum = new ArrayList<>();

        if (root!=null){

            return root.listEqualNum(number);
        }
        throw new BinaryTreeException("No hay datos en la lista");
    }

    //REVIEW THIS ONE / What does it return?
    public void prune() throws DataNotFoundException
    {
        if(root!=null)
        {
            if(root.isLeaf())
            {
                root=null;
            }
            else
            {
                root.prune();
            }
        }
        throw new DataNotFoundException("No hay datos que mostrar");
    }
}
