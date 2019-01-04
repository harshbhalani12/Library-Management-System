<%-- 
    Document   : GetBooks
    Created on : 15 Oct, 2017, 10:46:06 AM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--<h1>Hello World!</h1>-->
        <%
//            out.println("hello ahrsh");
            String name = request.getParameter("BookName");
            String buffer = "";
            
            ArrayList<String> al = new ArrayList<String>();
            
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select Title from Books where Title LIKE '%"+name+"%'");
            while(rs.next()){
                al.add(rs.getString(1));
            }
            buffer=buffer+" ";
//            out.println(al);
            
            Gson gson = new Gson();
            out.println(gson.toJson(al));
        %>
    </body>
</html>
