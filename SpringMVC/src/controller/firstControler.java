package controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.firstService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-09-16.
 */
@Controller
public class firstControler {
    @Autowired
    firstService  service;

//    @RequestMapping(value="/firstTest.do")
//    @ResponseBody
//    public String  firstTset(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
//        System.out.println("hh");
//        Gson json = new Gson();
//        json.toJson("hh");
//        return "hh";
//    }
    @RequestMapping(value="/firstTest.do")
    public void  firstTset(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("aa");
        String a = "";
        a="aa";
        a=service.first("li");
        httpServletResponse.getWriter().write(a);

    }
    //异步树
    @RequestMapping(value = "/loadTree.do")
    public void loadTree(HttpServletResponse response,HttpServletRequest request ,String id ) throws Exception{
        response.setCharacterEncoding("UTF-8");
        if(id==null){
            id = "0";
        }
        List list = new ArrayList();
        list = service.loadTree(id);
        response.getWriter().write(new Gson().toJson(list));
    }
    //同步树
    @RequestMapping(value = "/loadTree2.do")
    public void loadTree2(HttpServletResponse response,HttpServletRequest request ,String id ) throws Exception{
        response.setCharacterEncoding("UTF-8");
        List list = new ArrayList();
        list = service.loadTree();
        response.getWriter().write(new Gson().toJson(list));
    }
    //加载datagrid信息
    @RequestMapping(value = "/queryData.do")
    public void queryData(HttpServletResponse response,HttpServletRequest request ,String name ,String data,String order ,String sort,int rows,int page ) throws Exception{
        response.setCharacterEncoding("UTF-8");
        Map map = new HashMap<>();
        int pageSize = rows;
        int pageNum = page;
        int startNum = pageSize*(pageNum-1);
        System.out.println(data);
        if(!data.equals("")&&data!=null){
            data = data.replaceAll("@", "%");
        }else{
            data="";
        }
        System.out.println(data);
        map = service.query(startNum,pageSize,data,order,sort);
        if(!name.equals("")){
            //保存查询
            service.saveWhere(name,data);
        }
        response.getWriter().write(new Gson().toJson(map));
    }
    //查询表头信息
    @RequestMapping(value = "/queryDatac.do")
    public void queryColumnData(HttpServletResponse response,HttpServletRequest request ,int type ) throws Exception{
        Map map = new HashMap();
        response.setCharacterEncoding("UTF-8");
        map = service.queryColumn(type);
        response.getWriter().write(new Gson().toJson(map));
    }
    //保存列设置
    @RequestMapping(value = "/saveSet.do")
    public void saveColumnSetting(HttpServletResponse response,HttpServletRequest request ,String data,String type ) throws Exception{
        response.setCharacterEncoding("UTF-8");
        service.saveSet(data,type);
    }
    //加载下拉框信息
    @RequestMapping(value = "/selectColumn.do")
    public void loadComboboxData(HttpServletResponse response,HttpServletRequest request ,String id ) throws Exception{
        response.setCharacterEncoding("UTF-8");
        Map map = new HashMap();
        map = service.queryColumn(0);
        response.getWriter().write(new Gson().toJson(map));
    }

    // 我的查询加载
    @RequestMapping(value = "/selectWhere.do")
    public void loadMyQueryCombobox(HttpServletResponse response,HttpServletRequest request) throws Exception{
        response.setCharacterEncoding("UTF-8");
        List list = new ArrayList();
        list = service.selectWhere();
        response.getWriter().write(new Gson().toJson(list));
    }
    // 删除我的查询
    @RequestMapping(value = "/rmSelectWhere.do")
    public void removeMyQueryCombobox(HttpServletResponse response,HttpServletRequest request ,String name ) throws Exception{
        response.setCharacterEncoding("UTF-8");
        service.rmSelectWhere(name);
    }

}
