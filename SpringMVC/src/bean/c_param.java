package bean;

/**
 * Created by Administrator on 2016-09-22.
 */
public class c_param {
    private String c_name;
    private int c_type;
    private String hidden;
    private String width;
    private String sortable;

    public c_param() {
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_type() {
        return c_type;
    }

    public void setC_type(int c_type) {
        this.c_type = c_type;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getSortable() {
        return sortable;
    }

    public void setSortable(String sortable) {
        this.sortable = sortable;
    }

    @Override
    public String toString() {
        return "c_param{" +
                "c_name='" + c_name + '\'' +
                ", c_type=" + c_type +
                ", hidden='" + hidden + '\'' +
                ", width='" + width + '\'' +
                ", sortable='" + sortable + '\'' +
                '}';
    }
}
