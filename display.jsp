<script >

function abc(val)
{
	if(confirm("are you sure???"))
	{
		window.location.href="delete.Rahul?id="+val;
	}
}

function abcd(val)
{
	if(confirm("are you sure???"))
	{
		window.location.href="update.Rahul?id="+val;
	}
}


</script>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Display User Data Record:</h1>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
<tr>
<th>Sr.no</th>
<th>FullName</th>
<th>Mobile Number</th>
<th>Gender</th>

<th>Address</th>

<th>Price</th>
<th>BirthDate</th>
<th>Resume</th>

</tr>
<c:forEach items="${list}" var="s" varStatus="count">
<tr>
<td>
${s.id}
</td>
<td>
${s.name}
</td>
<td>
${s.number}
</td>
<td>
${s.gender}
</td>

<td>
${s.address}
</td>

<td>
${s.price}
</td>
<td>
${s.bdate}
</td>
<td>
<a href='<c:url value="download.Rahul?fi=${s.filename}"/>'>${s.filename}</a>
<%-- <a href=" ">${s.fileupld}</a> --%>
</td>
<td>
<input type = "button" value = "delete" onclick="abc(${s.id})">
</td>
<td>
<input type = "button" value = "update" onclick="abcd(${s.id})">
</td>

</tr>


</c:forEach>
</table>