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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Books;
import model.ManageBooks;

/**
 *
 * @author Admin
 */
public class ManageBooksCheckInServlet extends HttpServlet {

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
            ArrayList<ManageBooks> alb = new ArrayList<ManageBooks>();

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

            Statement stmt = con.createStatement();
            String sqlQuery = "select bl.CardId,bl.Isbn10,b.FirstName,bl.DateOut, bl.DueDate from Book_Loans bl, Borrower b where bl.CardId = b.CardId AND bl.DateIn IS NULL AND (b.FirstName LIKE '%" + name + "%' OR bl.CardId LIKE '%" + name + "%' OR bl.Isbn10 LIKE '%" + name + "%');";
//            out.println(sqlQuery);
            ResultSet rs = stmt.executeQuery(sqlQuery);
//            ResultSet rs = stmt.executeQuery("Select * from Books Left Join Authors ON Books.Isbn10 = Authors.Isbn10 where Title LIKE '%"+name+"%'");
//            Books b = new Books();
            Books b;
            ManageBooks mb;
            while (rs.next()) {
                mb = new ManageBooks();
                mb.setCardId(rs.getString(1));
                mb.setBName(rs.getString(3));
                mb.setIsbn10(rs.getString(2));
                mb.setCheckOutDate(rs.getString(4));
                mb.setDueDate(rs.getString(5));
                mb.setNotFound("Found");
//                String q = "select CardId from Book_Loans where CardId = '"+mb.getCardId()+"'";
////                out.println(q);
//                Statement st = con.createStatement();
//                ResultSet rs1 = st.executeQuery(q);
                alb.add(mb);
            }
//            buffer = buffer + " ";
////            out.println(al);
//
////            Gson gson = new Gson();
////            out.println(gson.toJson(al));
            for (int i = 0; i < alb.size(); i++) {
//                out.println(alb.get(i).getBName()+"||"+alb.get(i).getCardId()+"<br><hr>");
                ManageBooks bl = alb.get(i);
                if (bl.getNotFound().equals("Found")) {
                    out.println("<tr>\n"
                            + "                                                <td>" + bl.getCardId() + "</td>\n"
                            + "                                                <td>" + bl.getBName() + "</td>\n"
                            + "                                                <td>" + bl.getIsbn10() + "</td>\n"
                            + "                                                <td>" + bl.getCheckOutDate() + "</td>\n"
                            + "                                                <td>" + bl.getDueDate() + "</td>\n"
                            + "                                                <td><a href =\"CheckInToDbServlet?Isbn10=" + bl.getIsbn10() + "&CardNo="+bl.getCardId()+"\" class=\"btn btn-info\">Check In</a></td>\n"
                            + "                                            </tr>\n");
                }else if(bl.getNotFound().equals("NotFound")){
                    out.println("No records Found!!");
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
