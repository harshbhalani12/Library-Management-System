/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CheckOutBooksServlet extends HttpServlet {

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
            String Isbn10 = request.getParameter("Isbn10");
//            out.println(Isbn10);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

            Statement stmt = con.createStatement();
//            String query = "Select * from Books where Isbn10 = '"+Isbn10+"'";
            String query = "select b.Isbn10,b.Isbn13, b.Title, b.Cover,b.Publisher,b.Pages,\n"
                    + "	STUFF((select distinct '' + a.Name + ','\n"
                    + "	from Authors a \n"
                    + "	right join Book_Authors ba on ba.AuthorId = a.AuthorId\n"
                    + "	where b.Isbn10 = ba.Isbn10\n"
                    + "		for xml path(''),TYPE).value('.','NVARCHAR(MAX)'),1,0,'') AS AllAuthors\n"
                    + "from Books b\n"
                    + "where b.Isbn10 = '" + Isbn10 + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                request.setAttribute("Isbn10", rs.getString(1));
                request.setAttribute("Title", rs.getString(3));
                request.setAttribute("Cover", rs.getString(4));
                request.setAttribute("Authors", rs.getString(7));

            }
            HttpSession hs = request.getSession();
            if (request.getAttribute("msg") != null) {
                request.setAttribute("AvailableCheck", request.getAttribute("msg"));
                out.println(request.getAttribute("AvailableCheck"));
            }
            RequestDispatcher rd = request.getRequestDispatcher("Checkout.jsp");
            rd.forward(request, response);

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
