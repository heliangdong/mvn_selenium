<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试专区</title>
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
        function RemoveTr(_this) {
            var $trNode = $(_this).parent().parent();
            var textContext = $trNode.find("td:first").text().trim();
            var flag = confirm("确定删除\"" + textContext + "\"吗？");
            if (flag) {
                $trNode.remove();
            }
        }

        function AddTr() {
            $("<tr></tr>").append("<td>新增</td>")
                .append("<td>16</td>")
                .append("<td>13067899999</td>")
                .append("<td><input type=\"text\" name=\"address\" value=\"\"/></td>")
                .append("<td><a name=\"removetr\">删除</a></td>")
                .appendTo("#datalist")
                .find("a[name=removetr]")
                .click(function() {
                    RemoveTr(this);
                });

		}

	</script>
	<style type="text/css">
		table {
			border-collapse: collapse;
		}

		td {
			border: 1px solid #000000;
			padding: 5px 5px;
			text-align: center;
		}
	</style>
	<div>
		<input type="button" id="btnAddTr" onclick="AddTr()" value="添加行"/>
		<input type="button" id="btnSave" onclick="SaveInfo()" value="保存"/>
		<table id="firsttb">
			<thead>
			<tr>
				<td>姓名</td>
				<td>年龄</td>
				<td>联系方式</td>
				<td>地址</td>
				<td>操作</td>
			</tr>
			</thead>
			<tbody id="datalist">
			<tr>
				<td>蝈蝈</td>
				<td>18</td>
				<td>18233177777</td>
				<td><input type="text" name="address" value="" /></td>
				<td><a name="removetr" onclick="RemoveTr(this)">删除</a></td>
			</tr>
			<tr>
				<td>果果</td>
				<td>16</td>
				<td>18233188888</td>
				<td><input type="text" name="address" value="" /></td>
				<td><a name="removetr" onclick="RemoveTr(this)">删除</a></td>
			</tr>
			<tr>
				<td>郭郭</td>
				<td>18</td>
				<td>18233199999</td>
				<td><input type="text" name="address" value="" /></td>
				<td><a name="removetr" onclick="RemoveTr(this)">删除</a></td>
			</tr>
			</tbody>
		</table>
	</div>

</html>