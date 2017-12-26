<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="org.dimigo.api.API" %>
<%@ page import="org.dimigo.api.Player" %>
<%@ page import="org.dimigo.vo.UserVO" %>
<%@ page import="java.util.Map" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Insert title here</title>
<script>
function menu_over(e) {
	e.setAttribute("class", "nav-item active");
}
function menu_out(e) {
	e.setAttribute("class", "nav-item");
}

</script>
</head>
<body>
<%	if (((UserVO)session.getAttribute("user")).getTeamName() == null) { %>
	<jsp:forward page="/jsp/subscribe.jsp"></jsp:forward>
<% }
%>
	<%@ include file="menu.jsp" %>

<%
	String teamName = ((UserVO)session.getAttribute("user")).getTeamName();
	String dailySchedule = API.parseDailySchedule(teamName);
	if(!"None".equals(dailySchedule)) {
	String gameId = dailySchedule.substring(dailySchedule.indexOf(":") + 1, dailySchedule.length());
	String dailyScore = API.parseBoxScore(gameId, teamName);
	String rightTeamName = dailySchedule.substring(0, dailySchedule.indexOf(":"));
	String leftTeamScore = dailyScore.substring(0, dailyScore.indexOf(":"));
	String rightTeamScore = dailyScore.substring(dailyScore.indexOf(":") + 1, dailyScore.length());
%>
<h1><%= teamName %> vs <%= rightTeamName %></h1>
<h2><%= leftTeamScore %> vs <%= rightTeamScore %></h2>
<% } else { %>
<h1> <%= teamName %> has no game today</h1>
<% } %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<c:if test="${ !empty error }">
	<script>
		var myModal = $("#myModal");
		myModal.find(".modal-title").text("Login Error");
		myModal.find(".modal-body").text("${ error }");
		myModal.modal();
	</script>
</c:if>
</body>
</html>