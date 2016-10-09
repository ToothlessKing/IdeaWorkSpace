package service.impl;

import bean.tree;
import dao.firstDao;
import mapper.firstMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.firstService;

import java.util.*;

/**
 * Created by Administrator on 2016-09-16.
 */
@Service
public class firstServiceImpl implements firstService {
    @Autowired
    firstDao dao;

    @Autowired
    firstMapper mapper;

    @Override
    public String first(String name) {
        return mapper.getUser();
    }

    @Override
    public List loadTree(String id) {
        List<tree> list = dao.loadTree(id);

        return list;
    }

    @Override
    public List loadTree() {
        List<tree> returnlist = new ArrayList<tree>();
        List<tree> list = dao.loadTree("0");
        if(list!=null && list.size()>0){
            for(tree tree :list){
                tree node= getNode(tree);
                node.setState("open");
                returnlist.add(node);
            }
        }
        return returnlist;
    }

    @Override
    public Map query(int startNum, int pageSize, String data, String order, String sort) {
        Map map = new HashMap();
        map.put("rows",dao.query(startNum,pageSize,data,order,sort));
        map.put("total",dao.queryCount(data));
        return map;
    }

    @Override
    public Map queryColumn(int type) {
        Map map = new HashMap();
        map.put("rows",dao.queryColumn(type));
        return map;
    }

    @Override
    public void saveSet(String data, String type) {
        String[] data1 = data.split(";");
        String width="";
        for(int i=0 ;i<data1.length;i++){
            if(data1[i].split(",").length==3){
                width = "";
            }else {
                width = data1[i].split(",")[3];
            }
            dao.saveSet(data1[i].split(",")[0],width,data1[i].split(",")[1],data1[i].split(",")[2],type);
        }
    }

    @Override
    public List selectWhere() {
        return dao.selectWhere();
    }

    @Override
    public void rmSelectWhere(String name) {
        dao.rmSelectWhere(name);
    }

    @Override
    public void saveWhere(String name, String type) {
        dao.saveWhere(name,type);
    }

    public tree getNode(tree node){
        if(node==null) {
            return null;
        }
        tree treenode = new tree();
        treenode.setId(node.getId());
        treenode.setPid(node.getPid());
        treenode.setText(node.getText());
        List<tree> children = dao.loadTree(node.getId());
        if(children!=null && children.size()>0){
            treenode.setState("closed");
            for(tree child : children){
                tree childnode = getNode(child);
                if(childnode!=null){
                    treenode.getChildren().add(childnode);
                }
            }
        }
        return treenode;
    }
}
