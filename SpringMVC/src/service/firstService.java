package service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-09-16.
 */
public interface firstService {

    public String first(String hello);

    public List loadTree(String id);
    public List loadTree();

    public Map query(int startNum,int pageSize ,String data,String order,String sort);
    public Map queryColumn(int type);

    public void saveSet(String data,String type);

    public List selectWhere();

    public void rmSelectWhere(String name);

    public void saveWhere(String data,String type);

}
