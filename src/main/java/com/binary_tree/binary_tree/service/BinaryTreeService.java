package com.binary_tree.binary_tree.service;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.controller.dto.ErrorDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.BinaryTree;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.model.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Using Lombok Annotations
@Service

// Generating the class with Attributes
public class BinaryTreeService {
    // Activate the process by creating the Tree!!
    private BinaryTree binaryTree = new BinaryTree();

    // ResponseEntity for addBoy methods
    public ResponseEntity<ResponseBinaryTreeDto> addBoy(Boy boy) throws BinaryTreeException
    {
        // call the first method located in BinaryTree
        binaryTree.addBoy(boy);
        // Once the Boy is added correctly...
        return new ResponseEntity<>(new ResponseBinaryTreeDto(boy,"Boy added correctly!",
                        null),HttpStatus.OK);
    }

    // ResponseEntity for listBoys methods
    public ResponseEntity<ResponseBinaryTreeDto> listBoys(int which) throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDto(binaryTree.listBoys(which),"Successful!",
                        null),HttpStatus.OK);

    }


    public ResponseEntity<ResponseBinaryTreeDto> count()
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getCount(),"The counter is empty",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> counterEqualNum(Node node, int number) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.counterEqualNum(node,number),"Counter Success",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listEqualNum(int number) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listEqualNum(number),"List Success",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listGetLeaves() throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeaves(),"List Success",
                        null),HttpStatus.OK);

    }
}
