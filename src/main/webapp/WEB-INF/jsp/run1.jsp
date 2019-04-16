<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>运行池</title>
	<!-- 导入jquery核心类库 -->
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<!-- 导入easyui类库 -->
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/css/default.css">
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
	<script
			src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
			type="text/javascript"></script>
	<script type="text/javascript">

        $(function(){

            $("#addBtn").live("click",function(){
                var number = $("#dataTable tr").length;
                var addRow = "<tr>\t\t\t\t\t<td><select id=\"id\" name=\"id\" style=\"width:150px;\">\n" +
                    "\t\t\t\t\t\t\t<option value=\"1\">前往</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"2\">定位</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"3\">发送值</option>\n" +
                    "\t\t\t\t\t\t</select>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td><input type=\"text\" name=\"element\" class=\"easyui-validatebox\" required=\"true\"/></td></tr>";
                $("#dataTable").append(addRow);
            });
        });

        function doAdd(){
            window.location.href="${pageContext.request.contextPath}/run_add";
        }

        function doEdit(rowIndex, rowData){
            var row = $('#grid').datagrid('getSelections');
            var rowone = $('#grid').datagrid('getSelected');
            if(rowone){
                var idStr=rowone.id;
                if(row.length!=1){
                    $.messager.alert("错误","只能选择一条数据进行修改","error");
                }else{
                    window.location.href="TestCaseController_update?id="+idStr;}
            }else{
                $.messager.alert("错误","没有选中行","error");
            }


            // $('#editStaffWindow').window("open");
            // $("#editStaffForm").form("load",rowData);
        }

        function doDelete(){
            var row=$("#grid").datagrid('getSelections');
            //声明一个数组用于存储id
            var ids=new Array();
            if(row.length==0){
                $.messager.alert("错误","必须选中一条以上的数据进行删除","error");
            }else{
                for(var i=0;i<row.length;i++){
                    ids[i]=row[i].id;
                }
                var idsStr=ids.join(",");
                window.location.href="OperationPoolController_delete?ids="+idsStr;
            }
        }

        function doRun(){
            var row=$("#grid").datagrid('getSelections');
            //声明一个数组用于存储id
            var ids=new Array();
            if(row.length==0){
                $.messager.alert("错误","必须选中一条以上的数据进行运行","error");
            }else{
                for(var i=0;i<row.length;i++){
                    ids[i]=row[i].id;
                }
                var idsStr=ids.join(",");
                window.location.href="SeleniumController_run?ids="+idsStr;
            }
        }

        function doSearch(){
            $('#searchWindow').window("open");
        }

        function doExport(){
            window.location.href="SubareaAction_exportXls.action";
        }

        function doImport(){
            alert("导入");
        }

        //工具栏
        var toolbar = [
		 {
            id : 'button-add',
            text : '增加用例',
            iconCls : 'icon-add',
            handler : doAdd
        },{
                id : 'button-run',
                text : '运行用例',
                iconCls : 'icon-reload',
                handler : doRun
         },{
            id : 'button-delete',
            text : '删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        },{
            id : 'button-import',
            text : '导入',
            iconCls : 'icon-redo',
            handler : doImport
        },{
            id : 'button-export',
            text : '导出',
            iconCls : 'icon-undo',
            handler : doExport
        }];
        // 定义列
        var columns = [ [
            {
                field : 'id',
                checkbox : true,
            },{
                field : 'name',
                title : '用例名称',
                width : 200,
                align : 'center'
            },{
                field : 'projectname',
                title : '项目名称',
                width : 200,
                align : 'center',
                formatter : function(data,row ,index){
                    return row.project.projectname;
                }
            }, {
                field : 'ctime',
                title : '创建时间',
                width : 130,
                align : 'center'
            }, {
                field : 'status',
                title : '结果',
                width : 100,
                align : 'center',
                formatter : function(data,row, index){
                    if(row.result=="0"){
                        return "未运行"
                    }
                    if(row.result=="1"){
                        return "成功";
                    }else {
                        return "失败";
					}
                }
            } , {
                field : 'lastruntime',
                title : '最后运行时间',
                width : 130,
                align : 'center'
            }, {
                field : 'Operator',
                title : '操作人',
                width : 130,
                align : 'center'
            } , {
                field : 'Remarks',
                title : '操作',
                width : 200,
                align : 'center'
            } ] ];



        $(function(){
            //先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({visibility:"visible"});

            // 收派标准数据表格
            $('#grid').datagrid( {
                iconCls : 'icon-forward',
                fit : true,
                border : true,
                rownumbers : true,
                striped : true,
                pageList: [30,50,100],
                pagination : true,
                toolbar : toolbar,
                url : "OperationPoolController_list",
                idField : 'id',
                columns : columns,
                onDblClickRow : doDblClickRow
            });

            // 新增用例
            $('#addSubareaWindow').window({
                title: '新增用例',
                width: 600,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            // 查询分区
            $('#searchWindow').window({
                title: '查询分区',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            //定义一个工具方法，用于将指定的form表单中所有的输入项转为json数据{key:value,key:value}
            $.fn.serializeJson=function(){
                var serializeObj={};
                var array=this.serializeArray();
                $(array).each(function(){
                    if(serializeObj[this.name]){
                        if($.isArray(serializeObj[this.name])){
                            serializeObj[this.name].push(this.value);
                        }else{
                            serializeObj[this.name]=[serializeObj[this.name],this.value];
                        }
                    }else{
                        serializeObj[this.name]=this.value;
                    }
                });
                return serializeObj;
            };

            $("#btn").click(function () {
                var p=$("#searchForm").serializeJson();
                console.info(p);
                $("#grid").datagrid("load",p);
                $("#searchWindow").window("close");
            });
        });

        function doDblClickRow(){
            alert("双击表格数据...");
        }







	</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
	<table id="grid"></table>
</div>



</body>
</html>