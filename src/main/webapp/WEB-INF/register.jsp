<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:useBean id="now" class="java.util.Date" scope="request" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<spring:url value="/resources/css/style.css" var="stylecss" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">


<title>Register</title>
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					Register to <b>Online Shopping</b>
				</h4>
				or go back to our <a href="/">main site</a>.
			</div>
			${message}
			<div class="modal-body">
				<div class="row">
					<div class="well">
						<form:form modelAttribute="member" class="form-horizontal"
							action="register" method="POST">
							<div class="form-group">

								<div class="col-lg-4">
									<label class="control-label" for="fullName"> Full Name
									</label>
								</div>
								<div class="col-lg-8">
									<form:input id="firstName" path="fullName"
										placeholder="Please enter Full Name" type="text"
										class="form-control" value="" />
									<span class="help-block"></span>
								</div>
								
							</div>

							<div class="form-group">

								<div class="col-lg-4">
									<label class="control-label" for="fullName"> Email
									</label>
								</div>
								<div class="col-lg-8">
									<form:input id="firstName" path="email"
										placeholder="Please enter Email Address" type="text"
										class="form-control" value="" />
									<span class="help-block"></span>
								</div>
								
							</div>
							<div class="form-group">

								<div class="col-lg-4">
									<label class="control-label" for="fullName"> Username
									</label>
								</div>
								<div class="col-lg-8">
									<form:input id="username" path="username"
										placeholder="Please enter username" type="text"
										class="form-control" value="" />
									<span class="help-block"></span>
								</div>
								
							</div>
							<div class="form-group">

								<div class="col-lg-4">
									<label class="control-label" for="password"> password
									</label>
								</div>
								<div class="col-lg-8">
									<form:input id="password" path="password"
										placeholder="Please enter password" type="password"
										class="form-control" value="" />
									<span class="help-block"></span>
								</div>
								
							</div>
							<div class="form-group">

								<div class="col-lg-4">
									<label class="control-label" for="dateOfbirth"> Date Of Birth
									</label>
								</div>
								<div class="col-lg-8">
									<form:input id="dob" path="dateOfBirth"
										placeholder="Please enter Date Of Birth" type="text"
										class="form-control" value="" />
									<span class="help-block"></span>
								</div>
								
							</div>
						
							<input type = "submit" value = "Register" >
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
