<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
</head>
<body>
	<div>
		<form:form id="form" action="add" modelAttribute="drivercard" method="post" enctype="multipart/form-data">
			<label>驾驶证编号</label>：<form:input  path="cardNo"/>
			<form:errors path="cardNo"></form:errors>
			<br>
			<label>驾驶人姓名</label>：<form:input  path="name"/>
			<form:errors path="name"></form:errors>
			<br>
			<label>驾驶人性别</label>：
				<input type="radio" value="1">男
				&nbsp;&nbsp;&nbsp;<input type="radio" value="2">女
			<form:errors path="gender"></form:errors>
			<br>
			
			<label>驾驶人省份</label>：<form:select path="provinceId" id="provinceId"  onchange="changeProince()">
				<c:forEach items="${provinceList}" var="p">
					<option value="${p.id}">${p.name}</option>
				</c:forEach>
			</form:select>
			<form:errors path="provinceId"></form:errors>
			
			<br>
			<label>驾驶人市</label>：<form:select path="cityId"  id="cityId" onchange="changeCity()">
				
			</form:select>
			
			<form:errors path="cityId"></form:errors>
			<br>
			<label>驾驶人区县</label>：<form:select id="countyId" path="countyId" >
			</form:select>
			<form:errors path="countyId"></form:errors>
			<br>
			
			<form:errors path="cityId"></form:errors>
			<br>
			<label>驾驶人区县</label>：<form:select id="countyId" path="countyId" >
			</form:select>
			<form:errors path="countyId"></form:errors>
			<br>
			
			
			<br>
			<label>发证日期</label>：
			<form:input path="postDate" type="date"/>
			<form:errors path="postDate"></form:errors>
			<br>
			<input type="file" name="imagefile">
			<button type="submit">提交</button>
		</form:form>
	</div>
	<script type="text/javascript">
		//省发生改变 更新市的列表
		function changeProince(){
			var pid=$("#provinceId").val();
			$.post("/listArea",{pid:pid},function(data){
				$("#cityId").empty()
				alert('dd')
				 data.forEach(function(area){
					$("#cityId").append("<option value='"+area.id+"'>"+area.name+"</option>")
					}
				) //end foreach
			}
		)
		}
		
		//市发生改变 更新区县的列表
		function changeCity(){
			var pid=$("#cityId").val();
			$.post("/listArea",{pid:pid},function(data){
				$("#countyId").empty()
				//alert('dd')
				 data.forEach(function(area){
					$("#countyId").append("<option value='"+area.id+"'>"+area.name+"</option>")
					}
				) //end foreach
			}
		)
		}
		
		$("#form").validate({
		    rules: {
		    	cardNo: "required",
		      name: {
		        required: true,
		        minlength: 2
		      }
		    },//end rules
		   messages: {
			  cardNo: "请输入您的名字",
		      name: {
		        required: "请输入用户名",
		        minlength: "用户名必需由两个字母组成"
		      }
		   } // end message
		}
		)// end 函数结束
		
		   
		      
		
	</script>
</body>
</html>