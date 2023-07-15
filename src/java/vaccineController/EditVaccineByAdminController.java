/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vaccineController;

import dal.VaccineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author HUNTER
 */
@WebServlet(name = "EditVaccineByAdminController", urlPatterns = {"/edit"})
public class EditVaccineByAdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditVaccineByAdminController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditVaccineByAdminController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String pidVaccine = request.getParameter("idVaccine");
             String pname = request.getParameter("name");
             String pdetail = request.getParameter("detail");
 
             
             
             VaccineDAO dao = new VaccineDAO();
             dao.updateVaccine(pidVaccine, pname, pdetail);
                  response.sendRedirect("AdminManagerVaccine.jsp");
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               processRequest(request, response);
             
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
