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

    @GetMapping("/listEndEqualNum/{number}")
    public @ResponseBody
    ResponseEntity<?> listEndEqualNum(@PathVariable int number) throws DataNotFoundException {
        return binaryTreeService.listEndEqualNum(number);
    }

    @GetMapping("/countEndEqualNum/{number}")
    public @ResponseBody
    ResponseEntity<?> countEndEqualNum(@PathVariable int number) throws DataNotFoundException {
        return binaryTreeService.countEndEqualNum(number);
    }

    @GetMapping("/getLeaves")
    public @ResponseBody
    ResponseEntity<?> getLeaves() throws DataNotFoundException {
        return binaryTreeService.getLeaves();
    }

    // prune the existing Leaves in the Tree
    @GetMapping("/prune")
    public @ResponseBody
    ResponseEntity<?> prune() throws DataNotFoundException {
        return binaryTreeService.prune();
    }

    // calculate Tree Grade
    @GetMapping("/treeGrade")
    public @ResponseBody
    ResponseEntity<?> calculateTreeGrade() throws DataNotFoundException {
        return binaryTreeService.calculateTreeGrade();
    }

    // get All Boys Grade
    @GetMapping("/boysGrade")
    public @ResponseBody
    ResponseEntity<?> getBoysGrade() throws DataNotFoundException {
        return binaryTreeService.getBoysGrade();
    }

    // get Boys by Level
    @GetMapping("/boysByLevel/{level}")
    public @ResponseBody
    ResponseEntity<?> getBoysByLevel(@PathVariable int level) throws DataNotFoundException, BinaryTreeException {
        return binaryTreeService.getBoysByLevel(level);
    }
}