package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppointmentProvision;
import model.TimeRange;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class AppointmentProvisionDAO {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static List<TimeRange> getTimeRange(String idHAP, java.sql.Date date, String idVaccine) {
        List<TimeRange> TimeRange = new ArrayList<>();

        String query = "SELECT *\n"
                + "FROM appointment_provision\n"
                + "INNER JOIN time_range ON idTimeRangeAP = idTimeRange\n"
                + "WHERE idHAP = ? AND appointmentDateAt = ? AND idVaccineAP = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(idHAP));
            ps.setDate(2, date);
            ps.setInt(3, Integer.parseInt(idVaccine));

            rs = ps.executeQuery();
            while (rs.next()) {

                // Thêm các cột còn thiếu trong câu truy vấn vào constructor của đối tượng Appointment
                TimeRange.add(new TimeRange(
                        rs.getInt(5),
                        rs.getTime(8),
                        rs.getTime(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TimeRange;
    }

//    public static Integer createAppointmentProvision(int idHAP, int idVac, java.sql.Date date, int quantity, int idTimeRange) {
//        String query = "INSERT INTO appointment_provision(idHAP, idVaccineAP, appointmentDateAt, quantity, idTimeRangeAP) values (?, ?, ?, ?, ?)";
//
//        // Use try-with-resources to automatically close the PreparedStatement and ResultSet
//        try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//
//            ps.setInt(1, idHAP);
//            ps.setInt(2, idVac);
//            ps.setDate(3, date);
//            ps.setInt(4, quantity);
//            ps.setInt(5, idTimeRange);
//
//            int rowsAffected = ps.executeUpdate();
//
//            // Check if any rows were affected by the query
//            if (rowsAffected == 0) {
//                return null;
//            }
//            // Get the auto-generated key for the new appointment_provision record
//            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//
//                // Check if any auto-generated keys were returned
//                if (generatedKeys.next()) {
//                    // Return the ID of the new appointment_provision record
//                    return generatedKeys.getInt(1);
//                } else {
//                    // Return null if no auto-generated keys were returned
//                    return null;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    
public static Integer createAppointmentProvision(String idH, String idVac, String date, String quantity,
			String idTimeRange) {
		String query = "INSERT INTO appointment_provision(idHAP, idVaccineAP, appointmentDateAt, quantity, idTimeRangeAP) values (?, ?, ?, ?, ?)";

		try (Connection conn = new DBContext().getConnect();
				PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, idH);
			ps.setString(2, idVac);
			ps.setString(3, date);
			ps.setString(4, quantity);
			ps.setString(5, idTimeRange);

			int rowsAffected = ps.executeUpdate();

			// Check if any rows were affected by the query
			if (rowsAffected == 0) {
				return null;
			}
			// Get the auto-generated key for the new appointment_provision record
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {

				// Check if any auto-generated keys were returned
				if (generatedKeys.next()) {

					// Return the ID of the new appointment_provision record
					return generatedKeys.getInt(1);
				} else {

					// Return null if no auto-generated keys were returned
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
    
    
    public static List<Date> getDate(String idHAP) {
        List<Date> appointmentDates = new ArrayList<>();

        String query = "SELECT DISTINCT appointmentDateAt\n"
                + "FROM appointment_provision WHERE idHAP = ?\n"
                + "ORDER BY appointmentDateAt ASC;";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, idHAP);
            rs = ps.executeQuery();
            while (rs.next()) {
                Date appointmentDate = rs.getDate("appointmentDateAt");
                appointmentDates.add(appointmentDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointmentDates;
    }

    public static List<Date> getDateByIdHosAndVac(String idHAP, int idVac) {
        List<Date> appointmentDates = new ArrayList<>();

        String query = "SELECT DISTINCT appointmentDateAt\n"
                + "FROM appointment_provision WHERE idHAP = ? and idVaccineAP = ?\n"
                + "ORDER BY appointmentDateAt ASC;";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, idHAP);
            ps.setInt(2, idVac);
            rs = ps.executeQuery();
            while (rs.next()) {
                Date appointmentDate = rs.getDate("appointmentDateAt");
                appointmentDates.add(appointmentDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointmentDates;
    }

    public static int getIdByBookingInfo(String idVaccine, String idHAP, String date, String timeRange) {
        String query = "SELECT idAppointmentProvision FROM Appointment_Provision WHERE idHAP = ?  AND appointmentDateAt = ? AND idVaccineAP = ? AND idTimeRangeAP = ?";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(idHAP));
            ps.setInt(3, Integer.parseInt(idVaccine));

            ps.setInt(4, Integer.parseInt(timeRange));
            LocalDate localDate = LocalDate.of(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1]), Integer.parseInt(date.split("-")[2]));
            java.sql.Date dateSQL = java.sql.Date.valueOf(localDate);
            ps.setDate(2, dateSQL);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("idAppointmentProvision");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static ArrayList<String> dateInfo(int idH, String month) {
		ArrayList<String> result = new ArrayList<>();
		String sqlAP;
		String sqlA;
		int maxDays;
		String m;
		sqlA = "select * from appointment where idAppoinmentProvisionA = ?";
		if (month == "") {
			String currentMonth = LocalDate.now().getMonthValue() + "";
			maxDays = YearMonth.of(LocalDate.now().getYear(), Integer.parseInt(currentMonth)).lengthOfMonth();
			String formattedMonth = String.format("%02d", Integer.parseInt(currentMonth));
			m = formattedMonth;
			sqlAP = "SELECT * from Appointment_Provision WHERE appointmentDateAt LIKE '%" + formattedMonth
					+ "-%' and idHAP =" + idH;
		} else {
//			System.out.println("exist month");
			maxDays = YearMonth.of(LocalDate.now().getYear(), Integer.parseInt(month)).lengthOfMonth();
			String formattedMonth = String.format("%02d", Integer.parseInt(month));
			m = formattedMonth;
			System.out.println("month: " + m);
			sqlAP = "SELECT * from Appointment_Provision WHERE appointmentDateAt LIKE '%" + formattedMonth + "-%'"
					+ "and idHAP =" + idH;
			System.out.println(sqlAP);
		}
		// start default dateInfo
		for (int i = 1; i <= maxDays + 1; i++) {
			result.add("np");
		}
		result.set(0, "fake");
		// End default dateInfo
		try {
			conn = new DBContext().getConnect();
			PreparedStatement stm = conn.prepareStatement(sqlAP);
//			System.out.println("helo");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				int idAP = rs.getInt(6);
				result.set(Integer.parseInt((rs.getDate(3) + "").split("-")[2]), "pns");
				PreparedStatement stm2 = conn.prepareStatement(sqlA);
				stm2.setInt(1, idAP);
				ResultSet rs2 = stm2.executeQuery();
				while (rs2.next()) {
					result.set(Integer.parseInt((rs.getDate(3) + "").split("-")[2]), "ps");
				}

			}
//			System.out.println("month last date: "+ result.size());

			for (int i = 1; i < result.size(); i++) {
				result.set(i, i + "-" + result.get(i));
//				System.out.println(result.get(i));
			}
		} catch (Exception e) {
		}
		// TODO Auto-generated method stub
		return result;
	}

	public static ArrayList<String> datePickedInfos(int idH, String date) {
//		select list of time range
//		loop by list timerange => get list vaccine provide ( idVaccine -> vaccinename && quantity)
//		get idAP check on appointment => count++
		ArrayList<String> result = new ArrayList<>();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date datee = formatter.parse(date);
			System.out.println(datee);
			java.sql.Date sqlDate = new java.sql.Date(datee.getTime());
			System.out.println("hiohihaha: "+ sqlDate);

			String query = "select idTimeRangeAP from appointment_provision where idHAP = ? and appointmentDateAt = ?";

			conn = new DBContext().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idH);
			ps.setDate(2, sqlDate);
			rs = ps.executeQuery();
			while (rs.next()) {
//				"timerange |idVaccine-vaccine name(appointmented/quantity)?idVaccine-vaccine name(appointmented/quantity)",
				TimeRangeDAO timeRangeDAO = new TimeRangeDAO();
				String timeRangeInfo = timeRangeDAO.getTimeRangeById(rs.getInt(1)) + "|";
				String sqlGetTimeRangeInfo = "select * from appointment_provision where idHAP = ? and appointmentDateAt = ? and idTimeRangeAP = ? ";
//				System.out.println("test: " + rs.getInt(1));
				PreparedStatement ps2 = conn.prepareStatement(sqlGetTimeRangeInfo);
				ps2.setInt(1, idH);
				ps2.setDate(2, sqlDate);
				ps2.setInt(3, rs.getInt(1));
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					VaccineDAO vaccineDAO = new VaccineDAO();
					String vName = vaccineDAO.getVacNameByVacId(rs2.getInt(2));
					int booked = AppointmentDAO.getBookedByIdAP(rs2.getInt(6));
					if (timeRangeInfo.equalsIgnoreCase(timeRangeDAO.getTimeRangeById(rs.getInt(1)) + "|")) {
						timeRangeInfo += rs2.getInt(2) + "-" + vName + "(" + booked + "/" + rs2.getInt(4) + ")"; // add
					} else {
						timeRangeInfo += "?" + rs2.getInt(2) + "-" + vName + "(" + booked + "/" + rs2.getInt(4) + ")";
					}
				}
				System.out.println("Before add: " + timeRangeInfo);
				result.add(timeRangeInfo);
//				System.out.println(rs.getInt(1));
			}
//			for (String string : result) {
//				System.out.println(string);
//			}
			System.out.println("size: " + result.size());
			return result;
		} catch (Exception e) {
			Logger.getLogger(VaccineDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public static int editQuantity(String idVac, String idHAP, String date, String quantity, String idTimeRange) {
		String sql = "UPDATE appointment_provision SET quantity = ? WHERE idVaccineAP = ? AND idHAP = ? AND appointmentDateAt = ? AND idTimeRangeAP = ?";
		int rs = -1;
		// check exist vaccine in time range or not if no => add
		if (existVacInTimeRange(idVac, idHAP, date, idTimeRange) >= 0) {
			try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, quantity);
				ps.setString(2, idVac);
				ps.setString(3, idHAP);
				ps.setString(4, date);
				ps.setString(5, idTimeRange);

				int rowsAffected = ps.executeUpdate();
				rs = 1;

				System.out.println(rowsAffected + " row(s) updated.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			return -1;
		}
		return rs;
	}

	public static int existVacInTimeRange(String idVac, String idHAP, String date, String idTimeRange) {
		String sql = "SELECT idAppointmentProvision FROM appointment_provision WHERE idVaccineAP = ? AND idHAP = ? AND appointmentDateAt = ? AND idTimeRangeAP = ?";
		int idAP = -1;
		try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, idVac);
			ps.setString(2, idHAP);
			ps.setString(3, date);
			ps.setString(4, idTimeRange);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					idAP = rs.getInt(1);
					System.out.println("There is idAP " + idAP);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idAP;
	}

	public static void deleteVaccineInTimeRange(String idVac, String idHAP, String date, String idTimeRange) {
		String sql = "Delete From appointment_provision WHERE idVaccineAP = ? AND idHAP = ? AND appointmentDateAt = ? AND idTimeRangeAP = ?";
		// check exist vaccine in time range or not if no => add

		// get idAppointmentProvision check on appoitment
		int idAP = existVacInTimeRange(idVac, idHAP, date, idTimeRange);
		if (idAP >= 0) {
			System.out.println("exist APPOINTMENT PROVISION");

			if (AppointmentDAO.existAppointnmentProvision(idAP) >= 0) {
				// delete all from appoinment
				System.out.println("exist APPOINTMENT_PROVISION ON APPOINTMENT");
				AppointmentDAO.deleteAppointmentByAP(idAP);
				System.out.println("FINISH DELETE ON APPOINTMENT");
			}

			try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, idVac);
				ps.setString(2, idHAP);
				ps.setString(3, date);
				ps.setString(4, idTimeRange);
				ps.executeUpdate();
				System.out.println("delete success");
			} catch (Exception e) {
				System.out.println("delete fail");
				e.printStackTrace();
			}
		} else {
			System.out.println("NO APPOINTMENT PROVISION IN DB YET");
		}

	}

	public static void deleteTimeRange(String idHAP, String date, String idTimeRange) {
		String sql = "select * from appointment_provision where idHAP = ? and appointmentDateAt = ? and idTimeRangeAP = ?";
		try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, idHAP);
			ps.setString(2, date);
			ps.setString(3, idTimeRange);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
//					System.out.println(rs.getDate(3));
					deleteVaccineInTimeRange(rs.getInt(2) + "", rs.getInt(1) + "", rs.getDate(3) + "",
							rs.getInt(5) + "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void handleChangesList(String[] arr, String idH, String date) {
		System.out.println("length " + arr.length);
		System.out.println("date " + date);
		String[] newArray = new String[arr.length - 1];

		// Copy all elements from originalArray except the last one
		for (int i = 0; i < arr.length - 1; i++) {
			newArray[i] = arr[i];
		}

		for (String string : newArray) {
			System.out.println("string: " + string);
			String timeRange = string.split("\\|")[0];
			String action = string.split("\\|")[1];
			String detail = string.split("\\|")[2];

			String idTimeRange = TimeRangeDAO.getIdTimeRangeByTimeRange(timeRange);
			if (action.equalsIgnoreCase("edit")) {
				System.out.println("come edit");
				String idVac = detail.split("\\(")[0];
				String quantity = detail.split("\\/")[1];
				quantity = quantity.substring(0, quantity.length() - 1);
				editQuantity(idVac, idH, date, quantity, idTimeRange);

			} else if (action.equalsIgnoreCase("delete vaccine")) {
				System.out.println("delete vaccine");
				String idVac = detail.split("\\(")[0];
				deleteVaccineInTimeRange(idVac, idH, date, idTimeRange);

			} else if (action.equalsIgnoreCase("delete time range")) {
				System.out.println("delete time range");
				deleteTimeRange(idH, date, idTimeRange);
				// handle here
			} else if (action.equalsIgnoreCase("add vaccine") || action.equalsIgnoreCase("add time range")) {
				System.out.println("come add vac || time");
				String idVac = detail.split("\\(")[0];
				String quantity = detail.split("\\/")[1];
				quantity = quantity.substring(0, quantity.length() - 1);
				System.out.println(idTimeRange);
				System.out.println(date);
				System.out.println(idH);
				System.out.println(idVac);
				createAppointmentProvision(idH, idVac, date, quantity, idTimeRange);
				System.out.println("add time range || vaccine");

			}
		}
	}
    
    public int findIdAppointmentProvision(int idTimeRangeAP, Date appointmentDateAt, int idHAP) {
        int idAppointmentProvision = 0;

        try {
            conn = new DBContext().getConnect();
            String query = "SELECT idAppointmentProvision FROM appointment_provision "
                    + "WHERE idTimeRangeAP = ? AND appointmentDateAt = ? AND idHAP = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idTimeRangeAP);
            ps.setDate(2, appointmentDateAt);
            ps.setInt(3, idHAP);
            rs = ps.executeQuery();

            if (rs.next()) {
                idAppointmentProvision = rs.getInt("idAppointmentProvision");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAppointmentProvision;
    }

    public static void main(String[] args) {
        AppointmentProvisionDAO dao = new AppointmentProvisionDAO();
//    ArrayList<String> arr = dao.datePickedInfos(6, "2023-06-21");    
    ArrayList<String> arr2 = dao.dateInfo(6, "6");

        for (String string : arr2) {
            System.out.println(string);   
        }
        String idHAP = "1";
        int idVaccineAP = 2;
//        List<Date> Date = AppointmentProvisionDAO.getDate(idHAP);
//
//        for (Date ap : Date) {
//            System.out.println(ap);
//        }
        LocalDate localDate = LocalDate.of(2023, 07, 01);
        java.sql.Date date = java.sql.Date.valueOf(localDate);
//        List<TimeRange> timeRanges = dao.getTimeRange(idHAP, date, "2");
//        for (TimeRange timeRange : timeRanges) {
//            // Perform desired operations with the timeRange object
//            System.out.println(timeRange.getStartTime());
//            System.out.println(timeRange.getEndTime());
//        }
//        System.out.println(createAppointmentProvision(5, 2, date,12,2));
//    }

//        dao.createAppointmentProvision(1, 2, date, 55, 2);
    }
}
