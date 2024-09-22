<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<div class="container">
    <h1>Hello!</h1>
    <p>Enter New Todo.</p>
    <form:form method="post"  modelAttribute="todo">
    	<fieldset class="mb-3">
    		<form:label path="description">Description</form:label>
    		<form:input type="text"  path="description" />
    		<form:errors path="description" cssClass="text-warning" />
    	</fieldset>
    	
    	
    	<fieldset class="mb-3">
    		<form:label path="targetDate">Target Date</form:label>
    		<form:input type="text"  path="targetDate" />
    		<form:errors path="targetDate" cssClass="text-warning" />
    	</fieldset>
    	
    	
    	<form:input type="hidden"  path="done" />
    	<form:input type="hidden"  path="id" />
    		
    	
    	<input type="submit" class="btn btn-success"  />
    </form:form>
    
    
   </div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js"></script>
	<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd',
	    startDate: '-3d'
});
</script>
</body>
</html>


