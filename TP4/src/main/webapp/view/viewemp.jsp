<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Fonction</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<!-- Spring EL : Spring Expression Language -->
	<c:forEach var="empVo" items="${maliste}">
		<tr>
			<td>${empVo.id}</td>
			<td>${empVo.name}</td>
			<td>${empVo.salary}</td>
			<td>${empVo.fonction}</td>
			<td><a href="editemp/${empVo.id}">Edit</a></td>
			<td><a href="deleteemp/${empVo.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="empform">Add New Employee</a>
