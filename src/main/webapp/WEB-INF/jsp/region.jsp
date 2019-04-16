<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>买卖家管理</title>
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
		// 修改
        function doEdit(rowIndex, rowData){
            var row = $('#grid').datagrid('getSelections');
            var rowone = $('#grid').datagrid('getSelected');
            if(rowone){
                var idStr=rowone.project_id;
                if(row.length!=1){
                    $.messager.alert("错误","只能选择一条数据进行修改","error");
                }else{
                    $('#editStaffWindow').window("open");
                    $("#editStaffForm").form("load",rowone);
                }
                    // window.location.href="TestCaseController_update?id="+idStr;}
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
                    ids[i]=row[i].project_id;
                }
                var idsStr=ids.join(",");
                window.location.href="ProjectController_delete?ids="+idsStr;
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
                title : '用户名称',
                width : 200,
                align : 'center'
            }, {
                field : 'jym_session_id',
                title : '登录标识',
                width : 400,
                align : 'center'
            },{
                field : 'projectname',
                title : '项目名称',
                width : 200,
                align : 'center',
                formatter : function(data,row ,index){
                    return row.project.projectname;
                }
            },{
                field : 'url',
                title : '主页url',
                width : 200,
                align : 'center'
            }, {
                field : 'ctime',
                title : '新增时间',
                width : 200,
                align : 'center'
            }, {
                field : 'utime',
                title : '更新时间',
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
                url : "CustomerController_list",
                idField : 'project_id',
                columns : columns,
                onDblClickRow : doDblClickRow
            });

            // 新增项目
            $('#addSubareaWindow').window({
                title: '新增用例',
                width: 600,
                modal: true,
                shadow: true,
                closed: true,
                height: 300,
                resizable:false
            });

            //修改窗口
            $('#editStaffWindow').window({
                title: '修改取派员',
                width: 600,
                modal: true,//遮罩效果
                shadow: true,//阴影效果
                closed: true,//关闭
                height: 300,
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
<!-- 新增 -->
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
		<form id="addSubareaForm" method="post" action="${pageContext.request.contextPath}/CustomerController_save">
			<table class="table-edit" id="dataTable" width="80%" align="center">
				<tr class="title">
					<td colspan="2">新增项目</td>
				</tr>
				<tr>
					<td>选择项目</td>
					<td>
						<input class="easyui-combobox" name="project_id"
							   data-options="valueField:'project_id',textField:'projectname',mode:'remote',
    					url:'ProjectController_list'" />
					</td>
				</tr>
				<tr>
					<td>用户名称</td>
					<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>用户标识(jym_session_id)</td>
					<td><input type="text" name="jym_session_id" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>主页url</td>
					<td><input type="text" name="url" class="easyui-validatebox" required="true"/></td>
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
						<input class="easyui-combobox" name="region.id"
							   data-options="valueField:'id',textField:'name',mode:'remote',
    							url:'RegionAction_listajax.action'" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
				</tr>
			</table>
		</form>
	</div>
</div>


<!-- 修改 -->
<div class="easyui-window" title="对收派员进行添加或者修改" id="editStaffWindow" collapsible="false"
	 minimizable="false" maximizable="false" style="top:20px;left:200px">
	<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
		<div class="datagrid-toolbar">
			<a id="edit" icon="icon-edit" href="#" class="easyui-linkbutton" plain="true" >保存</a>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$("#edit").click(function () {
                //表单校验通过，提交表单
                var v=$("#editStaffForm").form("validate");
                if(v){
                    $("#editStaffForm").submit();
                }
            });
        })
	</script>

	<div region="center" style="overflow:auto;padding:5px;" border="false">
		<form id="editStaffForm" action="CustomerController_update" method="post">
			<input type="hidden" name="id">
			<table class="table-edit" width="80%" align="center">
				<tr class="title">
					<td colspan="2">新增项目</td>
				</tr>
				<tr>
					<td>选择项目</td>
					<td>
						<input class="easyui-combobox" name="project_id"
							   data-options="valueField:'project_id',textField:'projectname',mode:'remote',
    					url:'ProjectController_list'" />
					</td>
				</tr>
				<tr>
					<td>用户名称</td>
					<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>用户标识(jym_session_id)</td>
					<td><input type="text" name="jym_session_id" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>主页url</td>
					<td><input type="text" name="url" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
</div>


</body>
</html>