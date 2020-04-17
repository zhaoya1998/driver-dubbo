<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/index_work.css" />
<link href="<%=request.getContextPath()%>/css/index_work.css"
	rel="stylesheet">
<!-- 引入样式 -->
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
   function add() {
	location="toAdd";
}
   function update(id) {
		location="toUpdate?id="+id;
	}
</script>
</head>
<body>
<form action="list" method="post">
<input type="button" value="增加" onclick="add()">
   司机姓名:<input type="text" name="name">
   <input type="submit" value="查询"> 
</form>
	<table class="table">
		<tr>
			<td>驾驶证号码</td>
			<td>司机姓名</td>
			<td>性别</td>
			<td>省</td>
			<td>市</td>
			<th>区</th>
			<td>发证日期</td>
			<td>违章条数</td>
		</tr>
		<c:forEach items="${info.list }" var="d">
			<tr>
				<td>${d.cardNo }</td>
				<td>${d.name }</td>
				<td>${d.gender }</td>
				<td>${d.province.name }</td>
				<td>${d.city.name }</td>
				<td>${d.county.name }</td>
				<td>${d.postDate }</td>
				<td>
				 <input type="button" onclick="update(${d.id})" value="修改"/>
				</td>
			</tr>
		</c:forEach>

		<tr align="center">
			<td colspan="100">当前是${info.pageNum}/${info.pages }页--共${info.total }条数据
				<a href="list?pageNum=1">首页</a> <a
				href="list?pageNum=${info.prePage }">上一页</a> <a
				href="list?pageNum=${info.nextPage }">下一页</a> <a
				href="list?pageNum=${info.pages }">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>