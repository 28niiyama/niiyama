<%--���i�ꗗ��\������ --%>
<%--�V���b�s���O�J�[�g�Ƃ��čw�����鏤�i�̊Ǘ� --%>
<%--��v��ʂւ̑J�� --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="Windows-31J"%>

<%--�^�O���C�u���̎w���prefix�̎w��--%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="bookstore.BookDB" %>
<%@ page import="java.util.List" %>

<html>
<head>
</head>
<body>

<%--bookstore�̃t�H�[�� --%>
<s:form action="/AddToCart" method="post">
	<table border="1">
	
	<tr><th>��i��</th><th>���Җ�</th><th>���i</th><th>�I��</th></tr>
	
	<%--s:iterator�́A���X�g�ɕۑ�����Ă���f�[�^���A���̃f�[�^�����݂��邾���A���ɃA�N�Z�X����B
		liblist��TBook�̃I�u�W�F�N�g�����X�g�^�ŕۑ����Ă���B --%>
	<s:iterator value="1blist">
		
		<%--�Ώۂ̃I�u�W�F�N�g�i��TBook�N���X�j�ɑ΂��A�Q�Ƃ���v���p�e�B --%>
		<%--title�Ƃ����v���p�e�B���擾����i��getTitle()�Ƃ������\�b�h�𗘗p���Ēl���擾����j--%>
		<tr>
			<td>		
				<s:property value="title"/>
			</td>
			<td>
				<s:property value="author"/><%--�Ώۂ̃I�u�W�F�N�g�i��TBook�N���X�j�ɑ΂��A�Q�Ƃ���v���p�e�B --%>
			</td>
			<td>
				<s:property value="price"/>?~<%--�Ώۂ̃I�u�W�F�N�g�i��TBook�N���X�j�ɑ΂��A�Q�Ƃ���v���p�e�B --%>
			</td>
			<td>
			
			<%--%{isbn}��TBook�I�u�W�F�N�g�̒���isbn�̃f�[�^�ŁAselected_isbn�Ƃ������̂̕ϐ��ɑ������ --%>
			<s:set name="selected_isbn" value="%{isbn}"/>
			
			<%--#session(Http�̃Z�b�V����)��CART�Ƃ������̂Ńf�[�^���ۑ�����Ă��邩�ǂ��� --%>
			<%--null�̏ꍇ�i��ԍŏ��ɃA�N�Z�X�����Ƃ����j�A���̃`�F�b�N�{�b�N�X�\�����s��Ȃ� --%>
			<%--session.CART�Ƃ����̂́AString�^obj��List�ŁA���̒���ISBN�ԍ����܂܂�Ă���A�܂�V���b�s���O�J�[�g�ɏ��i�������Ă���--%>
			<s:if test="%{#session.CART != null &&
						!#session.CART.isEmpty() &&
						#session.CART.contains(#selected_isbn)}">
				<s:checkbox name ="selecteditems" fieldValue="%{isbn}"
									theme="simple" value='true'/>
			</s:if>
			<s:else>
				<s:checkbox name="selecteditems" fieldValue="%{isbn}"
								theme="simple" value='false'/>
			</s:else>
			</td>
			</tr>
	</s:iterator>
	</table>
	
	<s:submit value="�J�[�g�ɒǉ�" method="addToCart" theme="simple"/>
	<s:submit value="��v" method="checkout" theme="simple"/>
</s:form>
</body>
</html>