package com.binary_tree.binary_tree.controller;

import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.model.Node;
import com.binary_tree.binary_tree.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;

// Using Lombok Annotations...
@RestController
@RequestMapping(path = "binarytree")
@Validated
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Boy boy) throws BinaryTreeException {
        return binaryTreeService.addBoy(boy);
    }

    @GetMapping("/preorder")
    public @ResponseBody
    ResponseEntity<?> listBoysPreOrder() throws DataNotFoundException {
        return binaryTreeService.listBoys(1);
    }

    @GetMapping("/inorder")
    public @ResponseBody
    ResponseEntity<?> listBoysInOrder() throws DataNotFoundException {
        return binaryTreeService.listBoys(2);
    }

    @GetMapping("/postorder")
    public @ResponseBody
    ResponseEntity<?> listBoysPostOrder() throws DataNotFoundException {
        return binaryTreeService.listBoys(3);
    }

    @GetMapping("/count")
    public @ResponseBody
    ResponseEntity<?> countBinaryTree() throws DataNotFoundException {
        return binaryTreeService.count();
    }

    /*
    @GetMapping("/listEqualNum", value = (int number))
    public @ResponseBody
    ResponseEntity<?> listEqualNum(int number) throws DataNotFoundException {
        return binaryTreeService.listEqualNum(number);
    }

     */

    @GetMapping("/countEqualNum")
    public @ResponseBody
    ResponseEntity<?> counterEqualNum(Path.Node node, int number) throws BinaryTreeException {
        return binaryTreeService.counterEqualNum((Node) node,number);
    }

    @GetMapping("/getLeaves")
    public @ResponseBody
    ResponseEntity<?> getLeaves() throws DataNotFoundException {
        return binaryTreeService.getLeaves();
    }
}