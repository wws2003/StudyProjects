<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<h2>Hello world. Welcome to the secured webapp</h2>
	<div id="login-form">
		<form name='f' action="<c:url value='/auth/j_spring_security_check' />" method='post'>
			<label>Username</label> 
			<input type='text' name='j_username' 
				id='username' maxlength="40"></input>
			<br>
		   <label>Password</label>
			<input type='password' name='j_password'
				id='password' maxlength="100"></input>
			<input type="submit" name="submit" value="Login"/>
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>

