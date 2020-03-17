<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户录入界面</title>

<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

</head>
<body>
		<form action="${APP_PATH}/customer/save" method="post">
			客户姓名：<input type="text" name="name"/><br/>
			客户性别：
				<input type="radio" name="gender" value="男"/>男
				<input type="radio" name="gender" value="女"/>女
				<br/>
			客户手机：<input type="text" name="telephone"/><br/>
			客户地址：<input type="text" name="address"/><br/>
			<input type="submit" value="保存"/>
		</form>
</body>
</html>