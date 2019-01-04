<%-- 
    Document   : FindAuthorIDandISBN
    Created on : 7 Oct, 2017, 10:39:47 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
                int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

                Scanner scAu = new Scanner(new FileReader("E:\\000.UTD_1ST_SEM\\DB_DESIGN\\PROJECT\\PROJECT_1\\DATA\\books.csv"));
                String lineOfColumnsAu = scAu.nextLine();
                String[] columnSetAu = lineOfColumnsAu.split("\t");
                String[] inputDataAu = new String[columnSetAu.length];
//                System.out.println(columnSetAu.length);
                String lineAu;
//                out.println("in try");
                while (scAu.hasNextLine()) {
//                    out.println("in while first");
                    lineAu = scAu.nextLine();

                    inputDataAu = lineAu.split("\t");
                    out.println("NAME : " + inputDataAu[3] + "  -->  ");
//                    out.println("");
                    String s = ",";
                    String s1 = "'";
                    if (!(inputDataAu[3].contains(s) || inputDataAu[3].contains(s1))) {
//                        out.println("=== in if==");
//                        out.println("..in else..");
                        PreparedStatement ps = con.prepareStatement("select AuthorId from Authors where Name='" + inputDataAu[3] + "'");
//                        ps.setString(1, inputDataAu[3]);
//                        out.println("After ps");
                        ResultSet rs = ps.executeQuery();
                        out.println("->After rs->");
                        while (rs.next()) {
                            out.println(" in while->");
                            String AuthorId = rs.getString(1);
                            out.println("  Author Id : " + AuthorId + "  Isbn : " + inputDataAu[0]);
                            PreparedStatement ps1 = con.prepareStatement("insert into Book_Authors(AuthorId,Isbn10) values(?,?)");
                            ps1.setInt(1, Integer.parseInt(AuthorId));
                            ps1.setString(2, inputDataAu[0]);
                            ps1.executeUpdate();
                            out.println("+++++++++++++++"+c1+" Row inserted+++++++++++++++++<br>");
                            c1++;
                        }

                    } else if (inputDataAu[3].contains(s)) {
                        out.println("<br>============================in first else if=============================<br>");
                        String input = inputDataAu[3];
                        String result1[] = inputDataAu[3].split(s);
//                        String result2 = input.split(s)[1];

                        for (int i = 0; i < result1.length; i++) {
                            if (!(result1[i].contains(s1))) {
                                PreparedStatement ps = con.prepareStatement("select AuthorId from Authors where Name='" + result1[i] + "'");
//                        ps.setString(1, inputDataAu[3]);
//                        out.println("After ps");
                                out.println("NMAE : " + result1[i]);

                                ResultSet rs = ps.executeQuery();
                                out.println("->After rs->");
                                while (rs.next()) {
                                    out.println(" in while->");
                                    String AuthorId = rs.getString(1);
                                    out.println("  Author Id : " + AuthorId + "  Isbn : " + inputDataAu[0]);
                                    PreparedStatement ps1 = con.prepareStatement("insert into Book_Authors(AuthorId,Isbn10) values(?,?)");
                                    ps1.setInt(1, Integer.parseInt(AuthorId));
                                    ps1.setString(2, inputDataAu[0]);
                                    ps1.executeUpdate();
                                    out.println("+++++++++++++++"+c2+" Row inserted+++++++++++++++++<br>");
                                    out.println("<br><br>");
                                    c2++;
                                }
                            } else {
                                out.println("-> in else-><br>");
                                String str1 = result1[i].split(s1)[0];
                                String str2 = result1[i].split(s1)[1];
                                String str = str1 + str2;
                                out.println("Name : " + result1[i] + "--> " + str);
                                PreparedStatement ps = con.prepareStatement("select AuthorId from Authors where Name like'%" + str1 + "%' AND Name like '%" + str2 + "%'");
                                ResultSet rs = ps.executeQuery();
                                out.println("->After rs->");
                                while (rs.next()) {
                                    out.println(" in while->");
                                    String AuthorId = rs.getString(1);
                                    out.println("  Author Id : " + AuthorId + "  Isbn : " + inputDataAu[0]);
                                    PreparedStatement ps1 = con.prepareStatement("insert into Book_Authors(AuthorId,Isbn10) values(?,?)");
                                    ps1.setInt(1, Integer.parseInt(AuthorId));
                                    ps1.setString(2, inputDataAu[0]);
                                    ps1.executeUpdate();
                                    out.println("+++++++++++++++"+c3+" Row inserted+++++++++++++++++<br>");
                                    out.println("<br><br>");
                                    c3++;
                                }
                            }
                        }
//                        out.println(result1[i] +"--"+"");
//                        c++;
                    } else {

                        String input = inputDataAu[3];
                        String result1 = inputDataAu[3].split(s1)[0];
                        String result2 = inputDataAu[3].split(s1)[1];
                        out.println("-> in else-><br>");
                        String str = result1 + result2;
                        out.println("Name : " + input + "--> " + str);
                        PreparedStatement ps = con.prepareStatement("select AuthorId from Authors where Name like'%" + result1 + "%' AND Name like '%" + result2 + "%'");
                        ResultSet rs = ps.executeQuery();
                        out.println("->After rs->");
                        while (rs.next()) {
                            out.println(" in while->");
                            String AuthorId = rs.getString(1);
                            out.println("  Author Id : " + AuthorId + "  Isbn : " + inputDataAu[0]);
                            PreparedStatement ps1 = con.prepareStatement("insert into Book_Authors(AuthorId,Isbn10) values(?,?)");
                            ps1.setInt(1, Integer.parseInt(AuthorId));
                            ps1.setString(2, inputDataAu[0]);
                            ps1.executeUpdate();
                            out.println("+++++++++++++++"+c4+" Row inserted+++++++++++++++++<br>");
                            out.println("<br><br>");
                            c4++;
                        }

                    }

                }
                out.println("////////////////// c = " + (c1 + c2 + c3 + c4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>
