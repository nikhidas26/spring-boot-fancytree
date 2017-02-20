package com.nikhil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Author: Domenico Monaco, Yong Mook Kim
 *
 * Source: https://gist.github.com/kiuz/816e24aa787c2d102dd0
 *
 * License: GNU v2 2014
 *
 * Fork / Learned: http://www.mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/
 *
 */
public class OSValidator {

    private static final Logger LOG = LoggerFactory.getLogger(OSValidator.class);

    private static String OS = System.getProperty("os.name").toLowerCase();


    public static boolean isWindows() {
        LOG.info("Operating System: Windows");
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        LOG.info("Operating System: Mac");
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        LOG.info("Operating System: Unix");
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isSolaris() {
        LOG.info("Operating System: Solaris");
        return (OS.indexOf("sunos") >= 0);
    }
    public static String getOS(){
        if (isWindows()) {
            return "win";
        } else if (isMac()) {
            return "osx";
        } else if (isUnix()) {
            return "uni";
        } else if (isSolaris()) {
            return "sol";
        } else {
            return "err";
        }
    }

}
