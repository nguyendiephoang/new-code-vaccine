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
import model.VaccineProvision;


/**
 *
 * @author HUNTER
 */
@WebServlet(name = "AddVaccineProvisionByHospitalController", urlPatterns = {"/addVaccineProvision"})
public class AddVaccineProvisionByHospitalController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddVaccineProvision</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddVaccineProvision at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String idVaccine = request.getParameter("idVaccine");

        String price = request.getParameter("pricePerService");
        String img = request.getParameter("img");

        HttpSession session = request.getSession();
        int idHVP = (int) session.getAttribute("id");
        String id = String.valueOf(idHVP);

        VaccineDAO dao = new VaccineDAO();

        VaccineProvision vaccine = dao.checkExistVaccineProvsionById(idVaccine);

        if (vaccine == null) {

            dao.insertVaccineProvison(idVaccine, id, price, img);

            response.sendRedirect("hospitalManagerVaccineProvision.jsp");
        } else {
            request.setAttribute("mess1", "The Id Vaccin  already exists in your System");
            request.setAttribute("mess2", "Please Enter Again !");
            request.getRequestDispatcher("addVaccineProvision.jsp").forward(request, response);

        }

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
