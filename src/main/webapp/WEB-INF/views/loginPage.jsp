<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
	taglib prefix="s" uri="http://www.springframework.org/tags"
%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>

	<h1>Spring Security Login Form (Database + Hibernate Authentication)</h1>

	<div id="login-box">

		<h3>Login with Username and Password</h3>


        <spring:url var="authUrl" value="/static/j_spring_security_check"/>

		<form method="post" class="signin" action="${authUrl}">

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='j_username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name="j_password" /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Sign In" /></td>
				</tr>
				<small><a href="/account/resend_password">Forgot?</a></small>
			</table>
		</form>
        </script>
	</div>

</body>
</html>