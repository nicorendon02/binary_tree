package com.binary_tree.binary_tree.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NNode {
    private Boy data;
    private List<NNode> children;

    public NNode(Boy data) {
        this.data = data;

    }


    public NNode findNTreeByIdentification(int identification)
    {
        if(this.getData().getIdentification()==identification)
        {
            return this;
        }
        else
        {
            if(this.children!=null) {
                for (NNode child : children) {
                    NNode nodeFind = child.findNTreeByIdentification(identification);
                    if (nodeFind != null) {
                        return nodeFind;
                    }
                }
            }

        }
        return null;

    }

    public List<Boy> listBoys(List<Boy> listBoys)
    {
        listBoys.add(this.getData());
        if(this.children != null) {
            for (NNode boy : this.children) {
                boy.listBoys(listBoys);
            }
        }
        return listBoys;
    }
}
