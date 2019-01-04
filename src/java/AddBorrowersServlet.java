/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Borrower;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Admin
 */
public class AddBorrowersServlet extends HttpServlet {

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
        try {

            String page = "AddBorrower.jsp";

            out.println("hi");

            out.println("hi");

            String fname, lname, ssn, email, address, city, state, phone;
            fname = request.getParameter("firstName");
            lname = request.getParameter("lastName");
            ssn = request.getParameter("ssn");
            email = request.getParameter("emailId");
            address = request.getParameter("address");
            city = request.getParameter("city");
            state = request.getParameter("state");
            phone = request.getParameter("phoneNumber");

            if (fname.equals("") || lname.equals("") ||ssn.equals("") || email.equals("") ||address.equals("") ||city.equals("") ||state.equals("") || phone.equals("")) {
                
                request.setAttribute("error", "Please enter all mendatory details...");
                rd = request.getRequestDispatcher("AddBorrower.jsp");
                rd.forward(request, response);
            } else if(ssn.length()>9 || ssn.length()<9){
                request.setAttribute("error", "SSN should be 9 digit long...");
                rd = request.getRequestDispatcher("AddBorrower.jsp");
                rd.forward(request, response);
            }else if(phone.length() >10 || phone.length()<10){
                request.setAttribute("error", "Phone number should be 10 digit long...");
                rd = request.getRequestDispatcher("AddBorrower.jsp");
                rd.forward(request, response);
            }
            else {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=tpDb3CSV", "sa", "Dspshy29");
//            out.println("class");

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from Borrower");

                String flag = "notFound";
                while (rs.next()) {
                    String ssn1 = Integer.toString(rs.getInt(2));
                    if (ssn.equals(ssn1)) {
                        flag = "found";
                        request.setAttribute("error", "Person is already registered. Can not register again..");
                        page = "AddBorrower.jsp";
                        break;
                    }
                }

                if (flag.equals("notFound")) {
                    out.print("in not found if");
                    String query = "insert into borrower(Ssn,FirstName, LastName, Email, Address, City, State, Phone) values('" + ssn + "','" + fname + "','" + lname + "','" + email + "','" + address + "','" + city + "','" + state + "','" + phone + "');";
                    out.println("<br>" + query);
                    Statement st1 = con.createStatement();
                    st1.executeUpdate(query);
                    out.println("added");

                    request.setAttribute("msg", "Added Successfully.");

                    query = "select CardId from Borrower where Ssn = '" + ssn + "';";
                    Statement st2 = con.createStatement();
                    ResultSet rs1 = st2.executeQuery(query);
                    int cardId = 0;
                    while (rs1.next()) {
                        cardId = rs1.getInt(1);
                    }

                    request.setAttribute("msg2", cardId);
//                page = "ReturnCardId.jsp";

                }
                con.close();

                rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
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
