package com.binary_tree.binary_tree.service;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.BinaryTree;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.model.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    // ResponseEntity to count Boys
    public ResponseEntity<ResponseBinaryTreeDto> count() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.count(),"Successful!",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to list Boys who end in a certain number given by the user
    public ResponseEntity<ResponseBinaryTreeDto> listEndEqualNum(int number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listEndEqualNum(number),"Successful List",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to show how many ID's end in a certain number given by the user
    public ResponseEntity<ResponseBinaryTreeDto> countEndEqualNum(int number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.countEndEqualNum(number),"Successful Counter",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> getLeaves() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeaves(),"List Success",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to prune the existing Leaves in the Tree
    public ResponseEntity<ResponseBinaryTreeDto> prune() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.prune(),"successful pruning",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to calculate the Tree Grade
    public ResponseEntity<ResponseBinaryTreeDto> calculateTreeGrade() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.calculateTreeGrade(),"successful",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to get All Boys Grade
    public ResponseEntity<ResponseBinaryTreeDto> getBoysGrade() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getBoysGrade(),"successful",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to get All Boys of a certain Level given by user
    public ResponseEntity<ResponseBinaryTreeDto> getBoysByLevel(int wantedLevel) throws DataNotFoundException,
            BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getBoysByLevel(wantedLevel),"successful",
                        null),HttpStatus.OK);

    }
}
