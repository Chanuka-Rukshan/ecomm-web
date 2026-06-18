<%@ page import="jakarta.ejb.EJB" %>
<%@ page import="lk.jiat.ecomm.user.remote.TestRemote" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.naming.InitialContext" %><%--
  Created by IntelliJ IDEA.
  User: K.A.Chanuka Rukshan
  Date: 6/17/2026
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
//    @EJB
//    private TestRemote testRemote;
%>

<h1>index page</h1>

<%
    try {
        InitialContext ic = new InitialContext();
        TestRemote tr = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");
        tr.test();
    } catch (NamingException e) {
        throw new RuntimeException();
    }
%>
</body>
</html>
