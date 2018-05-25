<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<security:authorize access="isAuthenticated()">
<security:authentication property="principal.username" var="u"/> 
</security:authorize>

<c:if test="${u eq null}">
<c:redirect url="login.hello"/>
</c:if>


<tiles:insertAttribute name="title"></tiles:insertAttribute>

<h1>header</h1>

<a href="displaydata.Rahul">Display</a>
<a href="Country.Rahul"> Country </a>
<a href="logout.Rahul"> Logout </a>
<hr>

<tiles:insertAttribute name="body"> </tiles:insertAttribute>

<h1>footer</h1>