<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-09-22
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步treeTable展示</title>
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/icon.css">
    <script src="../js/jquery-easyui-1.4/jquery.min.js"></script>
    <script src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
    <!--下面的使easyui datagrid 行拖拽插件-->
    <script src="../js/jquery-easyui-1.4/datagrid-dnd.js"></script>
    <script src="../js/common.js"></script>
</head>
<body>
    <table id="table" style="width: 300px" class="easyui-treegrid"
           data-options="lines:true,
                         url:'/loadTree.do',
                         rownumbers:true,
                         fitColumns:true,

                         idField:'id',
                         treeField:'text',
                        ">
        <thead>
            <tr>
                <th data-options="field:'text'">text</th>
                <th data-options="field:'id'">id</th>
                <th data-options="field:'state'">state</th>
                <th data-options="field:'pid'">pid</th>
            </tr>
        </thead>

    </table>
</body>
</html>
