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
import model.Vaccine;

/**
 *
 * @author HUNTER
 */
@WebServlet(name = "InsertVaccineByAdminControlle", urlPatterns = {"/add"})
public class InsertVaccineByAdminControlle extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertVaccineByAdminControlle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertVaccineByAdminControlle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                      processRequest(request, response);
    
        
     
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String name = request.getParameter("name");
      String detail = request.getParameter("detail");
      
      
        VaccineDAO  dao = new VaccineDAO();
        
        
      Vaccine vaccine = dao.checkVaccineByName(name);
        if (vaccine == null ) {
             dao.insertVaccine(name, detail);
//             request.getRequestDispatcher("AdminManagerVaccine2.jsp").forward(request, response);
  
                  request.getSession().setAttribute("addinforsucess", "The Vaccine added successfully");
                     request.getRequestDispatcher("AdminManagerVaccine.jsp").forward(request, response);
        } else {
//            request.setAttribute("mess1","The name of vaccine already exists" );
//            request.setAttribute("mess2","Please Enter Again !" );
//                   request.setAttribute("error","The name of vaccine already exists" );
//                             request.getRequestDispatcher("AdminManagerVaccine2.jsp").forward(request, response);
             request.getSession().setAttribute("existVaccine", "Vaccine was exist");
            request.getRequestDispatcher("AdminManagerVaccine.jsp").forward(request, response);
            
        }
      

       
     
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
