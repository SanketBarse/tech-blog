<%@page import="java.sql.Connection"%>
<%@page import="helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="css/style.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.banner-background{
		clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 87%, 66% 100%, 30% 89%, 0 100%, 0 0);
	}
</style>
</head>
<body>
	<%@include file="/header.jsp"%>

	<div class="container-fluid p-0 m-0 banner-background">
		<div class="jumbotron text-white primary-background">
			<div class="container">
				<h1>Welcome to, TechBlog</h1>
				<p>welcome to tech journey</p>

				<a href="register.jsp"><button class="btn btn-outline-light">Start ! Its free</button></a>
				<a href="login.jsp"><button class="btn btn-outline-light">Login</button></a>

			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>