package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Vaccine;
import model.VaccineProvision;

public class VaccineDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static int getIdVacByIdAP(int int1) {
        int idVaccine = -1;
        String getIdSql = "Select [idVaccineAP] from [vaccine].[dbo].[appointment_provision] where [idAppointmentProvision] = "
                + int1;
        try ( Connection conn = getConnect()) {
            PreparedStatement stmt = conn.prepareStatement(getIdSql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                idVaccine = rs.getInt(1);
                return idVaccine;
            }
        } catch (Exception ex) {
            Logger.getLogger(VaccineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO Auto-generated method stub
        return idVaccine;
    }

    public List<Vaccine> getVaccineById(String idVaccine) {
        List<Vaccine> list = new ArrayList<>();
        String query = "SELECT TOP 1 vc.idVaccine, vc.name, vc.detail, vp.img\n"
                + "FROM vaccine vc\n"
                + "JOIN vaccine_provision vp ON vc.idVaccine = vp.idVaccineVP\n"
                + "WHERE vc.idVaccine = ?;";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, idVaccine);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static java.sql.Date getVacTimeByIdAP(int int1) {
        java.sql.Date date = null;
        String getIdSql = "Select [appointmentDateAt] from [vaccine].[dbo].[appointment_provision] where [idAppointmentProvision] = "
                + int1;
        try ( Connection conn = getConnect()) {
            PreparedStatement stmt = conn.prepareStatement(getIdSql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                date = rs.getDate(1);
                return date;
            }
        } catch (Exception ex) {
            Logger.getLogger(VaccineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO Auto-generated method stub
        return date;
    }

    public static int getIdHosByIdAP(int int1) {
        // TODO Auto-generated method stub
        int hos = -1;
        String getIdHosSql = "Select [idHAP] from [vaccine].[dbo].[appointment_provision] where [idAppointmentProvision] = "
                + int1;
        try ( Connection conn = getConnect()) {
            PreparedStatement stmt = conn.prepareStatement(getIdHosSql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                hos = rs.getInt(1);
                return hos;
            }
        } catch (Exception ex) {
            Logger.getLogger(VaccineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO Auto-generated method stub
        return hos;
    }

    // Nguyen Ngoc Nhan
    public List<Vaccine> getAllVaccine() {
        List<Vaccine> list = new ArrayList<>();
        String query = "select * from vaccine";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //Nguyen NGoc nHan
    public List<VaccineProvision> getAllVaccineWithHospital() {
        List<VaccineProvision> vaccines = new ArrayList<>();

        String query = "SELECT vp.idVaccineVP AS id, v.name AS name, v.detail AS detail, vp.pricePerService AS price, h.name AS hospital "
                + "FROM vaccine_provision vp "
                + "JOIN vaccine v ON vp.idVaccineVP = v.idVaccine "
                + "JOIN hospital h ON vp.idHVP = h.idH";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                double price = rs.getDouble("price");
                String hospital = rs.getString("hospital");

                VaccineProvision vaccine = new VaccineProvision(id, name, detail, price, name);
                vaccines.add(vaccine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vaccines;
    }

    public static int getIdVacByName(String nameVaccine) {
        String sql = "SELECT [idVaccine] FROM [dbo].[vaccine] WHERE [name] = ?";
        try ( Connection conn = getConnect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameVaccine); // Set the parameter value
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idVaccine");
            }
        } catch (Exception ex) {
            Logger.getLogger(VaccineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<VaccineProvision> getVaccinePerHospital(String userId) throws SQLException {
        List<VaccineProvision> provision = new ArrayList<>();

        String query = "SELECT a.idUserVaccineA, u.username, v.name AS vaccine_name, h.name AS hospital_name, "
                + "a.price, u.gender, ap.appointmentDateAt AS date, tr.startAt, tr.endAt "
                + "FROM appointment a "
                + "JOIN [user] u ON a.idUserVaccineA = u.idUser "
                + "JOIN appointment_provision ap ON a.idAppoinmentProvisionA = ap.idAppointmentProvision "
                + "JOIN vaccine v ON ap.idVaccineAP = v.idVaccine "
                + "JOIN hospital h ON ap.idHAP = h.idH "
                + "JOIN time_range tr ON ap.idTimeRangeAP = tr.idTimeRange "
                + "WHERE a.idUserVaccineA = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                provision.add(new VaccineProvision(rs.getInt("idVaccine"), rs.getString("name"),
                        rs.getString("detail"), rs.getDouble("pricePerService"), rs.getString("nameH")));
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây (ví dụ: ghi log, ném ngoại lệ hoặc thông báo lỗi)
        } finally {
            // Đảm bảo đóng các tài nguyên
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return provision;
    }
//NNN

    public List<VaccineProvision> getAllVaccineProvision(String idHVP) {
        List<VaccineProvision> list = new ArrayList<>();
        String query = "SELECT v.idVaccine, v.name, v.detail, vp.pricePerService, vp.img\n"
                + "FROM vaccine_provision vp\n"
                + "JOIN vaccine v ON vp.idVaccineVP = v.idVaccine\n"
                + "WHERE vp.idHVP = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, idHVP);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idVaccine = rs.getInt(1);
                String name = rs.getString(2);
                String detail = rs.getString(3);
                double pricePerService = rs.getDouble(4);
                String img = rs.getString(5);

                VaccineProvision vaccineProvision = new VaccineProvision(idVaccine, name, detail, pricePerService, img, name);
                list.add(vaccineProvision);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return list;
    }

    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalVaccine() {
        String query = "select count(*) from vaccine";
        try {
            conn = new DBContext().getConnect();             //Mo ket noi voi SQL sever
            ps = conn.prepareStatement(query);                  //Chuyen cau lenh o Query vao
            rs = ps.executeQuery();                             //Chay cau lenh Query
            //Lay du lieu o "rs" dua vao "list"
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    //NNN
    public void insertVaccine(String name, String detail) {
        String query = "INSERT INTO vaccine (name, detail)\n"
                + "VALUES (?,?);";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//NNN

    public void updateVaccine(String idVaccine, String name, String detail) {
        String query = "UPDATE vaccine "
                + "SET name = ?, detail = ? "
                + "WHERE idVaccine = ?";
        try {
            conn = new DBContext().getConnect(); // mở kết nối với SQL server
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.setString(3, idVaccine);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//nnn

    public void deleteVaccine(String dvid) {
        String query = "DELETE FROM vaccine WHERE idVaccine = ?";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, dvid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Vaccine> searchByName(String txtSearch) {
        List<Vaccine> list = new ArrayList<>();
        String query = "select * from vaccine\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Vaccine> getPage(int numPage) {
        List<Vaccine> list = new ArrayList<>();
        String query = "select * from vaccine order by idVaccine offset ? ROWS FETCH next 5 ROWS only;";
        try {
            conn = new DBContext().getConnect();             //Mo ket noi voi SQL sever
            ps = conn.prepareStatement(query);                  //Chuyen cau lenh o Query vao
            ps.setInt(1, (numPage - 1) * 5);
            rs = ps.executeQuery();                             //Chay cau lenh Query
            while (rs.next()) {
                list.add(new Vaccine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //NNN ko su dung
    public Vaccine checkVaccineByName(String name) {
        String query = "SELECT idVaccine, name, detail FROM vaccine WHERE name = ?";

        try {
            conn = new DBContext().getConnect(); // mo ket noi voi sql sever
            ps = conn.prepareStatement(query); //chay cau lenh query
            ps.setString(1, name);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Vaccine(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));

            }
        } catch (Exception e) {
        }
        return null;
    }
// code get vaccine and edit vaccine by hospital

    public void updateVaccineProvision(String idVaccine, String img, String id, String pricePerService) {

        String sql = "UPDATE vaccine_provision SET img = ?, pricePerService = ? WHERE idVaccineVP = ? AND idHVP = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(sql);
            ps.setString(1, img);
            ps.setString(2, pricePerService);
            ps.setString(3, idVaccine);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo kết nối và PreparedStatement được đóng ngay cả khi có ngoại lệ xảy ra
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertVaccineProvison(String idVaccine, String idHVP, String price, String img) {
        String query = "INSERT INTO [dbo].[vaccine_provision] ([idVaccineVP], [idHVP], [img], [pricePerService])\n"
                + "VALUES (?,? ,? ,? );";
        try {
            conn = new DBContext().getConnect(); // Mở kết nối với cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, idVaccine);
            ps.setString(2, idHVP);
            ps.setString(3, img);
            ps.setString(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo kết nối và PreparedStatement được đóng ngay cả khi có ngoại lệ xảy ra
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // kiem tra id ton tai cua vacccine provison Nguyen Ngoc Nhan
    public VaccineProvision checkExistVaccineProvsionById(String idVaccine) {
        String query = "SELECT *\n"
                + "FROM [dbo].[vaccine_provision]\n"
                + "WHERE [idVaccineVP] = ?;";

        try {
            conn = new DBContext().getConnect(); // mo ket noi voi sql sever
            ps = conn.prepareStatement(query); //chay cau lenh query
            ps.setString(1, idVaccine);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new VaccineProvision(rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));

            }
        } catch (Exception e) {
        }
        return null;
    }

    // Nguyen Ngoc Nhan updae date : 16/7/2023
    public boolean isVaccineProvisionExist(String idVaccine, String idHVP) {
        boolean isExist = false;
        String query = "SELECT COUNT(*) AS count FROM [dbo].[vaccine_provision] WHERE [idVaccineVP] = ? AND [idHVP] = ?";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, idVaccine);
            ps.setString(2, idHVP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                isExist = count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isExist;
    }

    public String getVacNameByVacId(int int1) {
        // TODO Auto-generated method stub
        String sql = "select name from vaccine where idVaccine = " + int1;
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
//		System.out.println(getIdVacFrIdAP(2));
        System.out.println(getIdVacByName("vaccine 2"));
//		System.out.println(getIdHosByIdAP(2));
    }

}
