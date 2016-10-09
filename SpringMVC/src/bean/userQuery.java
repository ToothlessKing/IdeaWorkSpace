package bean;

/**
 * Created by Administrator on 2016-09-23.
 */
public class userQuery {
    private String qname;
    private String qwhere;

    public userQuery() {
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQwhere() {
        return qwhere;
    }

    public void setQwhere(String qwhere) {
        this.qwhere = qwhere;
    }

    @Override
    public String toString() {
        return "userQuery{" +
                "qname='" + qname + '\'' +
                ", qwhere='" + qwhere + '\'' +
                '}';
    }
}
