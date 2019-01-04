package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.Scanner;
import java.io.FileReader;
import java.sql.Connection;

public final class LoadBorrowers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try {
                out.println("helllllll");
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
                out.println("hekkkkkk");
                Scanner scAu = new Scanner(new FileReader("E:\\000.UTD_1ST_SEM\\DB_DESIGN\\PROJECT\\PROJECT_1\\DATA\\borrowers.csv"));
                out.println("helllooooo");
                String lineOfColumnsAu = scAu.nextLine();
                String[] columnSetAu = lineOfColumnsAu.split(",");
                String[] inputDataAu = new String[columnSetAu.length];
                out.println(columnSetAu.length);
                String lineAu;
//                lineAu = scAu.nextLine();
                out.println("in try");
                while (scAu.hasNextLine()) {
                    out.println("in while first");
                    lineAu = scAu.nextLine();
                    inputDataAu = lineAu.split(",");
//                    Statement st = con.createStatement();
                    out.println("after inputDataAu : " + inputDataAu.length);
//                    System.out.println(query);
                    for (int i = 0; i < inputDataAu.length; i++) {
                        out.print(inputDataAu[i]);
                        out.print("  ");
                    }

                    PreparedStatement ps = con.prepareStatement("insert into Borrower(Ssn,FirstName, LastName, Email, Address, City, State, Phone) values(?,?,?,?,?,?,?,?)");
                    
                    ps.setInt(1, Integer.parseInt(inputDataAu[0]));
                    ps.setString(2, inputDataAu[1]);
                    ps.setString(3, inputDataAu[2]);
                    ps.setString(4, inputDataAu[3]);
                    ps.setString(5, inputDataAu[4]);
                    ps.setString(6, inputDataAu[5]);
                    ps.setString(7, inputDataAu[6]);
                    ps.setString(8, inputDataAu[7]);
                    ps.executeUpdate();
//                    out.println("done");
//                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
