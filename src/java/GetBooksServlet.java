/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Books;

/**
 *
 * @author Admin
 */
public class GetBooksServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("BookName");
            String buffer = "";

            ArrayList<String> al = new ArrayList<String>();
            ArrayList<Books> alb = new ArrayList<Books>();

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

            Statement stmt = con.createStatement();
            String sqlQuery = "select b.Isbn10,b.Isbn13, b.Title, b.Cover,b.Publisher,b.Pages,\n"
                    + "	STUFF((select distinct '' + a.Name + ','\n"
                    + "	from Authors a \n"
                    + "	right join Book_Authors ba on ba.AuthorId = a.AuthorId\n"
                    + "	where b.Isbn10 = ba.Isbn10\n"
                    + "		for xml path(''),TYPE).value('.','NVARCHAR(MAX)'),1,0,'') AS AllAuthors\n"
                    + "from Books b\n"
                    + "where b.Isbn10 Like '%" + name + "%' \n"
                    + "	OR b.Title LIKE '%" + name + "%'\n"
                    + "	OR STUFF((select distinct '' + a.Name + ','\n"
                    + "	from Authors a \n"
                    + "	right join Book_Authors ba on ba.AuthorId = a.AuthorId\n"
                    + "	where b.Isbn10 = ba.Isbn10\n"
                    + "		for xml path(''),TYPE).value('.','NVARCHAR(MAX)'),1,0,'')  Like '%" + name + "%'";
            ResultSet rs = stmt.executeQuery(sqlQuery);
//            ResultSet rs = stmt.executeQuery("Select * from Books Left Join Authors ON Books.Isbn10 = Authors.Isbn10 where Title LIKE '%"+name+"%'");
//            Books b = new Books();
            Books b;
            while (rs.next()) {
//                al.add(rs.getString(1));
                b = new Books();
                b.setIsbn10(rs.getString(1));
                b.setIsbn13(rs.getString(2));
                b.setTitle(rs.getString(3));
                b.setCover(rs.getString(4));
                b.setPublisher(rs.getString(5));
                b.setPages(rs.getString(6));
                b.setAllAuthors(rs.getString(7));
                Statement st = con.createStatement();
                String query = "select DateIn from Book_Loans where Isbn10 = '" + rs.getString(1) + "' AND DateIn IS NULL";
                ResultSet rs1 = st.executeQuery(query);
                if (rs1.next()) {
                    b.setAvailable("NotAvailable");
                } else {
                    b.setAvailable("Available");
                }
                alb.add(b);
            }
            buffer = buffer + " ";
//            out.println(al);

//            Gson gson = new Gson();
//            out.println(gson.toJson(al));
            for (int i = 0; i < alb.size(); i++) {
//                out.println(alb.get(i).getCover()+"||"+alb.get(i).getTitle()+"<br><hr>");
                Books b1 = alb.get(i);
                if (b1.getAvailable().equals("NotAvailable")) {
                    out.println("<tr>\n"
                            + "                                                <td><img src=\"" + alb.get(i).getCover() + "\" class=\"img-thumbnail\" alt=\"Image Not Found!!\"></td>" + "<td>" + alb.get(i).getTitle() + "<br> Isbn: " + alb.get(i).getIsbn10() + " <br>Authors: " + alb.get(i).getAllAuthors() + "</td>\n"
                            + "                                                <td><a href =\"#\"class=\"btn btn-danger\">Not Available</a></td><td></td>\n"
                            + "                                            </tr>");
                }else{
                    out.println("<tr>\n"
                            + "                                                <td><img src=\"" + alb.get(i).getCover() + "\" class=\"img-thumbnail\" alt=\"Image Not Found!!\"></td>" + "<td>" + alb.get(i).getTitle() + "<br> Isbn: " + alb.get(i).getIsbn10() + " <br>Authors: " + alb.get(i).getAllAuthors() + "</td>\n"
                            + "                                                <td><a href =\"CheckOutBooksServlet?Isbn10=" + alb.get(i).getIsbn10() + "\" class=\"btn btn-info\">Check Out</a></td>\n"
                            + "                                            </tr>");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
