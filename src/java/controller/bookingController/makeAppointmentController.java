package controller.bookingController;

import dal.AppointmentDAO;
import dal.AppointmentProvisionDAO;
import dal.HospitalDAO;
import dal.LimitDAO;
import dal.TimeRangeDAO;
import dal.VaccineDAO;
import dal.VaccineProvisionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appointment;

@WebServlet(urlPatterns = {"/makeAppointmentController"})
public class makeAppointmentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameVaccine = request.getParameter("nameVaccine");
        String nameHospital = request.getParameter("nameHospital");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String selectedDateTime = request.getParameter("selectedDateTime");
        
        HttpSession session = request.getSession();
        int idUser = (int) session.getAttribute("id");

        String[] dateTimeParts = selectedDateTime.split(", ");
        String dateS = dateTimeParts[0].substring(6);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        System.out.println("IdUser = "+ idUser);
        try {
            utilDate = dateFormat.parse(dateS);
        } catch (ParseException e) {
            // Xử lý ngoại lệ ParseException tại đây
            e.printStackTrace();
        }

        if (utilDate != null) {
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            String timeRange = dateTimeParts[1].substring(12);

            String startTime = timeRange.split(" - ")[0];
            String endTime = timeRange.split(" - ")[1];

            VaccineDAO dao = new VaccineDAO();
            TimeRangeDAO daoTr = new TimeRangeDAO();
            AppointmentProvisionDAO daoAP = new AppointmentProvisionDAO();
            VaccineProvisionDAO vpDAO = new VaccineProvisionDAO();

            int idHAP = HospitalDAO.getIdHByName(nameHospital);
            int timeRangeId = daoTr.findIdTimeRange(startTime, endTime);
            int idAppointmentProvision = daoAP.findIdAppointmentProvision(timeRangeId, date, idHAP);
            int idVc = dao.getIdVacByName(nameVaccine);
            int price = vpDAO.getPrice(idHAP, idVc);
            String priceS = Integer.toString(price);

            //         Create an instance of your class containing the findQuantity method
            LimitDAO daoLm = new LimitDAO();
            String idHAPt = Integer.toString(idHAP);
            String idTR = Integer.toString(timeRangeId);
            String idVaccineAP = Integer.toString(idVc);

            // Call the findQuantity method
            int quantityCA = daoLm.findQuantityCountA(idVaccineAP, date, idTR, idHAPt);
            int quantity = daoLm.findQuantity(idVaccineAP, date, idTR, idHAPt);

            int quantityVaccine = (quantity - quantityCA);

            if (quantityVaccine <= 0) {
                // Không đủ vaccine để thực hiện cuộc hẹn
                // Xử lý thông báo hoặc thực hiện các hành động phù hợp
                String result = "You can't booking because overcrowded";
                System.out.println("Da qua so luong booking");
                response.sendRedirect("/Vaccine_testver1/Booking/3.jsp");

            } else {
                AppointmentDAO.makeAppointment(idUser, idUser, idAppointmentProvision, priceS);
                // Tiếp tục xử lý hoặc thực hiện các hành động khác sau khi insert dữ liệu

                // Chuyển hướng hoặc trả về kết quả cho trình duyệt
                // Ví dụ: Chuyển hướng đến trang xác nhận đặt lịch
                response.sendRedirect("/Vaccine_testver1/Booking/successBooking.jsp");
            }

            // Process the result
            System.out.println("Quantity: " + quantity);
            System.out.println("quantityCA: " + quantityCA);
            System.out.println("quantityVaccine: " + quantityVaccine);
//
//            System.out.println("Name Vaccine: " + nameVaccine);
//            System.out.println("Name Hospital: " + nameHospital);
//            System.out.println("Name: " + name);
//            System.out.println("Phone: " + phone);
//            System.out.println("Email: " + email);
//            System.out.println("date: " + date);
//            System.out.println("idAppointmentProvision: " + idAppointmentProvision);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
