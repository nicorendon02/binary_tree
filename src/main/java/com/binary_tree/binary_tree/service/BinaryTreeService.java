package com.binary_tree.binary_tree.service;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.controller.dto.ErrorDTO;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.model.BinaryTree;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.model.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BinaryTreeService {
    private BinaryTree binaryTree= new BinaryTree();


    public ResponseEntity<ResponseBinaryTreeDto> addBoy(Boy boy) throws BinaryTreeException
    {
        binaryTree.addNode(boy);
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(boy,"Se ha guardado exitosamente",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> listBoys(int which) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listBoys(which),"Success",
                        null),HttpStatus.OK);

    }


    public ResponseEntity<ResponseBinaryTreeDto> count()
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getCount(),"Contador vacio",
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

    public ResponseEntity<ResponseBinaryTreeDto> listGetLeafs() throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeafs(),"List Success",
                        null),HttpStatus.OK);

    }
}
