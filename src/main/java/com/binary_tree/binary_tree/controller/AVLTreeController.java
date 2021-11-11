package com.binary_tree.binary_tree.controller;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.service.AVLTreeService;
import com.binary_tree.binary_tree.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Using Lombok Annotations...
@RestController
@RequestMapping(path = "avltree")
@Validated
@CrossOrigin("*")
public class AVLTreeController {

    @Autowired
    private AVLTreeService avlTreeService;
    /*

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Boy boy) throws BinaryTreeException {
        return avlTreeService.addNode(boy);
    }

    @GetMapping("/preorder")
    public @ResponseBody
    ResponseEntity<?> listBoysPreOrder() throws BinaryTreeException {
        return avlTreeService.listBoys(1);
    }

    /*
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

    // get Boys that end in a certain number and are Leaves
    @GetMapping("/equalAndLeaf/{number}")
    public @ResponseBody
    ResponseEntity<?> isEqualAndLeaf(@PathVariable int number) throws DataNotFoundException {
        return binaryTreeService.isEqualAndLeaf(number);
    }

    // find the Largest ID of the Tree
    @GetMapping("/largestId")
    public @ResponseBody
    ResponseEntity<?> findLargestId() throws DataNotFoundException {
        return binaryTreeService.findLargestId();
    }

    // find the Smallest ID of the Tree
    @GetMapping("/smallestId")
    public @ResponseBody
    ResponseEntity<?> findSmallestId() throws DataNotFoundException {
        return binaryTreeService.findSmallestId();
    }

    // fill a Tree using a List of Boys
    @PostMapping("/fill")
    public @ResponseBody
    ResponseEntity<?> fillTreeBoys(@RequestBody List<Boy> boys) throws BinaryTreeException {
        return binaryTreeService.fillTreeBoys(boys);
    }

    // find the father of a certain Boy' ID
    @GetMapping("/findMyFather/{id}")
    public @ResponseBody
    ResponseEntity<?> findMyFather(@PathVariable int id) throws BinaryTreeException,
            DataNotFoundException {
        return binaryTreeService.findMyFather(id);
    }

    // find the father of a certain Boy' ID
    @GetMapping("/deleteById/{idToDelete}")
    public @ResponseBody
    ResponseEntity<?> deleteBoy(@PathVariable int idToDelete) throws DataNotFoundException {
        return binaryTreeService.deleteBoy(idToDelete);
    }

    // find the father of a certain Boy' ID
    @PostMapping("/test/{cat1}")
    public @ResponseBody
    ResponseEntity<ResponseBinaryTreeDto> testCommunication(@PathVariable String cat1) {
        return new ResponseEntity<ResponseBinaryTreeDto>(new ResponseBinaryTreeDto("Hola "+cat1,
                "Successful",null), HttpStatus.OK);
    }

     */
}
