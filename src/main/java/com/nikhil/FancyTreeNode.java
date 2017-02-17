package com.nikhil;

import java.util.List;

/**
 * Created by nikhil_das23 on 2/14/17.
 */
public class FancyTreeNode {

    private String key;

    private String title;

    private boolean isFolder;

    private String displayPath;

    private String size;

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

    private List<FancyTreeNodeChild> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public List<FancyTreeNodeChild> getChildren() {
        return children;
    }

    public void setChildren(List<FancyTreeNodeChild> children) {
        this.children = children;
    }

    public String getDisplayPath() {
        return displayPath;
    }

    public void setDisplayPath(String displayPath) {
        this.displayPath = displayPath;
    }
}
