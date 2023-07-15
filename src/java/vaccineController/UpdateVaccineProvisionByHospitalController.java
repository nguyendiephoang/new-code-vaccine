/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.vaccineController;

import dal.VaccineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HUNTER
 */
@WebServlet(name = "UpdateVaccineProvisionByHospitalController", urlPatterns = {"/updateVaccine"})
public class UpdateVaccineProvisionByHospitalController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateVaccineByHospitalController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateVaccineByHospitalController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String pidVaccine = request.getParameter("idVaccine");
             String pimg = request.getParameter("img");
             
             
               HttpSession session = request.getSession();
               int idHVP  = (int) session.getAttribute("id");
             String id  = String.valueOf(idHVP);
             String price = request.getParameter("pricePerService");
         
//             String pidVaccine ="2";
//             String id = "1";
             
             VaccineDAO dao = new VaccineDAO();
                dao.updateVaccineProvision(pidVaccine, pimg, id, price);
           
                  response.sendRedirect("hospitalManagerVaccineProvision.jsp");
    
    

    }
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
