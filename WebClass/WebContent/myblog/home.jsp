<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>실습과제</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="/WebClass/css/myblog.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Main</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="/WebClass/myblog/hobby.html">Hobby</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/WebClass/myblog/favorite.html">Favorite</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/WebClass/myblog/dream.html">Dream</a>
	      </li>
	    </ul>
	    <%	String id = (String)session.getAttribute("id"); 
	   		if(id == null) { %>
	    <form class="form-inline my-2 my-lg-0">
      		<button type="button" class="btn btn-primary" onclick="location.href='/WebClass/myblog/login.jsp'">Sign In</button>
    	</form>
    	<% } else { %>
    	<div class="nav-item dropdown">
	      <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    	<%= id %>님
	      </a>
	      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
	      	<form action="/WebClass/bloglogout" method="post">
	      		<button type="submit" class="dropdown-item">Sign out</button>
	      	</form>
	      </div>
		</div>
    	<% } %>
	  </div>
	</nav>
	
	<!-- Jumbotron -->
	<div class="jumbotron jumbotron-fluid" style="background-image: url('/WebClass/image/forest.jpg'); height: 920px; padding-top: 0px">
		<div class="bg-overlay" style="padding-top: 40px">
			<div class="container">
				<h1 class="display-3" id="maintitle">Hello</h1>
				<p class="lead" id="maintext">This is simple blog for Application Programming assignment</p>
				<hr class="my-4">
				<p id="profiletext">
					Profile<br><br>
				 	School : Korea Digital Media High School<br>
				 	Grade : Second<br>
				 	Class : 2<br>
				 	Number : 22	<br>
				</p>
			</div>
		</div>
	</div>
	
<%@ include file="modal.jsp" %>
	
	



<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script>

</script>
</body>
</html>

