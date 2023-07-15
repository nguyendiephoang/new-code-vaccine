package controller.bookingController;

import dal.AppointmentProvisionDAO;
import dal.HospitalDAO;
import dal.TimeRangeDAO;
import dal.LimitDAO;
import dal.VaccineProvisionDAO;
import dal.VaccineDAO;
import model.TimeRange;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TestLimitController", urlPatterns = {"/test-limit"})
public class TestLimitController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nameVaccine = "Measles, Mumps, Rubella (MMR) Vaccine";
        String nameHospital = "Thang Long";

        VaccineProvisionDAO vpDAO = new VaccineProvisionDAO();
        AppointmentProvisionDAO dao = new AppointmentProvisionDAO();
        TimeRangeDAO daoTr = new TimeRangeDAO();
        LimitDAO daoLm = new LimitDAO();

        int idHAP = HospitalDAO.getIdHByName(nameHospital);
        int idVaccine = VaccineDAO.getIdVacByName(nameVaccine);

        String idHAPt = Integer.toString(idHAP);
        String idVaccineAP = Integer.toString(idVaccine);

        List<Date> dates = dao.getDateByIdHosAndVac(idHAPt, idVaccine);
        ArrayList<String> dateInfo = new ArrayList<>();

        for (Date date : dates) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String s = date + "|";

            List<TimeRange> timeRanges = dao.getTimeRange(idHAPt, sqlDate, idVaccineAP);

            for (TimeRange timeRange : timeRanges) {
                s += "TimeRange{id=" + timeRange.getId() + ",";
                s += "startTime=" + timeRange.getStartTime() + ",";
                s += "endTime=" + timeRange.getEndTime() + ",";
                s += "quantity: " + daoLm.findQuantity(idVaccineAP, sqlDate, String.valueOf(timeRange.getId()), idHAPt) + ",";
                s += "quantityCA: " + daoLm.findQuantityCountA(idVaccineAP, sqlDate, String.valueOf(timeRange.getId()), idHAPt) + "}|";

            }

            // Remove the last pipe (|) symbol
            s = s.substring(0, s.length() - 1);
            dateInfo.add(s);
        }

        System.out.println("dateInfo = " + dateInfo);

        HttpSession session = request.getSession();
        session.setAttribute("dateInfo", dateInfo);

        request.setAttribute("nameVaccine", nameVaccine);
        request.setAttribute("nameHospital", nameHospital);
        request.getRequestDispatcher("/Booking/test.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
