<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>SCOPE 2</h1>

<form action="/WebClass/scope" method="post">
<input type="text" name="id">
<input type="password" name="pwd">
<button type="submit">전송</button>
</form>

<h1>id : <%= request.getParameter("id") %></h1>
<h1>pwd : <%= request.getParameter("pwd") %></h1>
<h1>request : <%= request.getAttribute("key") %></h1>
<h1>session : <%= session.getAttribute("key") %></h1>
<h1>application : <%= application.getAttribute("key") %></h1>

<hr>
<form action="/WebClass/jsp/scop2.jsp"></form>
<button type="submit"></button>
</body>
</html>