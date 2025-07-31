<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model2.User" %>

<%@ page import="model2.User, model2.Mutter, java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");

//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String)request.getAttribute("errorMsg");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<p>

<%=loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>

<p><a href="Main">更新</a></p>

<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>

<% if (errorMsg != null) {%>
<p><%= errorMsg %></p>

<% } %>


<% for(Mutter mutter : mutterList) { %>
<p><%= mutter.getUserName() %> :<%= mutter.getText() %></p>
<% } %>

</body>
</html>