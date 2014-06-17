<%--商品一覧を表示する --%>
<%--ショッピングカートとして購入する商品の管理 --%>
<%--会計画面への遷移 --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="Windows-31J"%>

<%--タグライブリの指定とprefixの指定--%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="bookstore.BookDB" %>
<%@ page import="java.util.List" %>

<html>
<head>
</head>
<body>

<%--bookstoreのフォーム --%>
<s:form action="/AddToCart" method="post">
	<table border="1">
	
	<tr><th>作品名</th><th>著者名</th><th>価格</th><th>選択</th></tr>
	
	<%--s:iteratorは、リストに保存されているデータを、そのデータが存在するだけ、順にアクセスする。
		liblistはTBookのオブジェクトをリスト型で保存している。 --%>
	<s:iterator value="1blist">
		
		<%--対象のオブジェクト（＝TBookクラス）に対し、参照するプロパティ --%>
		<%--titleというプロパティを取得する（＝getTitle()というメソッドを利用して値を取得する）--%>
		<tr>
			<td>		
				<s:property value="title"/>
			</td>
			<td>
				<s:property value="author"/><%--対象のオブジェクト（＝TBookクラス）に対し、参照するプロパティ --%>
			</td>
			<td>
				<s:property value="price"/>?~<%--対象のオブジェクト（＝TBookクラス）に対し、参照するプロパティ --%>
			</td>
			<td>
			
			<%--%{isbn}はTBookオブジェクトの中のisbnのデータで、selected_isbnという名称の変数に代入する --%>
			<s:set name="selected_isbn" value="%{isbn}"/>
			
			<%--#session(Httpのセッション)にCARTという名称でデータが保存されているかどうか --%>
			<%--nullの場合（一番最初にアクセスしたとき等）、このチェックボックス表示を行わない --%>
			<%--session.CARTというのは、String型objのListで、その中にISBN番号が含まれている、つまりショッピングカートに商品が入っている--%>
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
	
	<s:submit value="カートに追加" method="addToCart" theme="simple"/>
	<s:submit value="会計" method="checkout" theme="simple"/>
</s:form>
</body>
</html>