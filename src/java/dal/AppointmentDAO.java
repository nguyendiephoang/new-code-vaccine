package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import model.Hospital;
import model.TimeRange;

public class AppointmentDAO {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

// Get Appointment by idUsers
    public List<Appointment> getAppointments(String userId) {
        List<Appointment> appointments = new ArrayList<>();

        String query = "SELECT a.idAppointment, a.idUserVaccineA, u.username, v.name AS vaccine_name, h.name AS hospital_name, "
                + "a.price, u.gender, ap.appointmentDateAt AS date, tr.startAt, tr.endAt " + "FROM appointment a "
                + "JOIN [user] u ON a.idUserVaccineA = u.idUser "
                + "JOIN appointment_provision ap ON a.idAppoinmentProvisionA = ap.idAppointmentProvision "
                + "JOIN vaccine v ON ap.idVaccineAP = v.idVaccine " + "JOIN hospital h ON ap.idHAP = h.idH "
                + "JOIN time_range tr ON ap.idTimeRangeAP = tr.idTimeRange " + "WHERE a.idUserVaccineA = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                appointments.add(new Appointment(rs.getInt("idAppointment"), rs.getInt("idUserVaccineA"), rs.getString("username"),
                        rs.getString("vaccine_name"), rs.getString("hospital_name"), rs.getDouble("price"),
                        rs.getString("gender"), rs.getString("date"), rs.getString("startAt"), rs.getString("endAt")));
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây (ví dụ: ghi log, ném ngoại lệ hoặc thông báo lỗi)
        }

        return appointments;
    }

    // Get Appointment by idHospital
    public static List<Appointment> getAppointmentsByHospitalId(String hospitalId) {
        List<Appointment> appointmentsByH = new ArrayList<>();

        String query = "SELECT a.idAppointment, a.idUserVaccineA, u.username, v.name AS vaccine_name, h.name AS hospital_name, "
                + "a.price, u.gender, ap.appointmentDateAt AS date, tr.startAt, tr.endAt " + "FROM appointment a "
                + "JOIN [user] u ON a.idUserVaccineA = u.idUser "
                + "INNER JOIN appointment_provision ap ON a.idAppoinmentProvisionA = ap.idAppointmentProvision "
                + "INNER JOIN vaccine v ON ap.idVaccineAP = v.idVaccine " + "INNER JOIN hospital h ON ap.idHAP = h.idH "
                + "INNER JOIN time_range tr ON ap.idTimeRangeAP = tr.idTimeRange " + "WHERE h.idH = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, hospitalId);
            rs = ps.executeQuery();
            while (rs.next()) {
                appointmentsByH.add(new Appointment(rs.getInt("idAppointment"), rs.getInt("idUserVaccineA"), rs.getString("username"),
                        rs.getString("vaccine_name"), rs.getString("hospital_name"), rs.getDouble("price"),
                        rs.getString("gender"), rs.getString("date"), rs.getString("startAt"), rs.getString("endAt")));
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây (ví dụ: ghi log, ném ngoại lệ hoặc thông báo lỗi)
        }
        return appointmentsByH;
    }

    public static void makeAppointment(int idUserVaccineA, int idUserBooked, int idAP, String price) {
        String query = "INSERT INTO appointment(idUserVaccineA, idUserBookedA, idAppoinmentProvisionA, status, price) values (?, ?, ?, 'Booked', ?)";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idUserVaccineA);
            ps.setInt(2, idUserBooked);
            ps.setInt(3, idAP);
            ps.setString(4, price);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteAppointment(String apId) {
        String query = "delete from appointment where idAppointment = ?";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, apId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        appointmentDAO.deleteAppointment("50");

//        for (Appointment a : appointmentDAO.getAppointments("1003")) {
//            System.out.println(a);
//        }
//        for (Appointment a : appointmentDAO.getAppointmentsByHospitalId("2")) {
//            System.out.println(a);
//
//        }
        //Insert lich hen tiem
//        String phone = "0909900009";
//        String email = "nomnom15062002@gmail.com";
//        String vaccineName = "vaccine 2";
//        String hospitalName = "Thang Long";
//        LocalDate localDate = LocalDate.of(2023, 01, 16);
//        java.sql.Date date = java.sql.Date.valueOf(localDate);
//        Time startTime = Time.valueOf("11:30:00");
//        Time endTime = Time.valueOf("13:00:00");
//
//        AppointmentDAO.insertAppointment(phone, email, vaccineName, hospitalName, date, startTime, endTime);
//        String username = "NGKN";
//        String email = "nhatnkde160626@fpt.edu.vn";
//        String vaccineName = "vaccine 2";
//        String hospitalName = "Ba Dinh";
//        java.sql.Date appointmentDate = java.sql.Date.valueOf("2023-10-12");
//        Time startTime = Time.valueOf("10:00:00");
//        Time endTime = Time.valueOf("11:30:00");
//        AppointmentDAO.insertAppointment(username, email, vaccineName, hospitalName, appointmentDate, startTime, endTime);
//        AppointmentDAO.makeAppointment(1004, 1004, 20, "333");
        //In ra lich hen tiem theo idH
//        String hospitalId = "1";
//        List<Appointment> appointments = appointmentDAO.getAppointmentsByHospitalId(hospitalId);
//        for (Appointment appointment : appointments) {
//            System.out.println("Appointment ID: " + appointment.getIdAppointment());
//            System.out.println("Appointment ID: " + appointment.getIdUserVaccineA());
//            System.out.println("Username: " + appointment.getUsername());
//            System.out.println("Vaccine Name: " + appointment.getVaccineName());
//            System.out.println("Hospital Name: " + appointment.getHospitalName());
//            System.out.println("Price: " + appointment.getPrice());
//            System.out.println("Gender: " + appointment.getGender());
//            System.out.println("Date: " + appointment.getDate());
//            System.out.println("Start Time: " + appointment.getStartAt());
//            System.out.println("End Time: " + appointment.getEndAt());
//            System.out.println("-----------------------------------------");
//        }
    }

    public static int getBookedByIdAP(int int1) {
        // TODO Auto-generated method stub
        String query = "select count(*) from appointment where idAppoinmentProvisionA = " + int1;
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public static int existAppointnmentProvision(int idAP) {
        // TODO Auto-generated method stub
        String sql = "select idAppointment from appointment where idAppoinmentProvisionA = ?";
        int idAppointment = -1;
        try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAP);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idAppointment = rs.getInt(1);
                    System.out.println("There is idAppointment " + idAppointment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idAppointment;
    }

    public static void deleteAppointmentByAP(int idAP) {

        String sql = "delete from appointment where idAppoinmentProvisionA = ?";
        try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAP);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
