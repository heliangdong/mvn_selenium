<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试用例管理</title>
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
            $('#addSubareaWindow').window("open");
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
                window.location.href="TestCaseController_deletes?ids="+idsStr;
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
        var toolbar = [ {
            id : 'button-search',
            text : '查询',
            iconCls : 'icon-search',
            handler : doSearch
        }, {
            id : 'button-add',
            text : '增加',
            iconCls : 'icon-add',
            handler : doAdd
        }, {
            id : 'button-edit',
            text : '修改',
            iconCls : 'icon-edit',
            handler : doEdit
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
                align : 'center'
            }, {
                field : 'status',
                title : '状态',
                width : 100,
                align : 'center',
                formatter : function(data,row, index){
                    if(data=="0"){
                        return "无效"
                    }else{
                        return "正常";
                    }
                }
            } , {
                field : 'ctime',
                title : '创建时间',
                width : 130,
                align : 'center',
                formatter:function(value,row,index){
                    var unixTimestamp = new Date(value);
                    return unixTimestamp.toLocaleString();}
            } , {
                field : 'utime',
                title : '更新时间',
                width : 130,
                align : 'center',
                formatter:function(value,row,index){
                    var unixTimestamp = new Date(value);
                    return unixTimestamp.toLocaleString();}
            }, {
                field : 'Remarks',
                title : '备注',
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
                url : "TestCaseController_list",
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

            // 查询窗口
            $('#searchWindow').window({
                title: '查询分区',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 200,
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
<!-- 添加 修改分区 -->
<div class="easyui-window" title="分区添加修改" id="addSubareaWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
	<div style="height:31px;" split="false" border="false" >
		<div class="datagrid-toolbar">
			<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			<script type="text/javascript">
                $(function(){
                    $("#save").click(function(){
                        //表单校验
                        var r = $("#addSubareaForm").form('validate');
                        if(r){
                            $("#addSubareaForm").submit();
                        }
                    });
                });
			</script>
		</div>
	</div>

	<div style="overflow:auto;padding:5px;" border="false">
		<form id="addSubareaForm" method="post" action="${pageContext.request.contextPath}/TestCaseController_save">
			<table class="table-edit" id="dataTable" width="80%" align="center">
				<tr class="title">
					<%--<td colspan="2">新增用例</td>--%>
					<td>新增用例</td>
					<td>值</td>
					<td>操作</td>
				</tr>
				<tr>
					<td>选择项目</td>
					<td>
						<input class="easyui-combobox" name="projectid"
							   data-options="valueField:'project_id',textField:'projectname',mode:'remote',
    					url:'ProjectController_list'" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td>用例名称</td>
					<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					<td></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" id="addBtn" data-options="iconCls:'icon-add'"></a>添加步骤</td>
					<td></td>
				</tr>
				<tr>
					<td><select id="id" name="id" style="width:150px;">
						<option value="1">前往</option>
						<option value="2">定位</option>
						<option value="3">发送值</option>
					</select>
					</td>
					<td><input type="text" name="element" class="easyui-validatebox" required="true"/></td>
					<td><a class="easyui-linkbutton" id="addBtn" data-options="iconCls:'icon-remove'"></a></td>
				</tr>
			</table>
		</form>
	</div>
</div>
<!-- 查询分区 -->
<div class="easyui-window" title="查询分区窗口" id="searchWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
	<div style="overflow:auto;padding:5px;" border="false">
		<form id="searchForm">
			<table class="table-edit" width="80%" align="center">
				<tr class="title">
					<td colspan="2">查询条件</td>
				</tr>
				<tr>
					<td>选择项目</td>
					<td>
						<input class="easyui-combobox" name="projectid"
							   data-options="valueField:'project_id',textField:'projectname',mode:'remote',
    					url:'ProjectController_list'" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
				</tr>
			</table>
		</form>
	</div>
</div>


</body>
</html>