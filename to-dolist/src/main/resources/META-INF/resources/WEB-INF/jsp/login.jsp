<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<div class="container">
    <h1>Login Page!</h1>
	
	<pre>${errorMessage}</pre>
    <form method="post">
    	Name:<input type="text"  name="name">
    	Password: <input type="password" name="password">
    	<input type="submit">
    </form>
</div>
</body>
</html>
