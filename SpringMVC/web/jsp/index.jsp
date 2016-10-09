<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-09-22
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring + Easyui功能展示</title>
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.4/themes/icon.css">
    <link rel="stylesheet" href="../css/index.css">
    <script src="../js/jquery-easyui-1.4/jquery.min.js"></script>
    <script src="../js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
    <!--下面的使easyui datagrid 行拖拽插件-->
    <script src="../js/jquery-easyui-1.4/datagrid-dnd.js"></script>
    <script src="../js/index.js"></script>
</head>
<body class="easyui-layout">
<!-- begin of header -->
<div class="wu-header"  style="background-color: #0070a9" data-options="region:'north',border:false,split:true">
    <div class="wu-header-left">
        <h1 style="font-style: inherit">SSM+ Easyui功能展示</h1>
    </div>
    <div class="wu-header-right">
        <p><strong id="showuser"  ></strong>，欢迎您！</p>
        <p><a href="#" id="dd">【帮助中心】</a>|<a href="#" onclick="addTab('密码修改','Repass.html','icon-users',1);" >【修改密码】</a>|<a href="#" onclick="exit1()">【安全退出】</a></p>
    </div>
</div>
<!-- end of header -->
<!-- begin of sidebar -->
<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"  style="overflow:hidden;">
    <div class="easyui-accordion" data-options="border:false,fit:false,multiple:true">
        <!-- <div title="基本功能" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="Customer.html" iframe="1">客户管理</a></li>
                <li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="House.html" iframe="1">房源管理</a></li>
                <li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="Hetong.html" iframe="1">合同管理</a></li>
            </ul>
        </div> -->
        <div title="DataGrid展示" data-options="iconCls:'icon-application-form-edit'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="DataGrid.jsp" iframe="1">数据展示</a></li>
            </ul>
        </div>
        <div title="Tree展示" data-options="iconCls:'icon-cart'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="tree.jsp" iframe="1">异步树展示</a></li>
                <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="tree2.jsp" iframe="1">同步树展示</a></li>
            </ul>
        </div>
        <div title="TreeGrid展示" data-options="iconCls:'icon-creditcards'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="treeTable.jsp" iframe="1">异步树表</a></li>
                <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="treeTable2.jsp" iframe="1">同步树表</a></li>
            </ul>
        </div>


    </div>
</div>
<!-- end of sidebar -->
<!-- begin of main -->
<div class="wu-main" data-options="region:'center'">
    <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true" style="overflow: hidden">
        <div title="首页" > <iframe id="menuFrame" name="menuFrame" src="main.jsp" style="overflow:hidden;"
                                  scrolling="yes" frameborder="no" width="100%" height="100%"></iframe></div>
    </div>
</div>
<!-- end of main -->
<!-- begin of footer -->
<div class="wu-footer" data-options="region:'south',border:true,split:true">
    &copy; 2016 liqijin All Rights Reserved
</div>
<div id="tab_rightmenu" class="easyui-menu" style="width:120px; display:none">
    <div name="tab_menu-tabcloseall" id="closeAll">
        关闭全部标签
    </div>

    <div name="tab_menu-tabcloseother" id="closeOthor">
        关闭其他标签
    </div>

    <div class="menu-sep"></div>

    <div name="tab_menu-tabcloseright" id="closeRight">
        关闭右侧标签
    </div>
    <div name="tab_menu-tabcloseleft" id="closeLeft">
        关闭左侧标签
    </div>
</div>
<!-- end of footer -->
<script type="text/javascript">

</script>
</body>
</html>
