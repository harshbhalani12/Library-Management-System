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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Borrower;
import model.FineDetails;

/**
 *
 * @author Admin
 */
public class CheckFineForBorrowerServlet extends HttpServlet {

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
        String msg = "",msg1 = "";
        try {
            String CardId = request.getParameter("CardNo");
            if (CardId == null) {
                msg = "Please enter Card number";
                request.setAttribute("msg", msg);
            } else {
//                String query = "select CardId, FirstName, LastName from Borrower where CardId = '" + CardId + "';";
//                out.println(query);
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

                Statement st1 = con.createStatement();
                String query = "select bl.CardId, SUM(FineAmt) from Book_Loans bl, Fines f, Borrower b where bl.LoanId = f.LoanId and b.CardId = bl.CardId and f.Paid = '0' AND bl.CardId = '" + CardId + "' group by bl.CardId;";
                ResultSet rs1 = st1.executeQuery(query);
                FineDetails fd;
                ArrayList<FineDetails> al = new ArrayList<FineDetails>();
                while (rs1.next()) {
                    fd = new FineDetails();
                    fd.setCardId(rs1.getInt(1));
                    fd.setFine(Float.parseFloat(rs1.getString(2)));
                    String query1 = "select FirstName, LastName,LoanId from Borrower b,Book_Loans bl where b.CardId = bl.CardId AND b.CardId = '" + fd.getCardId() + "';";
                    out.println(query1);
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query1);
                    if (rs.next()) {
                        fd.setFirstName(rs.getString(1));
                        out.println("after fname set");
                        fd.setLastName(rs.getString(2));
                        fd.setLoanId(rs.getInt(3));
                        out.println("after loanid set");
                    }
                    al.add(fd);
                }
                if (al.isEmpty()) {
                    msg = "No borrower found";
                    request.setAttribute("msg", msg);
                }

                request.setAttribute("list", al);

                /*previously paid fines*/
                String query2 = "select b.Title, bl.DateOut, bl.DateIn, bl.DueDate, f.FineAmt, bl.CardId \n"
                        + "from Fines f, Book_Loans bl, Books b where bl.CardId = '" + CardId + "'\n"
                        + "AND f.LoanId = bl.LoanId AND bl.Isbn10 = b.Isbn10 AND f.Paid = '1';";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                FineDetails fd1;
                ArrayList<FineDetails> alf = new ArrayList<FineDetails>();
                while(rs2.next()){
                    fd1 = new FineDetails();
                    fd1.setTitle(rs2.getString(1));
                    fd1.setDateOut(rs2.getDate(2));
                    fd1.setDateIn(rs2.getDate(3));
                    fd1.setDueDate(rs2.getDate(4));
                    fd1.setFine(rs2.getFloat(5));
                    fd1.setCardId(rs2.getInt(6));
                    alf.add(fd1);
                }
                if(alf.isEmpty()){
                    msg1 = "No Records Found!!";
                }
                request.setAttribute("previousFine",alf);
                request.setAttribute("msg1", msg1);
            }
            RequestDispatcher rd = request.getRequestDispatcher("CheckFines.jsp");
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
