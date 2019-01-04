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
public class PayFineServlet extends HttpServlet {

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
        String msg = "";
        float fineAmt;
        try {
            String LoanId = request.getParameter("loanId");
            String CardId = request.getParameter("CardId");
            out.println(LoanId+"|"+CardId);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
//            String fineAmtPay = request.getParameter("FineAmtToPay");
//            out.println(LoanId+"|"+fineAmtPay);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
            Statement st = con.createStatement();
//            String query1 = "select FineAmt from Fines where LoanId = '" + LoanId + "' AND Paid = '0';";

            String query = "select count(*) from Book_Loans bl where CardId = '" + CardId + "' AND (DateIn IS NULL AND DueDate < '" + dateFormat.format(date) + "' )";
//            String query1 = "select * from Fines f, Book_Loans bl where f.LoanId = bl.LoanId AND f.Paid = '0' AND bl.DateIn is NOT NULL AND bl.LoanId = '" + LoanId + "';";

            out.println(query);
            ResultSet rs = st.executeQuery(query);
            int noOfBooks = 0;
            RequestDispatcher rd;
            while(rs.next()){
                noOfBooks = rs.getInt(1);
            }
            if(noOfBooks != 0){
                msg = "You can not pay fines. You have not checked in "+noOfBooks+" overdue books..";
            }else{
                query = "select LoanId from Book_Loans where CardId = '"+CardId+"' AND DateIn > DueDate;";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query);

                while (rs2.next()) {
                    query = "update fines set paid = '1' where LoanId = '" + rs2.getInt(1) + "';";
                    Statement st3 = con.createStatement();
                    st3.executeUpdate(query);
                    st3.close();
                }
                msg = "Payment successful.";
            }
            
            
            
//            if (rs.next()) {
//                out.println("in if");
//                fineAmt = rs.getFloat(1);
//                String query = "update Fines set Paid = '1' where LoanId = '" + LoanId + "'";
//                out.println(query);
//                Statement st1 = con.createStatement();
//                int i = st1.executeUpdate(query);
//                if (i == 1) {
//                    msg = "Fine is successfully paid";
//                } else {
//                    msg = "Payment of fine failed!!! Sorry try again..";
//                }
//                    rd= request.getRequestDispatcher("ListAllFineServlet");
//                    rd.forward(request, response);

//                if (fineAmt == Float.parseFloat(fineAmtPay)) {
//                    out.println("equal amt");
//                    String query = "update Fines set FineAmt = '" + fineAmtPay + "', Paid = '1' where LoanId = '" + LoanId + "'";
//                    out.println(query);
//                    Statement st1 = con.createStatement();
//                    int i = st1.executeUpdate(query);
//                    if (i == 1) {
//                        out.println("Success");
//                    } else {
//                        out.println("failed");
//                    }
//                    rd= request.getRequestDispatcher("ListAllFineServlet");
//                    rd.forward(request, response);
//                } else {
//                    out.println("not equal amt");
//                    float partialPay = fineAmt - Float.parseFloat(fineAmtPay);
//                    String query = "update Fines set FineAmt = '" + partialPay + "', Paid = '0' where LoanId = '" + LoanId + "'";
//                    out.println(query);
//                    Statement st1 = con.createStatement();
//                    int i = st1.executeUpdate(query);
//                    if (i == 1) {
//                        out.println("Partially paid");
//                    } else {
//                        out.println("failed in partially");
//
//                    }
//                    rd= request.getRequestDispatcher("ListAllFineServlet");
//                    rd.forward(request, response);
//                }
//            } else {
//                msg = "Book is not returned yet. please return first then pay fine";
//            }

            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("ListAllFineServlet");
            rd.forward(request, response);

//            String query = "update Fines set FineAmt = '" + fineAmtPay + "', Paid = '0' where LoanId = '" + LoanId + "'";
//            out.println(query);
//            Statement st1 = con.createStatement();
//            int i = st1.executeUpdate(query);
//            if (i == 1) {
//                out.println("Success");
//            } else {
//                out.println("failed");
//
//            }
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
