<%@ page language="java" contentType="text/html; charset=windows-31j" pageEncoding="windows-31j" %>

<%--Struts�p�̃^�O��,/struts-tag�Ŏw�肳��Ă���^�O��s:���C���f�b�N�X�Ƃ��ė��p���� --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional1//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title></title>
</head>
<body>
���O�C��<br>

<%--�t�H�[���ł���Struts�ł̏�������s:�C���f�b�N�X�Ƃ��ė��p���Ă���B
	theme="simple"�Ƃ����̂́A<s:form>�Ȃ�<s:>�ł̃^�O�́AHTML�ɓW�J�����Ƃ��A�����HTML�^�O���o�͂���B
	����́Asimple�Ƃ����`�����w�肵�ďo�͂��Ȃ��悤�ɂ��Ă��� --%>
<s:form action="/Login" method="post" theme="simple">
	<s:submit value="submit" />
</s:form>
</body>
</html>
