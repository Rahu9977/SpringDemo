<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<
<center>
<h2>ADD COUNTRY</h2>

<form:form modelAttribute="usrmodel"  >

<form:label path="cname">COUNTRY:</form:label>
<form:input path="cname"/><br>



<input type ="submit" value ="Add ">

</form:form>

</center>