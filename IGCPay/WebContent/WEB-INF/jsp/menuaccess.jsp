<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="${pageContext.request.contextPath}/menuaccess/" />
<title>Menu Access</title>
</head>
<body>


<%



%>


<div>
<%@include file="/WEB-INF/includes/header.jsp"%>
</div>
<hr>

<table>
	<tr>
		<td valign="top" width="200px"   ><%@include file="/WEB-INF/includes/leftmenu.jsp"%></td>
		<td  valign="top" align="left"  >
		
		<div>
		
		Menu Access
		
		<form action="role" method="post">
 
<select name="Events">
<option value="">SELECT</option>
<option value="${dataMap.ROLE_ID}">Role</option>
<option value="menu">Menu</option><p>
<br><input type="Submit" name="Ok" >
  </p>
    
</form> -->
<%-- 

		</div>
		
		
<c:if test="${add==true}">
			<div>
				<strong>Menu Access Entry</strong>
				
				<form action="add" method="post">
					
					<br><br>
					<table>
						<tr>
							<td>Id </td>
							<td><input type="text"   name="id"  value="" ></td>
						</tr>
						
						<tr>
							<td>Role Id</td>
							<td><input type="text" name="roleId" value="" ></td>
						</tr>
						
						<tr>
							<td>Menu Id</td>
							<td><input type="text" name="menuId" value="" ></td>
						</tr>
						
						
						<tr>
							<td><input type="submit"  value="Save"  ></td>
						</tr>
					</table>
				</form>
		</div>
		
		</c:if>
		
		
		<c:if test="${edit==true}">
			<div>
				<strong>Menu Access Update</strong>
				<form action="edit" method="post">
					<br><br>
					<table>
						<tr>
							<td>Id </td>
							<td><input type="text"   name="id"  value="${dataMap.ID}"  readonly="readonly"  ></td>
						</tr>
						
						<tr>
							<td>Role ID </td>
							<td><input type="text"   name="roleId"  value="${dataMap.ROLE_ID}"  readonly="readonly"  ></td>
						</tr>
						
						<tr>
							<td>Menu ID</td>
							<td><input type="text" name="menuId" value="${ dataMap.MENU_ID }" ></td>
						</tr>
						
						
					
						<tr>
							<td><input type="submit"  value="Save"  ></td>
						</tr>
					</table>
				</form>
		</div>
		
		</c:if>
		
		
		
		
		<br><br><br>
		
		
		<div  style="text-align: right">
		<a href="add">Add New</a>
		</div>
		
		
		<c:if test="${view==true}">
				<div  class="tableView"  style="text-align: right" >
				Access Here
		
				<table border="1">
						<tr>
							<th>S.N</th>
							<th>Menu Access Id</th>
							<th>Role Id</th>
							<th>Menu Id</th>
							<th  width="100px">Action</th>
						</tr>
					
					<%int count=0; %>
					<c:forEach  items="${dataList}"  var="dataList">
					<%count++; %>
						<tr>
							<td><%=count %></td>
							<td>${dataList.ID}</td>
							<td>${dataList.ROLE_ID}</td>
							<td>${dataList.MENU_ID}</td>
							<td><a href="edit/${dataList.ID}" >Edit</a>|<a href="delete/${dataList.ID}" >Delete</a></td>
						</tr>
					
					</c:forEach>			
					
				
				</table>
		</div>
		</c:if>
		
	
		
		</td>
	</tr>
</table>

<hr>
<div>
<%@include file="/WEB-INF/includes/footer.jsp"%>
</div> --%>





</body>
</html>