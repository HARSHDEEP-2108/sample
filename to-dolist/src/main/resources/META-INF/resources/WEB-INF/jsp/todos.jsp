<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<div class="container">
    <h1>Hello, World!</h1>
    <p>Welcome to my Todo List webpage.</p>
    
    <table class="table">
    	<thead>
    		<tr>
	    		
	    		<th>description</th>
	    		<th>target date</th>
	    		<th>is done</th>
	    		<th></th>
	    		<th></th>
    		</tr>
    	
    	</thead>
    	<tbody>
    		<c:forEach items="${todos}" var="todo">
    		<tr>
    			
    			<td>${todo.description}</td>
    			<td>${todo.targetDate}</td>
    			<td>${todo.done}</td>
    			<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>  </td>
    			<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>  </td>
    			
    		</tr>
    		</c:forEach>
	    </tbody>
	    </table>
	    <a href="addTodo" class="btn btn-success">Add Todo</a>
    </div>
 	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>


