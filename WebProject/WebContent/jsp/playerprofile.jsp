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
<% } %>
	<%@ include file="menu.jsp" %>
<div align="center">
	<form action="${ contextPath }/searchplayer.do" method="post" >
		<select class="form-control" id="playerSelect" name="playerName">
	  	<%
	  		Map<String, String> pl = (Map<String, String>)session.getAttribute("playerList");
	  		for(String playerName : pl.keySet())
	  		{
	  	%>
	  	<option><%= playerName %></option>
	  	<% } %>
		</select>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
</div>
<div style="margin-left: 20px">
<p class="font-weight-bold">Name : ${ player.getName() }</p>
<p class="font-weight-bold">Height : ${ player.getHeight() }</p>
<p class="font-weight-bold">Weight : ${ player.getWeight() }</p>
<p class="font-weight-bold">Position : ${ player.getPosition() }</p>
<p class="font-weight-bold">College : ${ player.getCollege() }</p>
<p class="font-weight-bold">BirthDate : ${ player.getBirthdate() }</p>
<p class="font-weight-bold">Total</p>
<c:forEach var="total" items="${ player.getTotal().keySet() }">
<p class="font-weight-light">   -${ total} : ${ player.getTotal().get(total) }</p>
</c:forEach>
<p class="font-weight-bold">Average : </p>
<c:forEach var="avg" items="${ player.getAverage().keySet() }">
<p class="font-weight-light">   -${ avg } : ${ player.getAverage().get(avg) }</p>
</c:forEach>

</div>


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