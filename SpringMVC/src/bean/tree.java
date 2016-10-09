package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-22.
 */
public class tree {
    private String id ;
    private String pid;
    private String text;
    private String state;
    private List<tree> children = new ArrayList<tree>();

    public tree() {
    }

    public List<tree> getChildren() {
        return children;
    }

    public void setChildren(List<tree> children) {
        this.children = children;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "tree{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                '}';
    }
}
