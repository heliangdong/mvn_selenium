<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


            function AddTr() {
                $("<tr></tr>").append("<td><select id=\"id\" name=\"caseactionid\" style=\"width:150px;\">\n" +
                    "\t\t\t\t\t\t\t<option value=\"1\">前往</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"2\">定位</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"3\">发送值</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"4\">定位+点击</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"5\">线程睡2秒</option>\n" +
                    "\t\t\t\t\t\t\t<option value=\"6\">截图</option>\n" +
                    "\t\t\t\t\t\t</select></td>")
                    .append("<td><input type=\"text\" name=\"element\" class=\"easyui-validatebox\" required=\"true\"/></td>")
                    .append("<td><a class=\"easyui-linkbutton l-btn\" name=\"removetr\" data-options=\"iconCls:'icon-remove'\"><span class=\"l-btn-left\"><span class=\"l-btn-text\"><span class=\"l-btn-empty icon-remove\">&nbsp;</span></span></span></a></td>")
                    .appendTo("#dataTable")
                    .find("a[name=removetr]")
                    .click(function() {
                        RemoveTr(this);
                    });

            }

            function RemoveTr(_this) {
                var $trNode = $(_this).parent().parent();
                    $trNode.remove();
            }

    </script>
</head>

<!-- 修改窗口 -->
<%--<div class="easyui-window" title="对收派员进行添加或者修改" id="editStaffWindow" collapsible="false"--%>
     <%--minimizable="true" maximizable="true" style="">--%>
<div>
    <%--<div region="center" style="overflow:auto;padding:5px;" border="false">--%>
        <%--class="table-edit"--%>
        <form id="editStaffForm" action="TestCaseController_updateAndSave" method="post">
            <table class="table-edit" id="dataTable" width="100%" align="center" cellspacing="0">
                <tr class="title">
                    <td colspan="2">修改用例</td>
                    <td><input type="text" name="id" class="easyui-validatebox" value="${testCase.id}" style="display: none"/></td>
                    <td>操作</td>
                </tr>
                <tr >
                    <td><input type="submit" value="提交"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>用例名称</td>
                    <td><input type="text" name="name" class="easyui-validatebox" value="${testCase.name}" required="true"/></td>
                </tr>
                <tr>
                    <td><a class="easyui-linkbutton" id="addBtnBAK" onclick="AddTr()" data-options="iconCls:'icon-add'"></a>添加步骤</td>
                    <td></td>
                </tr>
                <c:forEach items="${TestCaseDetailList}" var="TestCaseDetailList">
                <tr>
                    <td><select class="easyui-combobox"  id="caseactionid" name="caseactionid" style="width:150px;">
                        <option value="1" <c:if test="${1 eq TestCaseDetailList.caseactionid}">selected</c:if>>前往</option>
                        <option value="2" <c:if test="${2 eq TestCaseDetailList.caseactionid}">selected</c:if>>定位</option>
                        <option value="3" <c:if test="${3 eq TestCaseDetailList.caseactionid}">selected</c:if>>发送值</option>
                        <option value="4" <c:if test="${4 eq TestCaseDetailList.caseactionid}">selected</c:if>>定位+点击</option>
                        <option value="5" <c:if test="${5 eq TestCaseDetailList.caseactionid}">selected</c:if>>线程睡2秒</option>
                        <option value="6" <c:if test="${6 eq TestCaseDetailList.caseactionid}">selected</c:if>>截图</option>
                    </select></td>
                    <td><input type="text" name="element" class="easyui-validatebox" required="true" value="<c:out value="${TestCaseDetailList.element}"/>"/></td>
                    <td><a class="easyui-linkbutton l-btn" onclick="RemoveTr(this)" name="removetr" data-options="iconCls:'icon-remove'"></a>
                </tr>
                </c:forEach>
            </table>
        </form>
    <%--</div>--%>
</div>
</body>
</html>