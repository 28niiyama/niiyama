<%@ page language="java" contentType="text/html; charset=windows-31j" pageEncoding="windows-31j" %>

<%--Struts用のタグで,/struts-tagで指定されているタグをs:をインデックスとして利用する --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional1//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title></title>
</head>
<body>
ログイン<br>

<%--フォームですがStrutsでの書き方でs:インデックスとして利用している。
	theme="simple"というのは、<s:form>など<s:>でのタグは、HTMLに展開されるとき、特定のHTMLタグを出力する。
	今回は、simpleという形式を指定して出力しないようにしている --%>
<s:form action="/Login" method="post" theme="simple">
	<s:submit value="submit" />
</s:form>
</body>
</html>
