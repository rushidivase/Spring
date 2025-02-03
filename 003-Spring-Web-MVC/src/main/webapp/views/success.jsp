<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Data Table</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%
		List<Student> sList = (List<Student>) request.getAttribute("data");
	%>

	<div class="container mt-5 border shadow p-5">
		<div class="row justify-content-center">
			<div class="col-10 ">

				<h2 class="display-6 text-center mb-4">Student Data</h2>
				<form name="myForm">
					<table
						class="table table-bordered table-striped table-hover border shadow">
						<thead class="table-dark">
							<tr>
								<th>Select</th>
								<th>Student ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Mobile No</th>
								<th>Qualification</th>
								<th>City</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Student stu : sList) {
							%>
							<tr>
								<td><input type="radio" name="sid"
									value="<%=stu.getSid()%>" required></td>
								<td><%=stu.getSid()%></td>
								<td><%=stu.getName()%></td>
								<td><%=stu.getEmail()%></td>
								<td><%=stu.getMono()%></td>
								<td><%=stu.getQualification()%></td>
								<td><%=stu.getCity()%></td>

							</tr>
							<%
								}
							%>

						</tbody>
					</table>
					<button type="submit" class="btn btn-danger" onclick="deleteStudent()">Delete</button>
					<button type="submit" class="btn btn-success" onclick="updateStudent()">Update</button>
					<button type="submit" class="btn btn-info" onclick="registerStudent()">Register Student</button>
				</form>
			
			</div>
		</div>
	</div>


</body>
<script>

function registerStudent() {
	alert("Register a new Student..!")
	document.myForm.action = "register";
	document.myForm.submit();

}

	function deleteStudent() {
		alert("You are Deleting a Student..!");
		document.myForm.action = "delete-student";
		document.myForm.submit();

	}
	
	function updateStudent()
	{
		alert("You are Updating a Student..!");
		document.myForm.action = "getStudentById";
		document.myForm.submit();
	}
</script>
</html>