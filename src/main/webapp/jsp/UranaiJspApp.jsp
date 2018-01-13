<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.HashMap" %>
<%
HashMap<Integer,String> map = new HashMap<Integer,String>();
map.put(0,"幸運");
map.put(1,"普通");
map.put(2,"不幸");

Integer index = (int)(Math.random() *3);
String resultStr = map.get(index);
%>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>jspでの占いアプリ</title>
</head>
<body>

    <header>
        <h1>jspでの占いアプリ</h1>
        <p>jspの機能だけを使って占いアプリを実行してみる</p>
    </header>
    <div>
    <section>
        <h1>占い占い結果</h1>
        <p><%= resultStr %> ですよ</p>
    </section>
    </div>
</body>
</html>
