/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.bookingController;

import com.google.gson.Gson;
import controller.UserProfileController;
import dal.AppointmentDAO;
import dal.Encrypt;
import dal.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class UserManagerController extends HttpServlet {

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
        UserDAO db = new UserDAO();
        try {
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("id");
            AppointmentDAO appointmentDAO = new AppointmentDAO();
            String userId = String.valueOf(id);
            
            System.out.println("idUser = "+userId);
            List<Appointment> appointments = appointmentDAO.getAppointments(userId);
            System.out.println("appointments: " + appointments);
            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("/Booking/userBooking.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAp = request.getParameter("idAppointment");
//        String idAp = "82";
        System.out.println("idAp = " + idAp);

        // Xóa dữ liệu tương ứng
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        appointmentDAO.deleteAppointment(idAp);

        // Tiếp tục xử lý và tải lại dữ liệu (nếu cần)
        response.sendRedirect("/Booking/userBooking.jsp#infor");
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
