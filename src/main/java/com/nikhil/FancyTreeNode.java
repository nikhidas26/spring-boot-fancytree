package com.nikhil;

import java.util.List;

/**
 * Created by nikhil_das23 on 2/14/17.
 */
public class FancyTreeNode {

    private String title;

    private String folder;

    private String displayPath;

    private List<FancyTreeNodeChild> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
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
