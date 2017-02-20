package com.nikhil;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Controller;
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
@Controller
public class FancyTreeController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Value("${unix.path}")
    public String unixRootPath;

    @Value("${windows.path}")
    public String windowsRootPath;

    @RequestMapping(value="/json/getChildren", method = RequestMethod.GET)
    @ResponseBody
    public String getFileTreeInfo(String parent) {

        String json;

        String rootPath = unixRootPath;

        if(OSValidator.isWindows()) {
            rootPath = windowsRootPath;
        } else {
            rootPath = unixRootPath;
        }


        if(parent.trim().isEmpty()) {
            json = getChildren(rootPath, true);
            json = '[' + json + ']';
        } else {
            json = getChildren(parent, false);
            json = json.substring(json.indexOf('['), json.lastIndexOf(']') + 1);
        }

        return json;
    }

    public String getChildren(String rootFolderPath, Boolean isRoot) {

        File rootFolder = new File(rootFolderPath);
        FancyTreeNode fancyTreeNode = new FancyTreeNode();

        if(isRoot) {
            fancyTreeNode.setId(rootFolderPath);
            fancyTreeNode.setKey(rootFolderPath);
            fancyTreeNode.setFolder(true);
            fancyTreeNode.setTitle(rootFolderPath.substring(rootFolderPath.lastIndexOf(File.separator) + 1));
        }

        LOG.info("Fetching children under " + rootFolderPath);

        File[] childFiles = rootFolder.listFiles();
        if(childFiles != null) {
            for(File childFile: childFiles) {
                if(!childFile.isHidden()) {
                    FancyTreeNodeChild fancyTreeNodeChild = new FancyTreeNodeChild();
                    if(childFile.isFile()) {
                        fancyTreeNodeChild.setFolder(false);
                        fancyTreeNodeChild.setLazy(false);
                    } else {
                        fancyTreeNodeChild.setFolder(true);
                        fancyTreeNodeChild.setLazy(true);
                    }
                    String absolutePath = childFile.getAbsolutePath();
                    String title = absolutePath.substring(absolutePath.lastIndexOf("/") + 1);
                    fancyTreeNodeChild.setId(absolutePath);
                    fancyTreeNodeChild.setKey(absolutePath);
                    fancyTreeNodeChild.setTitle(title);
                    fancyTreeNode.getChildren().add(fancyTreeNodeChild);
                }

            }
        } else {
            LOG.info("No children found under folder " + rootFolderPath);
        }

        Gson gson = new Gson();
        String json = gson.toJson(fancyTreeNode);
        return json;

    }
}
