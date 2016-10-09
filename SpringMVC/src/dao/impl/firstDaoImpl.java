package dao.impl;

import bean.c_param;
import bean.help_topic;
import bean.tree;
import bean.userQuery;
import dao.firstDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-09-16.
 */
@Repository
public class firstDaoImpl implements firstDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate  jdbcTemplate){
        jdbcTemplate = this.jdbcTemplate;
    }
    public JdbcTemplate  getJdbcTemplate(){
        return  jdbcTemplate;
    }
    @Override
    public String first(String name) {
        String sql = "select User from user where Host = 'localhost'";
        String user = String.valueOf(jdbcTemplate.queryForList(sql));
        return user ;
    }

    @Override
    public List loadTree(String id) {
       //String sql= "select * from tree ";
        String sql= "select * from tree where pid = "+ id;


        return jdbcTemplate.query(sql,new treeMapper());
    }

    @Override
    public List loadTree() {
        return null;
    }

    @Override
    public List query(int startNum, int pageSize, String data, String order, String sort) {
        String orderby = "";
        if(sort!=null&&sort.split(",").length>0){
            String[] sorts = sort.split(",");
            String[] orders =order.split(",");
            orderby = " order by ";
            for(int i=0 ;i<sorts.length;i++){
                if (i==0){
                    orderby += sorts[i] + " "+orders[i];
                }else{
                    orderby += "," + sorts[i] + " " +orders[i];
                }
            }
        }
        String sql = "";
        System.out.println(data);
        if(data.equals("")){
            sql = "select * from help_topic " + orderby + " limit "+ startNum + "," +pageSize;
        }else {
            sql = "select * from help_topic where " +data +" " + orderby + " limit "+startNum + ","+pageSize;
        }
        System.out.println(sql);
        return jdbcTemplate.query(sql,new helpMapper());
    }

    @Override
    public int queryCount(String data) {
        String sql ="";
        if(data.equals("")){
            sql = "select count(*) from help_topic";
        }else {
            sql = "select count(*) from help_topic where " +data;
        }
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List queryColumn(int type) {
        String sql = "select * from c_param where c_type = "+ type + " order by c_no";
        return jdbcTemplate.query(sql,new paramMapper());
    }

    @Override
    public void saveSet(String c_name, String width, String hidden, String no, String type) {
        String sql = "update c_param set width='"+width+"',hidden='"+hidden+"',c_no="+no+ " where c_type='"+type+"' and c_name='"+c_name+"'";
        jdbcTemplate.update(sql);
    }

    @Override
    public List selectWhere() {
        String sql = "select * from userquery";
        return jdbcTemplate.query(sql,new selectMapper());
    }

    @Override
    public void rmSelectWhere(String name) {
        String sql = "delete from userquery where qname='"+name+"'";
    }

    @Override
    public void saveWhere(String name, String data) {
        String sql = "insert into userquery values(\""+name+"\",\""+data+"\")";
        jdbcTemplate.execute(sql);
    }

    class treeMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            tree tree =new tree();
            tree.setId(rs.getString("id"));
            tree.setPid(rs.getString("pid"));
            tree.setText(rs.getString("text"));
            if(countTree(rs.getString("id"))>0){
                tree.setState("closed");
            }
            return tree;
        }
    }
    class  helpMapper implements  RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            help_topic help_topic = new help_topic();
            help_topic.setDescription(rs.getString("description"));
            help_topic.setExample(rs.getString("example"));
            help_topic.setHelp_category_id(rs.getString("help_category_id"));
            help_topic.setHelp_topic_id(rs.getInt("help_topic_id"));
            help_topic.setName(rs.getString("name"));
            help_topic.setUrl(rs.getString("url"));
            return help_topic;
        }
    }
    class paramMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            c_param param = new c_param();
            param.setC_name(rs.getString("c_name"));
            param.setC_type(rs.getInt("c_type"));
            param.setHidden(rs.getString("hidden"));
            param.setSortable(rs.getString("sortable"));
            param.setWidth(rs.getString("width"));
            return param;
        }
    }
    class selectMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            userQuery userQuery = new userQuery();
            userQuery.setQname(rs.getString("qname"));
            userQuery.setQwhere(rs.getString("qwhere"));
            return userQuery;
        }
    }
    public int countTree(String id ){
        String sql = "select count(*) from tree where pid = "+id;
        return jdbcTemplate.queryForObject(sql,Integer.class);

    }



}
