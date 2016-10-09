<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-09-22
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>easyui-datagrid 展示</title>
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/icon.css">
    <link rel="stylesheet" href="../css/dataGrid.css">
    <script src="../js/jquery-easyui-1.4/jquery.min.js"></script>
    <script src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
    <!--下面的使easyui datagrid 行拖拽插件-->
    <script src="../js/jquery-easyui-1.4/datagrid-dnd.js"></script>
    <script src="../js/common.js"></script>
    <script src="../js/dataGrid.js"></script>
    <script>
        $(function(){
            $.SpringMvc.EasyuiDemo.DataGrid.init();
        })
    </script>
</head>
<body>
    <div id="queryPanel" class="easyui-panel" data-options="title:'搜索',collapsed:true,collapsible:true">
        <table cellpadding="5" id="queryForm">
            <tr>
                <td>
                     我的查询：
                    <select class="easyui-combobox myQueryCombobox"  style="width:100px"  panelheight="auto" id=""></select>
                </td>
                <td>
                    <a href="#" id="queryByMyQueryBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查找</a>
                    <a href="#" id="removeMyQueryBtn" class="easyui-linkbutton" data-options="iconCls:'icon-remove'"></a>
                </td>
                <td></td>
                <td><span id="showMyQuerySpan"></span></td>
            </tr>
            <tr class="trs">
                <td>新建查询：</td>
                <td>
                    <select class="easyui-combobox queryConditionCombobox" editable="false" panelheight="auto" style="width: 100px">
                    </select>
                    <select class="easyui-combobox operatorCombobox" editable="false" panelheight="auto" style="width: 100px">
                        <option value="like">包含</option>
                        <option value="=">等于</option>
                        <option value="!=">不等于</option>
                    </select>
                </td>
                <td><input type="text" class="easyui-textbox queryConditionText" style="width: 100px"></td>
                <td>
                    <a href="#" id="newQueryConditionBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'"></a>
                    <a href="#" id="QueryBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">查询</a>
                    <a href="#" id="saveNewQueryBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存并查询</a>
                    <a href="#" id="removeQueryConditionBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">取消</a>
                </td>
            </tr>
        </table>
    </div>
    <div id="divgrid" style="width: auto;height:600px">
        <table id="datagrid"></table>
    </div>
    <div id="dialog" class="easyui-dialog">
        <span>列设置：</span>
        <select id="select" class="easyui-combobox" panelheight="50">
            <option value="0">默认</option>
            <option value="1">自定义</option>
        </select>
        <table id="ColumnDataGrid"></table>
    </div>
    <div id="inputnameDia" class="easyui-dialog">
        请输入查询标题：
        <input type="text" class="easyui-textbox" id="inputnameText">
    </div>
</body>
</html>
