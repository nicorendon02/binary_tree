package com.binary_tree.binary_tree.model;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class AVLTree {
    AVLNode root;

    public void addNode(Boy data, int height, int balance) throws BinaryTreeException {
        if (root == null) {
            root = new AVLNode(data, height);
        } else {
            root.addNode(data, height, balance);
        }

    }

    public int getLeftHeight() {
        if (root.getLeft() != null) {
            return root.getLeft().getLeftHeight();
        }
        return 0;
    }

    public int getRightHeight() {
        if (root.getRight() != null) {
            return root.getRight().getRightHeight();

        }
        return 0;
    }

    public List<Boy> listBoys(int which) throws BinaryTreeException {
        List<Boy> listBoys = new ArrayList<>();
        switch (which) {
            case 1:
                return root.listBoysPreOrden();

        }
        throw new BinaryTreeException("There is no data to show!");
    }


}