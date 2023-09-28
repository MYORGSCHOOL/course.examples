<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 16707238
  Date: 27.09.2023
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <%
        List<String> names = (List<String>) request.getAttribute("names");
        for (String name: names) {
            out.println("<li>" + name + "</li>");
        }
    %>
</ul>
</body>
</html>
