$.SpringMvc.EasyuiDemo.DataGrid = {
    type:0, // 查询类型 0为默认查询 1为自定义
    cmenu:null,//右键列头出现menu
    panelflag:0,
    init:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        //初始化数据展示表格
        _self.initDataGrid();
        //列设置对话框设置
        _self.initDialog();
        _self.changeSelect();
        _self.initInputnameDia();
        _self.initclick();
        $('#queryPanel').panel('expand',true);//panel折叠
        $('#queryPanel').panel({
            collapsed:true,
            collapsible:true,
           onBeforeExpand:function () {
               _self.myQueryCombobox();
               _self.queryConditionCombobox();
           },
           onExpand:function(){
               _self.panelflag=1;
           },
           onCollapse:function () {
               _self.panelflag=0;
           }
        });
        _self.panelclick();

    },
    /*
    数据展示 初始化datagrid
    动态加载表头
    加载分页数据
     */
    initDataGrid:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        $.getJSON('/queryDatac.do',{
            "type":_self.type
        },function(result){
            var columns = new Array();
            var option = new Array();
            for(var i=0 ;i<result.rows.length;i++){
                var column ={};
                column["title"] = result.rows[i].c_name;
                option[i]=result.rows[i].c_name;
                column["field"] = result.rows[i].c_name;
                if(result.rows[i].width!="" && result.rows[i].width != null && result.rows[i].width != "0.0"){
                        column["width"] = result.rows[i].width;
                }
                if(result.rows[i].hidden == "true"){
                    column["hidden"] =true;
                }else {
                    column["hidden"] =false;
                }
                if(result.rows[i].sortable =="true"){
                    column["sortable"]=true;
                }else {
                    column["sortable"]=false;
                }
                columns.push(column);

            }

            $("#datagrid").datagrid({
                url : "/queryData.do?data="+""+"&name="+"",
                // queryParams:{
                //     data:"",
                //     name:""
                // },
                async:false,
                pagination:true,
                singleSelect:true,
                columns :  [columns] ,
                remoteSort:true,//本地排序时为false
                multiSort:true,
                fit:true,
                rownumbers:true,
                pageSize:20,
                pageList:[20,30,40],
                toolbar : [
                    {
                        iconCls:'icon-add',
                        text: '列设置',
                        handler:function () {
                            _self.initColumnDataGrid();
                            $("#dialog").dialog('open');
                            $("#select").combobox('setValue',_self.type);
                        }
                    },{
                        iconCls:'icon-search',
                        text: '搜索',
                        handler:function () {
                            if(_self.panelflag==0){
                                $("#queryPanel").panel('expand',true);
                                _self.myQueryCombobox();
                                _self.queryConditionCombobox();
                                _self.panelflag=1;
                            }else{
                                $('#queryPanel').panel('collapse',true);
                                _self.panelflag=0;
                            }
                        }
                    }
                ],
                onHeaderContextMenu:function (e,field) {
                    e.preventDefault();
                    if(!_self.cmenu){
                        _self.createColumnMenu();
                    }
                    _self.cmenu.menu('show',{
                        left:e.pageX,
                        top:e.pageY
                    });
                },
                onLoadSuccess:function (data) {
                    //alert(data);
                    //$('#datagrid').datagrid('loadData',data);
                }
            }).datagrid('getPager').pagination({
               beforePageText :'第',
               afterPageText :'页 共{pages}页',
               displayMsg:   '共{total}条记录'
            });
        });
        // var fields = $('#datagrid').datagrid('getColumnFields');
        // for(var i=0 ;i<fields.length;i++) {
        //     var field = fields[i];
        //     var col = $('#datagrid').datagrid('getColumnOption', field);
        //     if(col.width>300){
        //         col.width=300;
        //         $('#datagrid').datagrid();
        //     }
        //
        // }
    },
    //初始化列设置弹出的对话框
    initDialog:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        $('#dialog').dialog({
            title:"列设置",
            width:500,
            height:350,
            closed:true,
            cache:false,
            modal:true,
            buttons : [{
                text : '保存',
                iconCls:'icon-ok',
                handler:function () {
                    _self.saveSet();
                }
            },{
                text:'取消'  ,
                iconCls:'icon-cancel',
                handler:function () {
                    $("#dialog").dialog('close');
                }
            }
            ]
        });

    },
    //列设置中下拉change事件
    changeSelect:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        $('#select').combobox({
           onChange:function () {
               _self.type = $('#select').combobox('getValue');
               _self.initColumnDataGrid();
           }
        });
    },
    //  保存查询条件时 输入查询名
    initInputnameDia : function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        $('#inputnameDia').dialog({
            closed:true,
            cache:false,
            modal:true,
            buttons : [{
                text : '保存',
                iconCls:'icon-ok',
                handler:function () {
                    if($('#inputnameText').textbox('getValue')==null|| $('#inputnameText').textbox('getValue')==""){
                        $.messager.alert("错误提示","名称不能为空");
                    }else {
                        var f = 0;
                        $('.myQueryCombobox option').each(function () {
                           if($(this).val()==$('#inputnameText').textbox('getValue')){
                               $.messager.alert("错误提示","名字已被使用");
                               f=1;return;
                           }
                        });
                    }
                    if(f==0){
                        $('#inputnameDia').dialog('close');
                        _self.Query($("#inputnameText").textbox('getValue'));
                    }
                }
            },{
                text:'取消'  ,
                iconCls:'icon-cancel',
                handler:function () {
                    $("#inputnameDia").dialog('close');
                }
            }
            ]
        });
    },
    //初始化列设置datagrid
    initColumnDataGrid:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        var editRow = undefined;
        $('#ColumnDataGrid').datagrid({
            url:'/queryDatac.do?type='+_self.type,
            rownumbers:true,
            fitcolumns:true,
            singleSelect:true,
            fit:true,
            columns:[[
                {
                    field : 'c_name',
                    title : '列名',
                    width : '30%'
                } ,
                {
                    field : 'hidden',
                    title : '是否隐藏',
                    width : '30%',
                    editor : {
                        type : 'combobox',
                        options : {
                            panelHeight: 50,
                            data:[
                                {"value":"false","text":"false"},
                                {"value":"true","text":"true"}
                            ],
                            valueField : 'value',
                            textField : 'text',
                        }
                    }
                },{
                    field : 'width',
                    title : '宽度(px)',
                    width : '30%',
                    editor :{
                        type: 'textbox'
                    }
                }
            ]],
            //行编辑事件
            onAfterEdit : function (rowIndex,rowData,changes) {
                editRow = undefined;
            },
            onDblClickRow : function (rowIndex,rowData) {
                if(editRow != undefined){
                    $('#ColumnDataGrid').datagrid('endEdit',editRow);
                }
                if(editRow==undefined){
                    $('#ColumnDataGrid').datagrid('beginEdit',rowIndex);
                    editRow = rowIndex;
                }
            },
            onClickRow : function (rowIndex,rowData) {
                if(editRow != undefined){
                    $('#ColumnDataGrid').datagrid('endEdit',editRow);
                }
            },
            onRowContextMenu: function (e,rowIndex,rowData) {
                if(editRow != undefined){
                    $('#ColumnDataGrid').datagrid('endEdit',editRow);
                }
            },
            onLoadSuccess:function () {
                $(this).datagrid('enableDnd');// 可拖拽设置
            }

        })
    },
    //保存列设置
    saveSet : function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        var rows = $('#ColumnDataGrid').datagrid('getRows');
        var data = "";
        for(var i=0;i<rows.length;i++){
            data += rows[i].c_name+","+rows[i].hidden+","+(i+1);
            if(rows[i].width == null){
                data += ";";
            }else{
                data += ","+ rows[i].width + ";";
            }
        }
        $.ajax({
            url: '/saveSet.do',
            async: false,
            data :{
                "type":_self.type,
                "data":data
            },
            success :function (data) {
                $('#dialog').dialog('close');
                _self.initDataGrid();
                //$('#datagrid').datagrid('reload');
            }
        })
    },
    // 新建查询中点击“+”时的操作
    newQueryCondition:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        var html = "";
        html += '<tr class="newTr trs">'+
                '<td><select class="easyui-combobox or" style="width: 50px" editable="false" panelheight="auto">' +
                        '<option value="and">并且</option>'+
                        '<option value="or">或者</option>'+
                '</select></td>'+
                '<td><select class="easyui-combobox queryConditionCombobox" style="width: 100px" editable="false" panelheight="auto">' +
                    '</select>&nbsp;' +
                    '<select class="easyui-combobox operatorCombobox" style="width: 100px" editable="false" panelheight="auto">' +
                        '<option value="like">包含</option>'+
                        '<option value="!=">不等于</option>'+
                        '<option value="=">等于</option>'+
                    '</select>'+
                '</td>'+
                '<td>' +
                    '<input type="text" class="easyui-textbox queryConditionText" style="width:100px">'+
                '</td></tr>';
        $('#queryForm').append(html);
        $.parser.parse($("tr.trs:last"));//easyui渲染
        _self.queryConditionCombobox();
    },
    //新建查询点击‘取消’的操作
    removeQueryCondition:function () {
        $('.newTr:last').remove();
    },
    // 我的查询下拉数据
    myQueryCombobox:function () {
        $.ajax({
            async:false,
            url:'/selectWhere.do',
            dataType:'json',
            success:function (data) {
                var obj = $('select.myQueryCombobox');
                obj.combobox({
                    data:data,
                    valueField:'qwhere',
                    textField:'qname'
                });
                $('select.myQueryCombobox').combobox({
                    onChange:function () {
                        var data = $('select.myQueryCombobox').combobox('getValue');
                        data = data.replace(/\%/g,"");
                        data = data.replace(/\ or /g,"  或者  ");
                        data = data.replace(/\ and /g,"  并且  ");
                        data = data.replace(/\ like /g," 包含 ");
                        $('#showMyQuerySpan').html(data);
                    }
                });
            }
        });
    },
    //加载新建查询中下拉框数据
    queryConditionCombobox:function(){
        $.ajax({
            async:false,
            url:'/selectColumn.do',
            dataType:'json',
            success:function (data) {
                var obj = $("select.queryConditionCombobox:last");
                obj.combobox({
                    data:data.rows,
                    valueField:'c_name',
                    textField:'c_name'
                });
            }
        });
    },
    //新建查询中的查询操作
     Query:function (name) {
         var _self = $.SpringMvc.EasyuiDemo.DataGrid;
         var data="";
         var f=0;
         $(".trs").each(function () {
            if($(this).find(".queryConditionCombobox").combobox('getValue')==null||$(this).find('.queryConditionCombobox').combobox('getValue')==""){
                $.messager.alert("错误提示","条件信息不为空");
                f = 1;
                return;
            }
            if($(this).find(".or").length>0){
                data += $(this).find(".or").combobox('getValue');
            }
            data += " "+
                    $(this).find(".queryConditionCombobox").combobox('getValue')+" "+
                    $(this).find(".operatorCombobox").combobox('getValue')+" ";
            if($(this).find(".operatorCombobox").combobox('getValue')=="like"){
                data += " '@"+
                        $(this).find(".queryConditionText").textbox('getValue')+
                        "@' ";
            }else {
                data += " '"+
                        $(this).find('.queryConditionText').textbox('getValue')+
                        "' ";
            }
         }
         );
         if(f==1){
             return;
         }
         $('#datagrid').datagrid({
             url: '/queryData.do?name='+name+'&data='+data,
             onLoadSuccess:function () {
                 _self.myQueryCombobox();
             }
         });

     },
    queryByMyQuery:function () {
        var data = $('.myQueryCombobox').combobox('getValue');
        data = data.replace(/\%/g,"@");
        alert(data);
        // $('#datagrid').datagrid('load',{"data":"hh"});
        $('#datagrid').datagrid({
            url:'/queryData.do?name='+''+'&data='+data,
        });
    },
    removeMyQuery:function(){
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        var name = $('.myQueryCombobox').combobox('getText');
        $.ajax({
            async:false,
            url:'/rmSelectWhere.do',
            data:{
                "name":name
            },
            success:function (data) {
                _self.myQueryCombobox();
            }
        });
    },
    saveNewQuery:function () {
        $('#inputnameDia').dialog('open');
    },
    initclick:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        $('#queryByMyQueryBtn').unbind("click").click(function () {
            _self.queryByMyQuery();
        });
        $('#removeMyQueryBtn').unbind('click').click(function(){
            _self.removeMyQuery();
        });
        $('#newQueryConditionBtn').unbind('click').click(function () {
            _self.newQueryCondition();
        });
        $('#QueryBtn').click(function () {
            _self.Query('');
        });
        $('#saveNewQueryBtn').click(function () {
            _self.saveNewQuery();
        });
        $('#removeQueryConditionBtn').click(function () {
            _self.removeQueryCondition();
        });


    },
    //easyui 中文网上的列隐藏
    createColumnMenu:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;
        _self.cmenu = $('<div/>').appendTo('body');
        _self.cmenu.menu({
           onClick:function (item) {
               if(item.iconCls=='icon-ok'){
                   $('#datagrid').datagrid('hideColumn',item.name);
                   _self.cmenu.menu('setIcon',{
                       target:item.target,
                       iconCls:'icon-empty'
                   });
               }else {
                   $('#datagrid').datagrid('showColumn',item.name);
                   _self.cmenu.menu('setIcon',{
                       target:item.target,
                       iconCls:'icon-ok'
                   });
               }
           }
        });
        var fields = $('#datagrid').datagrid('getColumnFields');
         for(var i=0 ;i<fields.length;i++){
             var field = fields[i];
             var col = $('#datagrid').datagrid('getColumnOption',field);
             if(col.hidden==true){
                 _self.cmenu.menu('appendItem',{
                     text:col.title,
                     name:field,
                     iconCls:'icon-empty'
                 });
             }else {
                 _self.cmenu.menu('appendItem',{
                     text:col.title,
                     name:field,
                     iconCls:'icon-ok'
                 });
             }
         }
    },
    panelclick:function () {
        var _self = $.SpringMvc.EasyuiDemo.DataGrid;

        $(".panel-title").click(function () {
            if(_self.panelflag==1){
                $("#queryPanel").panel('collapse',true);
                _self.panelflag=0;
            }
            else {
                $('#queryPanel').panel("expand",true);
                _self.panelflag=1;
            }
        })
    }


}
