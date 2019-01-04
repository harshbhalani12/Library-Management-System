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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class CheckOutfromDbServlet extends HttpServlet {

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
        RequestDispatcher rd;
        String msg="";
        try {
            boolean flag = true;
            String Isbn10 = request.getParameter("Isbn10");
            String CardNo = request.getParameter("CardNo");
            String query;
//            out.println(Isbn10 + "" + CardNo);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
            HttpSession hs = request.getSession();
            if (Isbn10.equals("") || CardNo.equals("")) {
                msg = "Card Number is null. Please enter card number..";
            } else {
//                out.println("else null vala ");

                String query1 = "select * from Book_Loans where Isbn10 = '" + Isbn10 + "'AND DateIn is null;";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query1);
                if (rs.next()) {
                    out.println("Book is not available");
                    flag = false;
                    msg = "Book is not available";
                }

                String query5 = "select CardId from Borrower where CardId = '"+CardNo+"'";
            Statement st5 = con.createStatement();
            ResultSet rs5 = st5.executeQuery(query5);
            if(!(rs5.next())){
                flag = false;
                msg = "This card number is not exists...";
//                rd = request.getRequestDispatcher("CheckIn.jsp");
//                rd.forward(request, response);
            }
                
                
                String query4 = "select count(*) from Book_Loans where CardId = '" + CardNo + "' AND DateIn is null Group By CardId;";
                Statement st4 = con.createStatement();
                ResultSet rs4 = st4.executeQuery(query4);
                if (rs4.next()) {
                    int count = Integer.parseInt(rs4.getString(1));
                    if (count >= 3) {
                        flag = false;
                        out.println("Not more than 3 books");
                        msg = "Not more than 3 books are allowed.";
                    }
                }
                

                if (flag) {
                    out.println("flag is true");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date_out = new Date();

                    Calendar c = new GregorianCalendar();
                    Date due_date = c.getTime();
                    System.out.println(dateFormat.format((due_date)));
                    c.add(Calendar.DATE, 14);
                    due_date = c.getTime();
                    String query3 = "insert into Book_Loans(Isbn10,CardId, DateOut,DueDate) values ('" + Isbn10 + "','" + CardNo + "','" + dateFormat.format(date_out) + "','" + dateFormat.format(due_date) + "');";
                    out.println(query3);
                    Statement st3 = con.createStatement();
                    int i = st3.executeUpdate(query3);
                    if(i==1){
                        msg = "Book is issued. Due Date is "+due_date;
                        out.println(msg);
                    }else{
                        out.println("in else");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            request.setAttribute("msg",msg);
            out.println(request.getAttribute("msg"));
            rd = request.getRequestDispatcher("CheckOutBooksServlet");
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
