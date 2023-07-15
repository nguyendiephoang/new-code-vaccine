package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TimeRange;

public class TimeRangeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<TimeRange> getTimeRange() {
        List<TimeRange> list = new ArrayList<>();
        String query = "select * from time_range";
        try {
            conn = new DBContext().getConnect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeRange(rs.getInt(1), rs.getTime(2), rs.getTime(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<String> getTimeRangeList() {
        ArrayList<String> list = new ArrayList<>();
        String query = "select * from time_range";
        try {
            conn = new DBContext().getConnect();// mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add((rs.getTime(2) + "").substring(0, 5) + "-" + (rs.getTime(3) + "").substring(0, 5));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getTimeRangeById(int int1) {
        String query = "SELECT * FROM time_range WHERE idTimeRange = " + int1;

        try {
            String result = "";
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
//	            System.out.println("chao");   
                java.sql.Time start = rs.getTime(2);
                java.sql.Time end = rs.getTime(3);
//	            System.out.println("Start: " + (start+"").substring(0, 5));
//	            System.out.println("End: " + (end+"").substring(0, 5));
                return (start + "").substring(0, 5) + " " + (end + "").substring(0, 5);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception to see any errors
        }
        return "hi";
    }

    public static String getIdTimeRangeByTimeRange(String timeRange) {
        String[] timeParts = timeRange.split(" ");
        String startAt = timeParts[0];
        String endAt = timeParts[1];

        String sql = "SELECT idTimeRange FROM time_range WHERE startAt = ? AND endAt = ?";
        String idTimeRange = null;

        try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, startAt);
            ps.setString(2, endAt);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idTimeRange = rs.getString("idTimeRange");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idTimeRange;
    }
    
    
    public int findIdTimeRange(String startAt, String endAt) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int timeRangeId = 0;

        try {
            conn = new DBContext().getConnect();
            String query = "SELECT idTimeRange FROM time_range WHERE startAt = ? AND endAt = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, startAt);
            ps.setString(2, endAt);
            rs = ps.executeQuery();

            if (rs.next()) {
                timeRangeId = rs.getInt("idTimeRange");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo giải phóng tài nguyên khi kết thúc
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return timeRangeId;
    }

    public static void main(String[] args) {
        TimeRangeDAO dao = new TimeRangeDAO();
        List<TimeRange> list = dao.getTimeRange();
        for (TimeRange o : list) {
            System.out.println(o);
        }
    }
}
