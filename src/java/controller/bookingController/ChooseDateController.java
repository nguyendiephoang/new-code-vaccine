package controller.bookingController;

import dal.AppointmentProvisionDAO;
import dal.HospitalDAO;
import dal.VaccineDAO;
import dal.VaccineProvisionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.ls.LSOutput;

import model.TimeRange;
import model.VaccineProvision;

@WebServlet(urlPatterns = {"/ChooseDateController"})
public class ChooseDateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nameVaccine = request.getParameter("nameVaccine");
        String nameHospital = request.getParameter("nameHospital");

        VaccineProvisionDAO vpDAO = new VaccineProvisionDAO();
        AppointmentProvisionDAO dao = new AppointmentProvisionDAO();

        int idHAP = HospitalDAO.getIdHByName(nameHospital);
        int idVaccine = VaccineDAO.getIdVacByName(nameVaccine);
        String idHAPt = Integer.toString(idHAP);

        System.out.println("" + idHAPt + "\n" + idVaccine);
        List<Date> Dates = dao.getDateByIdHosAndVac(idHAPt, idVaccine);
        ArrayList<String> dateInfo = new ArrayList<>();
        for (Date date : Dates) {
            String s = date + "";
            s += "|" + dao.getTimeRange(idHAP + "", new java.sql.Date(date.getTime()), idVaccine + "");
            dateInfo.add(s);
        }

        // Lấy đối tượng HttpSession từ HttpServletRequest
        HttpSession session = request.getSession();

        session.setAttribute("dateInfo", dateInfo);

        request.setAttribute("nameVaccine", nameVaccine);
        request.setAttribute("nameHospital", nameHospital);
        request.getRequestDispatcher("/Booking/3.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
