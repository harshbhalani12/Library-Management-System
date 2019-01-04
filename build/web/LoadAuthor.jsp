<%-- 
    Document   : LoadAuthor
    Created on : 7 Oct, 2017, 9:25:56 PM
    Author     : Admin
--%>

<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.sql.PreparedStatement"%>
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
        <h1>Hello World!</h1>
        <%
            try {
                int c = 0;
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
                
                Scanner scAu = new Scanner(new FileReader("E:\\000.UTD_1ST_SEM\\DB_DESIGN\\PROJECT\\PROJECT_1\\DATA\\FINAL_DATA\\AuthorsName.csv"));
                String lineOfColumnsAu = scAu.nextLine();
                String[] columnSetAu = lineOfColumnsAu.split(",");
                String[] inputDataAu = new String[columnSetAu.length];
//                System.out.println(columnSetAu.length);
                String lineAu;
//                out.println("in try");
                while (scAu.hasNextLine()) {
                    out.println("in while first");
                    lineAu = scAu.nextLine();
                    out.println(lineAu+"<br>");
                    inputDataAu = lineAu.split(",");
//                    out.println(inputDataAu[0]);
                    Statement st = con.createStatement();
                    
//                    System.out.println(query);
                    PreparedStatement ps = con.prepareStatement("insert into Authors(Name) values(?)");
                    ps.setString(1, lineAu);
                    ps.executeUpdate();
                   out.print("in while<br>");
                   c++;
    //                ResultSet rs = st.executeQuery("Insert into AuthorTp values()");
    //                System.out.print(inputData[0]+" "+"\t");
    //                System.out.println("\n");
                }
                out.println("c : "+c);
//                String sql = "insert into AuthorTp values("+ +")";
                
            
            
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>

    </body>
</html>
