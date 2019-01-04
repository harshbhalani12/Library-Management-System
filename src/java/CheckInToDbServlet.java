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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CheckInToDbServlet extends HttpServlet {

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String msg = "";
        RequestDispatcher rd;
        boolean flag = true;
        try {
            String Isbn10 = request.getParameter("Isbn10");
            String CardId = request.getParameter("CardNo");

            out.println(Isbn10 + " " + CardId);

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

            if (CardId.equals("")) {
                msg = "Please enter Card Number....";
//                request.setAttribute("msg", msg);
//                rd = request.getRequestDispatcher("CheckIn.jsp");
//                rd.forward(request, response);
            } else {

                String query1 = "select CardId from Borrower where CardId = '" + CardId + "'";
                Statement st1 = con.createStatement();
                ResultSet rs1 = st1.executeQuery(query1);
                if (!(rs1.next())) {
                    msg = "This card number is not exists...";
                    flag = false;
                }

                String query2 = "select CardId from Book_Loans where Isbn10 = '"+Isbn10+"' AND CardId = '"+CardId+"';";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                if(!(rs2.next())){
                    flag = false;
                    msg = "You dont have this book loan...";
                }
                if (flag) {
                    String query = "update Book_Loans set DateIn = '" + dateFormat.format(date) + "' where Isbn10='" + Isbn10 + "' AND CardId='" + CardId + "' AND DateIn IS NULL;";
                    Statement st = con.createStatement();
                    int i = st.executeUpdate(query);
                    if (i == 1) {
                        msg = "Checked in successfully";
//                        out.println("Checked in successfully");
                    }
                }
            }
            request.setAttribute("CardId", CardId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.setAttribute("msg", msg);
            
            rd = request.getRequestDispatcher("ManageBooksCheckIn.jsp");
            rd.forward(request, response);
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
