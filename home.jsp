<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>home page</h1>
<center>
<h2>User Registration Data</h2>
<hr> 	

<form:form modelAttribute="usrmodel" enctype="multipart/form-data" >

<form:label path="name">FUll NAME:</form:label>
<form:input path="name"/><br>

<form:label path="number">MOBILE NUMBER:</form:label>
<form:input path="number"/><br>


<form:label path="gender">Gender::</form:label>
<form:radiobutton path="gender" value="male"/>Male
<form:radiobutton path="gender" value="female"/>Female

<br/>


<form:label path="c.cid">COUNTRY:</form:label>
<form:select path="c.cid">
<c:forEach items="${list}" var="f">
<form:option value="${f.cid}">${f.cname}</form:option>
</c:forEach>
</form:select>
<br>

<form:label path="address">Address::</form:label>
<form:textarea path="address"></form:textarea>

<br/>

<form:label path="hob">Hobbie::</form:label>
<form:checkbox path="hob" value="reading"/>reading
<form:checkbox path="hob" value="programmig"/>programmig
<form:checkbox path="hob" value="game"/>game
<form:checkbox path="hob" value="song"/>song
<br>

<form:label path="price">PRICE:</form:label>
<form:input path="price"/><br>

<form:label path="bdate">BirthDate(dd/MM/yyy):</form:label>
<form:input path="bdate"/><br>

<input type="file" name ="fileupld"> 
<br> 	

<table border="1">
<thead>
<tr>
<th>
NAME
</th>

<th>
ADDRESS
</th>

<th>
GENDER
</th>


<th>
ACTION
</th>



</tr>
</thead>
<tbody id="abc">

</tbody>

</table>
<a href="javascript:addRow()">ADD ROW</a>
<br> 	<hr>

<input type ="submit" value ="Registration ">
<hr>
</form:form>



<script>
var count = 1;
var abc = document.getElementById('abc');
function addRow()
{
var tr = document.createElement('tr');
var tr = document.createElement('tr');
var td1 = document.createElement('td');
var td2 = document.createElement('td');
var td3 = document.createElement('td');
var td7 = document.createElement('td');

tr.setAttribute('id','n'+count);

var om = 'n'+count;

var name = document.createElement('input');
name.type = "text";
name.placeholder = "enter name..";
name.style.height = "25px";
name.style.width = "250px";
name.name = "fname";
name.setAttribute("autofocus","true");
name.id = "fname"+count;
name.onkeyup =function(){ab();/*pq();*/};
name.onkeypress = function(){return lettersOnly(event)};

td1.appendChild(name);

tr.appendChild(td1);

var addr = document.createElement('textarea');
addr.placeholder = "enter address..";
addr.name = "addr";
addr.id = "addr"+count;

td2.appendChild(addr);

tr.appendChild(td2);


var gen1 = document.createElement('input');
gen1.type = "radio";
gen1.name = "gender"+count;
gen1.id = "gender"+count;
gen1.value="male";

var lab1 = document.createElement('label');
lab1.innerHTML = "MALE";

var gen2 = document.createElement('input');
gen2.type = "radio";
gen2.name = "gender"+count;
gen2.id = "gender"+count;
gen2.value="female";

var lab2 = document.createElement('label');
lab2.innerHTML = "FEMALE";


td3.appendChild(gen1);
td3.appendChild(lab1);
td3.appendChild(gen2);
td3.appendChild(lab2);

tr.appendChild(td3);



var a = document.createElement('a');
a.onclick =function(){removerow(om);};
var img = document.createElement('img');
img.src = "img/a.png";
img.style.height = "30px";
img.style.width = "30px";

a.appendChild(img);
td7.appendChild(a);



tr.appendChild(td7);


abc.appendChild(tr);
count++;

/*
function pq();;l/l/l/;l/;;;l;
{
alert('xyz');
}
*/
function lettersOnly(evt) {
       evt = (evt) ? evt : event;
       var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
          ((evt.which) ? evt.which : 0));
       if (charCode > 31 && (charCode < 65 || charCode > 90) &&
          (charCode < 97 || charCode > 122)) {
          return false;
       }
       return true;
     }

 function ab()
{
var vao = document.getElementById(name.id); 
/*c.innerHTML = vao;
*/
var j = ['papa','mummy','bhai','bhabhi'];
var i;
var pl = 0;
for(i = 0;i<j.length;i++)
{

   if(vao.value == j[i])
   {
    pl = 1;
   }
}
if(pl == 1)
{
vao.style.background = "red";
}
else{
vao.style.background = "green";
}
}
}

function removerow(im)
{
    abc.removeChild(document.getElementById(im));
}

</script>



</center>