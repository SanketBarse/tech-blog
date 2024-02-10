<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
	document.addEventListener('DOMContentLoaded', ()=>{
		
		let form  = document.getElementById("registerUser");
		form.addEventListener('submit' , (event)=>{	
			event.preventDefault();
			
			let formData = new FormData(form);
			console.log(formData);
			fetch("RegisterServlet",{
				method : "POST",
				body : formData
			})
			.then(response => {
				if(!response.ok){
					throw  new Error('Network is not responding..');
				}
				return response.json();
			})
			.then(data =>{
				if(data.success){
				 	return Swal.fire({
						  title: "Welcome!",
						  text: data.msg,
						  icon: "success"
					}).then(() => {
                        // Redirect the user to login.jsp after showing the success message
                        window.location.href = "login.jsp";
                    });
				}else{
					return Swal.fire({
						  icon: "error",
						  title: "Oops...",
						  text: data.msg,
					});
				}
				
				console.log('Form data sent successfully:', data);
			})
			.catch(err => {
			    console.error('There was a problem with the fetch operation:', err);
			});			
			
		});
	});

	
</script>
</head>
<body>
	<%@include file="/header.jsp"%>

	<div class="container d-flex align-items-center" style="height: 70vh">


		<div class="col-md-4 offset-md-4">

			<div class="card">

				<div class="card-header text-center">
					<span class="fa fa-user-plus" style="font-size: 50px;"></span> <br>
					<h4>Register Here</h4>
				</div>
				<div class="card-body">

					<form id="registerUser" action="RegisterServlet" method="post">
						<div class="form-group">
							<label for="email">Email address</label> <input type="email"
								name="user_email" class="form-control" id="email"
								aria-describedby="emailHelp" placeholder="Enter email" required>
						</div>
						<div class="form-group">
							<label for="phone">Phone</label> <input type="number"
								name="user_phone" class="form-control" id="phone"
								placeholder="Phone Number" required>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								name="user_password" class="form-control" id="password"
								placeholder="Password" required>
						</div>

						<div class="form-group">
							<label for="password">Gender</label> <br> <input
								type="radio" name="gender" value="male" id=male required> MALE <input
								type="radio" name="gender" value="female" id="female" required>
							FEMALE
						</div>

						<div class="form-group form-check">
							<input type="checkbox" name="check" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Check me out</label>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>

					</form>
				</div>
				 
				<div class="card-footer" id="footer" style="display : none">
					<span>${data}</span>
				</div>
			</div>

		</div>


	</div>



</body>
</html>