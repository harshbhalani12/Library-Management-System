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
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoanDetail;

/**
 *
 * @author Admin
 */
public class UpdateAllFines extends HttpServlet {

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
        try {
            int diff,i;
            float fine;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();

            String query2 = "select l.LoanId, f.Paid, l.DateIn, l.DueDate\n"
                    + "from Fines f \n"
                    + "join (select * from Book_Loans b where b.DateIn>b.DueDate or (b.DateIn is null AND '"+dateFormat.format(date)+"'>b.DueDate)) as l\n"
                    + "on f.LoanId = l.LoanId;";
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            ArrayList<LoanDetail> ald1 = new ArrayList<LoanDetail>();
            while (rs2.next()) {
                out.println("in while");
                LoanDetail ld = new LoanDetail();
                ld.setLoanId(rs2.getInt(1));
                ld.setPaid(rs2.getString(2));
                ld.setDateIn(rs2.getDate(3));
                ld.setDueDate(rs2.getDate(4));
                ald1.add(ld);
                out.println("ald.add");
            }
            out.println("size:" + ald1.size() + "<br>");

            for (LoanDetail ldl : ald1) {
                out.println("in for");
                if (ldl.getDateIn() == null) {
                    diff = (int) (-(ldl.getDueDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24));
                } else {
                    diff = (int) (-(ldl.getDueDate().getTime() - ldl.getDateIn().getTime()) / (1000 * 60 * 60 * 24));
                }
                fine = (float) (diff * 0.25);
                String query = "update Fines set FineAmt = '"+fine+"' where LoanId = '"+ldl.getLoanId()+"';";
                out.println("query:" + query + "<br>");
                Statement st = con.createStatement();
                i = st.executeUpdate(query);
                out.println("i : "+i);
                if (i == 1) {
                    msg = "All fines are updated...in already entry";
                    out.println(msg);
                }
            }
            
            
            

            String query1 = "select LoanId, DueDate, DateIn from Book_Loans where ((DateIn > DueDate) or(DateIn IS NULL AND '" + dateFormat.format(date) + "'> DueDate)) AND LoanId NOT IN(select LoanId from Fines);";
            out.println("query1: " + query1 + "<br>");
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            ArrayList<LoanDetail> ald = new ArrayList<LoanDetail>();
            while (rs1.next()) {
                out.println("in while");
                LoanDetail ld = new LoanDetail();
                ld.setLoanId(rs1.getInt(1));
                ld.setDueDate(rs1.getDate(2));
                ld.setDateIn(rs1.getDate(3));
                ald.add(ld);
                out.println("ald.add");
            }
            out.println("size:" + ald.size() + "<br>");

            for (LoanDetail ldl : ald) {
                out.println("in for");
                if (ldl.getDateIn() == null) {
                    diff = (int) (-(ldl.getDueDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24));
                } else {
                    diff = (int) (-(ldl.getDueDate().getTime() - ldl.getDateIn().getTime()) / (1000 * 60 * 60 * 24));
                }
                fine = (float) (diff * 0.25);
                String query = "insert into Fines values('" + ldl.getLoanId() + "','" + fine + "','" + 0 + "');";
                out.println("query:" + query + "<br>");
                Statement st = con.createStatement();
                i = st.executeUpdate(query);
                if (i == 1) {
                    msg = "All fines are updated...";
                    out.println(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher("CheckFines.jsp");
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
