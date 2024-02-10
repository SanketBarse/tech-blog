<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login !</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script>
	document.addEventListener('DOMContentLoaded', () => {
	let form = document.getElementById("loginform")
	
	form.addEventListener('submit' , (event)=>{
		event.preventDefault();
		let formData = new FormData(form);
		
		fetch("LoginServlet",{
			method : "POST",
			body : formData
		})
		.then(response=>{
			return response.json();
		})
		.then(data=>{
			if(data.success){
			 return window.location.href = "profile.jsp"
			}else{
				return Swal.fire({
					  icon: "error",
					  title: "Oops...",
					  text: data.msg,
				});	
			}
			
		})
	})
	
})
</script>

</head>
<body>
	<%@include file="/header.jsp"%>
	<main class="d-flex align-items-center" style="height: 70vh">
		<div class="container">
			<div class="row">

				<div class="col-md-4 offset-md-4">

					<div class="card">
						<div class="card-header text-center">
							<span style="font-size: 50px" class="fa fa-newspaper-o"></span> <br>
							<h4>LOGIN HERE</h4>
						</div>

						<div class="card-body">

							<form id="loginform" action="LoginServlet" method="POST">
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <input
										type="email" name="user_email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										placeholder="Enter email">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" name="user_password" class="form-control"
										id="exampleInputPassword1" placeholder="Password">
								</div>
								<div class="form-group form-check">
									<input type="checkbox" name="check" class="form-check-input" id="exampleCheck1"> 
									<label class="form-check-label" for="exampleCheck1">Check me out</label>
								</div>
								<button type="submit" class="btn text-white primary-background">Submit</button>
							</form>
							
							
						</div>
					</div>

				</div>



			</div>
		</div>
	</main>

</body>
</html>