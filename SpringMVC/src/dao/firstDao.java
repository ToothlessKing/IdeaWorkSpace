package dao;

import java.util.List;

/**
 * Created by Administrator on 2016-09-16.
 */
public interface firstDao {

    public  String first(String name);


    public List loadTree(String id );
    public List loadTree();

    public List query(int startNum,int pageSize,String data,String order,String sort);
    public int queryCount(String data);
    public List queryColumn(int type);

    public void saveSet(String c_name,String width,String hidden,String no,String type);
    public List selectWhere();
    public void rmSelectWhere(String name);
    public void saveWhere(String name,String data);
}
