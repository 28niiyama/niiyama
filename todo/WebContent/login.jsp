<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>フォーム認証</title>
</head>
<body>
<form method="POST" action="j_security_check">
<table border="0">
	<tr>
		<th align="right">ユーザ名</th>
		<td><input type="text" name="j_username" size="15"/></td>
	</tr>
	<tr>
		<th align="right">パスワード</th>
		<td><input type="password" name="j_password" size="15"/></td>
	</tr>
	<tr>
		<td rowspan="2">
		<input type="submit" value="ログイン"/>
		<input type="reset" value="取消"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>
