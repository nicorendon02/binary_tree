package com.binary_tree.binary_tree.controller;

import com.binary_tree.binary_tree.controller.dto.BoyWithParentDTO;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.exception.NTreeException;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.service.NTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "ntree")
@Validated
@CrossOrigin("http://localhost:8080")
public class NTreeController {
    @Autowired
    private NTreeService nTreeService;

    @PostMapping("/{parentIdentification}")
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Boy boy, @PathVariable int parentIdentification)
            throws DataNotFoundException, NTreeException {
        return nTreeService.addBoy(boy,parentIdentification);
    }

    @PostMapping("/fill")
    public @ResponseBody
    ResponseEntity<?> fillTree(BoyWithParentDTO data)
            throws DataNotFoundException, NTreeException {
        return nTreeService.addBoy(data.getBoy(),data.getParentId());
    }

    @GetMapping("/list")
    public @ResponseBody
    ResponseEntity<?> listBoys() throws NTreeException {
        return nTreeService.listBoys();
    }
}
