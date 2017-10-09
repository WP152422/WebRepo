<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="/WebClass/css/myblog.css">
</head>
<body>

<div class="login">
	<form id="loginForm" action="/WebClass/bloglogin" method="post">
 		<input class="form-control" type="email" placeholder="Enter Your Email" aria-label="ID" id="id" name="id" required>
 		<input class="form-control" type="password" placeholder="Enter Your Password" aria-label="PWD" id="pwd" name="pwd" required>
 		<br>
 		<button class="btn btn-primary" type="submit">Sign In</button>
	</form>
</div>

<%@ include file="modal.jsp" %>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script>
<% if("error".equals(request.getAttribute("msg"))){ %>
		
	var id = $("#id");
	document.getElementById("id").value = <%= request.getAttribute("wrongid") %>;

	
	var myModal = $("#myModal");
	myModal.find(".modal-title").text("Login Error");
	myModal.find(".modal-body").text("Invalid username or password");
	myModal.modal();
	
	
<%	} %>
</script>
</body>
</html>