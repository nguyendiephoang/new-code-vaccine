/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import static dal.AppointmentProvisionDAO.ps;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.AppointmentProvision;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class LimitDAO {

    public static int findQuantity(String idVaccineAP, java.sql.Date date, String idTimeRangeAP, String idHAP) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int quantity = 0;

        try {
            conn = new DBContext().getConnect();
            String query = "SELECT quantity FROM appointment_provision\n"
                    + "WHERE idVaccineAP = ? AND appointmentDateAt = ? AND idTimeRangeAP = ? AND idHAP = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, idVaccineAP);
            ps.setDate(2, date);
            ps.setString(3, idTimeRangeAP);
            ps.setString(4, idHAP);
            rs = ps.executeQuery();

            if (rs.next()) {
                quantity = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantity;
    }

    public static int findQuantityCountA(String idVaccineAP, java.sql.Date date, String idTimeRangeAP, String idHAP) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int quantityCA = 0;

        try {
            conn = new DBContext().getConnect();
            String query = "SELECT count(*) from appointment a\n"
                    + "JOIN appointment_provision ap ON ap.idAppointmentProvision = a.idAppoinmentProvisionA\n"
                    + "WHERE idVaccineAP = ? AND appointmentDateAt = ? AND idTimeRangeAP = ? AND idHAP = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, idVaccineAP);
            ps.setDate(2, date);
            ps.setString(3, idTimeRangeAP);
            ps.setString(4, idHAP);
            rs = ps.executeQuery();

            if (rs.next()) {
                quantityCA = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantityCA;
    }

    public boolean updateQuantity(String idVaccineAP, java.sql.Date date, String idTimeRangeAP, String idHAP, String newQuantity) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean success = false;

        try {
            conn = new DBContext().getConnect();
            String query = "UPDATE appointment_provision SET quantity = ? WHERE idVaccineAP = ? AND appointmentDateAt = ? AND idTimeRangeAP = ? AND idHAP = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, newQuantity);
            ps.setString(2, idVaccineAP);
            ps.setDate(3, date);
            ps.setString(4, idTimeRangeAP);
            ps.setString(5, idHAP);

            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void main(String[] args) {
        String idVaccineAP = "2";
        LocalDate localDate = LocalDate.of(2023, 10, 15);
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        String idTimeRangeAP = "5";
        String idHAP = "1";
//        String newQuantity = "8";

//         Create an instance of your class containing the findQuantity method
        LimitDAO dao = new LimitDAO();

        // Call the findQuantity method
        int quantityCA = dao.findQuantityCountA(idVaccineAP, date, idTimeRangeAP, idHAP);

//        boolean success = dao.updateQuantity(idVaccineAP, date, idTimeRangeAP, idHAP, newQuantity);
//
//        if (success) {
//            System.out.println("Update successful");
//        } else {
//            System.out.println("Update failed");
//        }
        int quantity = dao.findQuantity(idVaccineAP, date, idTimeRangeAP, idHAP);

        // Process the result
        System.out.println("Quantity: " + quantity);
        System.out.println("quantityCA: " + quantityCA);

    }
}
