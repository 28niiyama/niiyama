<%--�I���������i�̍��v��\������--%>
<%@ page language="java" import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import=""%>
<%@ page import=""%>
<%@ page contentType="text/html;charset=Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body> 

	<center>
	<h2>�w�����i</h2>
	</center>
	
	<br><br>
	
	�ȉ����w�����鏤�i�ƍ��v�ł��B
	<br>
	<table border="1">
	
	<%
	List<String> listCheckedBook = (List<String>)session.getAttribute("CART");
	if(listCheckedBook != null){
		for(String iterBookISBN : listCheckedBook){
			t_book book = t_book.findBookByISBN(iterBookISBN);
	%>
		<tr>
			<td>
				<%= book.getTitle() %>
			</td>
			<td>
				<%= book.getAuthor() %>
			</td>
		</tr>
		<tr>
			<td>
				<%= book.getPublisher() %>
			</td>
		</tr>
		<tr>
			<td>
				<%= book.getPrice() %>
			</td>
		</tr>
		<%
		}
	}
		%>
	</table>
	<br>
	<br>
���v�F<%= request.getAttribute("TOTAL") %>�~					
</body>
</html>