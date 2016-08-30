package com.fitechsoft.domain.core;

/**
 * @author Chun Cao
 */
public class FDAction {

    private FDAction(String actName) {
        this.actName = actName;
    }

    private String actName;

    private String getActName() {
        return actName;
    }

    private void setActName(String actName) {
        this.actName = actName;
    }

    private static String ACT_CREATE = "C";
    private static String ACT_READ = "R";
    private static String ACT_UPDATE = "U";
    private static String ACT_DELETE = "D";

    public static FDAction ACTION_READ = new FDAction(ACT_READ);
    public static FDAction ACTION_CREATE = new FDAction(ACT_CREATE);
    public static FDAction ACTION_UPDATE = new FDAction(ACT_UPDATE);
    public static FDAction ACTION_DELETE = new FDAction(ACT_DELETE);

}
