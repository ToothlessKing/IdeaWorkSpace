<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-09-22
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>同步tree展示</title>
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/icon.css">
    <script src="../js/jquery-easyui-1.4/jquery.min.js"></script>
    <script src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
    <!--下面的使easyui datagrid 行拖拽插件-->
    <script src="../js/jquery-easyui-1.4/datagrid-dnd.js"></script>
    <script src="../js/common.js"></script>
    <script>
        $(function () {
            $("#tree").tree({
                url:'/loadTree2.do',
                loadFilter:function (data) {

                    for(var i=0;i<data.length;i++){
                        if(data[i].text=="1"){
                            var newData = new Array();
                            newData.push(data[i]);
                            return newData;
                        }

                    }
                    return data;
                }
            })
        })
        function getChecked() {
            var nodes = $('#tree').tree('getChecked');
            var s= '';
            for(var i=0;i<nodes.length;i++){
                if(s!='') s += ',';
                s += nodes[i].text;
            }
            alert(s);
        }

    </script>
</head>
<body>
<div>
    <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="getChecked()">获取选中内容</a>
    <input type="checkbox" checked onchange="$('#tree').tree({cascadeCheck:$(this).is(':checked')})">级联选中
    <input type="checkbox"  onchange="$('#tree').tree({onlyLeafCheck:$(this).is(':checked')})">只有叶子可选
</div>
<div class="easyui-panel">
    <ul id="tree" class="easyui-tree" data-options="lines:true,checkbox:true"></ul>
</div>
</body>
</html>
