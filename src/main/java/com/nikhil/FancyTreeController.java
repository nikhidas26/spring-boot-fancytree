package com.nikhil;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 2/12/17.
 */
public class FancyTreeController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/json/getChildren", method = RequestMethod.GET)
    @ResponseBody
    public String getFileTreeInfo(String isRoot, String path) {

        String json;
        String rootPath = "/Users/nikhil_das23";

        File rootFile = new File(rootPath);

        return null;

    }

    public String getChildren(String rootFolderPath, Boolean isRoot) {

        File rootFolder = new File(rootFolderPath);
        FancyTreeNode fancyTreeNode = new FancyTreeNode();

        if(isRoot) {
            fancyTreeNode.setFolder(false);
            fancyTreeNode.setKey(rootFolderPath);
            fancyTreeNode.setFolder(true);
            fancyTreeNode.setTitle(rootFolderPath.substring(rootFolderPath.indexOf("/")));
            fancyTreeNode.setDisplayPath(rootFolderPath.substring(rootFolderPath.indexOf("/")));
        }

        LOG.info("Fetching children under " + rootFolderPath);

        String[] childFiles = rootFolder.list();
        if(childFiles != null) {
            for(String childFilePath: childFiles) {
                FancyTreeNodeChild fancyTreeNodeChild = new FancyTreeNodeChild();
                File child = new File(childFilePath);
                if(child.isFile()) {
                    fancyTreeNodeChild.setFolder(true);
                } else {
                    fancyTreeNodeChild.setFolder(false);
                }
                fancyTreeNodeChild.setKey(child.getAbsolutePath());
                fancyTreeNodeChild.setTitle(childFilePath.substring(childFilePath.indexOf("/")));
                fancyTreeNodeChild.setDisplayPath(childFilePath.substring(childFilePath.indexOf("/")));
                fancyTreeNode.getChildren().add(fancyTreeNodeChild);
            }
        } else {
            LOG.info("No children found under folder " + rootFolderPath);
        }

        Gson gson = new Gson();
        String json = gson.toJson(fancyTreeNode);
        return json;

    }
}
