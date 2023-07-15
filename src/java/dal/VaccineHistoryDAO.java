package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.VaccineHistory;

public class VaccineHistoryDAO {

    static Connection con = null;
    static PreparedStatement ps = null;
   static  ResultSet rs = null;

    public List<VaccineHistory> getHistoryByIdUser(String id) {
        List<VaccineHistory> list = new ArrayList<>();
        String query = "   SELECT u.username, u.gender, v.name AS vaccine_name, h.name AS hospital_name, vh.vaccineAt, vp.pricePerService AS price\n"
                + "FROM vaccine_history vh\n"
                + "INNER JOIN [user] u ON vh.idUserVH = u.idUser\n"
                + "INNER JOIN vaccine v ON vh.idVaccineVH = v.idVaccine\n"
                + "INNER JOIN hospital h ON vh.idHVH = h.idH\n"
                + "INNER JOIN vaccine_provision vp ON vh.idVaccineVH = vp.idVaccineVP AND vh.idHVH = vp.idHVP\n"
                + "WHERE vh.idUserVH = ?";
        try {
            con = new DBContext().getConnect(); // mo ket noi voi sql sever       
            ps = con.prepareStatement(query); //chay cau lenh query           
            ps.setString(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(new VaccineHistory(rs.getString(1), rs.getBoolean(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                        
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<VaccineHistory> getHistoryByIdHos(String id) {
        System.out.println("helloooo");
        List<VaccineHistory> list = new ArrayList<>();
        String query = "SELECT * From vaccine_history where idHVH = ?;";
        try {
            con = new DBContext().getConnect(); // mo ket noi voi sql sever
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new VaccineHistory(rs.getString(1), rs.getBoolean(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        VaccineHistoryDAO dao = new VaccineHistoryDAO();
        List<VaccineHistory> historyList = dao.getHistoryByIdUser("1003");
        for (VaccineHistory history : historyList) {
            System.out.println("Username: " + history.getUserName());
            System.out.println("Gender: " + (history.getGender()));
            System.out.println("Vaccine Name: " + history.getNameVaccine());
            System.out.println("Hospital Name: " + history.getNameHospital());
            System.out.println("Vaccinated At: " + history.getDate());
            System.out.println("Price: " + history.getPrice());
            System.out.println("---------------------------------------");
        }

    }

}
