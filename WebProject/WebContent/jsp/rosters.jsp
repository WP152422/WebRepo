<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.dimigo.api.API" %>
<%@ page import="org.dimigo.api.Player" %>
<%@ page import="org.dimigo.vo.UserVO" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
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
	<%@ include file="menu.jsp" %>
	<%	if (((UserVO)session.getAttribute("user")).getTeamName() == null) { %>
	<jsp:forward page="/jsp/subscribe.jsp"></jsp:forward>
	<% } %>
	<%
		Map<String, Object> roaster = API.parseRosters( ((UserVO)session.getAttribute("user")).getTeamName());
		List<Player> pg = (List<Player>)roaster.get("PG");
		List<Player> sg = (List<Player>)roaster.get("SG");
		List<Player> pf = (List<Player>)roaster.get("PF");
		List<Player> sf = (List<Player>)roaster.get("SF");
		List<Player> c = (List<Player>)roaster.get("C");
		String coaches = ((String)roaster.get("coaches")).substring(0, ((String)roaster.get("coaches")).length() -1);
	%>

<div style="margin-left: 50px; margin-top: 50px;">
<h1>Point Guard</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Name</th>
      <th scope="col">Id</th>
    </tr>
  </thead>
  <tbody>
    <% for(int i=0; i<pg.size(); i++) {%>
    <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= pg.get(i).getName() %></td>
      <td><%= pg.get(i).getId() %></td>
    </tr>
    <% } %>
  </tbody>
</table>
<h1>Shooting Guard</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Name</th>
      <th scope="col">Id</th>
    </tr>
  </thead>
  <tbody>
    <% for(int i=0; i<sg.size(); i++) {%>
    <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= sg.get(i).getName() %></td>
      <td><%= sg.get(i).getId() %></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<h1>Center</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Name</th>
      <th scope="col">Id</th>
    </tr>
  </thead>
  <tbody>
    <% for(int i=0; i<c.size(); i++) {%>
    <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= c.get(i).getName() %></td>
      <td><%= c.get(i).getId() %></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<h1>Small Forward</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Name</th>
      <th scope="col">Id</th>
    </tr>
  </thead>
  <tbody>
    <% for(int i=0; i<sf.size(); i++) {%>
    <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= sf.get(i).getName() %></td>
      <td><%= sf.get(i).getId() %></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<h1>Power Forward</h1>
<br>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Name</th>
      <th scope="col">Id</th>
    </tr>
  </thead>
  <tbody>
    <% for(int i=0; i<pf.size(); i++) {%>
    <tr>
      <th scope="row"><%= i+1 %></th>
      <td><%= pf.get(i).getName() %></td>
      <td><%= pf.get(i).getId() %></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<h1>Coach : <%= coaches %></h1>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>