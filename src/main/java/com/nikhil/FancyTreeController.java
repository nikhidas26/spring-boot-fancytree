package com.nikhil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 2/12/17.
 */
public class FancyTreeController {

    public String getFileTreeInfo(Boolean isRoot, String path) {

        String rootPath = "/Users/nikhil_das23";

        File rootFile = new File(rootPath);

        return null;

    }

    public void getChildren(File rootFile, Boolean isRoot) {
        String[] childFiles = rootFile.list();

        List<FancyTreeNodeChild> children = new ArrayList<>();
        if(childFiles != null) {
            for(String childFilePath: childFiles) {
                FancyTreeNodeChild fancyTreeNodeChild = new FancyTreeNodeChild();
                fancyTreeNodeChild.setFolder("false");
                fancyTreeNodeChild.setTitle(childFilePath);
                fancyTreeNodeChild.setDisplayPath(childFilePath.substring(childFilePath.indexOf("/")));
                children.add(fancyTreeNodeChild);
            }
        }



    }


}
