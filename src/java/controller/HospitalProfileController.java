/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.Encrypt;
import dal.HospitalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hospital;

/**
 *
 * @author DELL
 */
@WebServlet(name = "HospitalProfileController", urlPatterns = {"/HospitalProfileController"})
public class HospitalProfileController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HospitalProfileController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HospitalProfileController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HospitalDAO db = new HospitalDAO();
        try {
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("id");
            Encrypt en = new Encrypt();
            Hospital h = db.findHospitalById(id);
            Hospital hos = new Hospital(h.getIdBV(), h.getName(), h.getAddress(), h.getEmail(), h.getHotline(), "", "");
            System.out.println(hos);
            session.setAttribute("hospital", hos);

            response.sendRedirect("hospital_profile.jsp#infor");

        } catch (Exception ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            String name = request.getParameter("name");
               String address = request.getParameter("address");
            String hotline = request.getParameter("hotline");
            String email = request.getParameter("email");                    
            HospitalDAO hb = new HospitalDAO();
            Hospital hbHotline = hb.findHospitalByHotline(hotline);
            Hospital hbEmail = hb.findHospital(email);
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("id");
            Hospital h = hb.findHospitalById(id);
            if ((hbHotline != null && hbHotline.getIdBV() != id)
                    || (hbEmail != null && hbEmail.getIdBV() != id)) {

                if (hbHotline != null && hbHotline.getIdBV() != id) {
                    request.getSession().setAttribute("ExistHotline", "Exist hotline");
                }
                if (hbEmail != null && hbEmail.getIdBV() != id) {
                    request.getSession().setAttribute("ExistEmail", "Exist email");
                }
            } else {
               hb.updateHospital(id, name, address, email, hotline);
                request.getSession().setAttribute("updateinforsucess", "Password was change succesfully");
            }
            response.sendRedirect("HospitalProfileController");
            response.sendRedirect("hospital_profile.jsp#infor");
        } catch (Exception ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
