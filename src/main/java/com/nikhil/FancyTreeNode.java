package com.nikhil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhil_das23 on 2/14/17.
 */
public class FancyTreeNode {

    private String id;

    private String key;

    private String title;

    private boolean folder;

    private String size;

    private boolean lazy;

    private List<FancyTreeNodeChild> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public List<FancyTreeNodeChild> getChildren() {
        return children;
    }

    public void setChildren(List<FancyTreeNodeChild> children) {
        this.children = children;
    }

    public boolean isLazy() {
        return lazy;
    }

    public void setLazy(boolean lazy) {
        this.lazy = lazy;
    }
}
