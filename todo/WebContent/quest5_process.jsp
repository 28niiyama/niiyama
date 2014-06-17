<%@ page language="java" contentType="text/html; charset=UTF-8"
	import=" java.sql.*,javax.naming.*,javax.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
String isbn = request.getParameter("isbn");
String title = request.getParameter("title");
String price = request.getParameter("price");
String publish = request.getParameter("publish");
String published = request.getParameter("published");

CheckUtil c = new CheckUtil();
c.requiredCheck(isbn,"ISBNコード");
c.regExCheck(isbn,"^978-4-[0-9]{3,6}-[0-9]{3,6}-[0-9X]{1}$","ISBNコード");
c.duplicateCheck(isbn,"SELECT isbn FROM book WHERE isbn = ?","ISBNコード");
c.requiredCheck(title,"書名");
c.lengthCheck(title,100,"書名");
c.numberTypeCheck(price,"価格");
c.rangeCheck(price,10000,1,"価格");
c.dateTypeCheck(published,"配本日");
if(c.hasErrors()){
	request.setAttribute("err",c.getErrorList());
	application.getRequestDispatcher("/quest5_form.jsp").forward(request,response);
	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>