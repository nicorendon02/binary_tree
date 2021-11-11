package com.binary_tree.binary_tree.controller.dto;

import com.binary_tree.binary_tree.model.Boy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoyWithParentDTO {
    private Boy boy;
    private int parentId;
}
