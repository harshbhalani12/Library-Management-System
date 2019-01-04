<%-- 
    Document   : LoadBooks
    Created on : 7 Oct, 2017, 10:07:42 PM
    Author     : Admin
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileReader"%>
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
        <h1>Hello World!</h1>
        <%
            try {
                out.println("helllllll");
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
                out.println("hekkkkkk");
                Scanner scAu = new Scanner(new FileReader("E:\\000.UTD_1ST_SEM\\DB_DESIGN\\PROJECT\\PROJECT_1\\DATA\\FINAL_DATA\\Book1.txt"));
                out.println("helllooooo");
                String lineOfColumnsAu = scAu.nextLine();
                String[] columnSetAu = lineOfColumnsAu.split("\t");
                String[] inputDataAu = new String[columnSetAu.length];
                out.println(columnSetAu.length);
                String lineAu;
//                lineAu = scAu.nextLine();
                out.println("in try");
                while (scAu.hasNextLine()) {
                    out.println("in while first");
                    lineAu = scAu.nextLine();
                    inputDataAu = lineAu.split("\t");
//                    Statement st = con.createStatement();
                    out.println("after inputDataAu : "+inputDataAu.length);
//                    System.out.println(query);
                    for(int i=0;i<inputDataAu.length;i++){
                        out.print(inputDataAu[i]);
                        out.print("  ");
                    }
                    
                    PreparedStatement ps = con.prepareStatement("insert into Books(Isbn10,Isbn13,Title,Publisher,Pages,Cover) values(?,?,?,?,?,?)");
                    ps.setString(1, inputDataAu[0]);
                    ps.setString(2, inputDataAu[1]);
                    ps.setString(3, inputDataAu[2]);
                    ps.setString(4, inputDataAu[3]);
                    ps.setString(5, inputDataAu[4]);
                    ps.setString(6, inputDataAu[5]);
                    ps.executeUpdate();
//                    out.println("done");
//                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>
