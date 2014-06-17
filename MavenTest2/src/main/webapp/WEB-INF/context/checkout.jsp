<%--選択した商品の合計を表示する--%>
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
	<h2>購入商品</h2>
	</center>
	
	<br><br>
	
	以下が購入する商品と合計です。
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
合計：<%= request.getAttribute("TOTAL") %>円					
</body>
</html>