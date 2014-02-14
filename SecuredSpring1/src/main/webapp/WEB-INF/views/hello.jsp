<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
	<h2>Hello world. Welcome to the secured zone '${authenticatedUserName}' </h2>
	<h3><a href='<c:url value="/auth/logout"/>'>Logout</a></h3>
</body>
</html>
