<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="number" name="num" required>
<button type="submit">계산</button>
</form>
<%
	if(request.getParameter("num")!=null)
	{
		int input = Integer.parseInt(request.getParameter("num"));
		int result = 0;
		for(int i=1; i<=input; i++)
		{
			result += i;
		}	
%>
<h1>1부터 <%=input%>까지의 합은 <%=result%>입니다.</h1>
<%

	}

	//현재 날짜 구하기
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

%>
현재 시각은 <%= sdf.format(new Date()) %>
</body>
</html>