package controller.appointmentController;

import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.AppointmentProvisionDAO;
import dal.TimeRangeDAO;
import dal.VaccineDAO;

//1. Get idBV in session after login as hospital
//2. handle string cookie_name => date format YY-MM-DD
//3. loop through arrTime = (cookie.value().split("\\|")[0]) => (2 input : dateAt + idTimeRange) 
//4. loop throush cookie.value()[1] => ( = input vaccineName + số lượng )
//5. Insert to table appointment_provision and auto generate idAppointmentProvision
@WebServlet("/UpdateAppointment")
public class UpdateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateAppointment() {
		super();
	}

//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		HttpSession session = request.getSession(); // retrieve the session
//		// get exist date?month?
//////		String date = request.getParameter("date");
//////		String month= request.getParameter("month");
//////        int idH = (int) session.getAttribute("id");
////		
//		// PART I
//		// 1. get datesInfo from db
//		ArrayList<String> datesInfo = AppointmentProvisionDAO.dateInfo(1, "6");
//		// 2. datePickedInfos db
//		ArrayList<String> datePickedInfos = AppointmentProvisionDAO.datePickedInfos(1, "2023-07-01");
//		// 3. timeRangeList from db
//		TimeRangeDAO timeRangeDAO = new TimeRangeDAO();
//		ArrayList<String> timeRangeList = timeRangeDAO.getTimeRangeList();
//		// PART II
//		
//		request.getRequestDispatcher("/calender.html").forward(request, response);
//	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8084/Vaccine_testver1/calender.html");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		String monthG;
		String dateG;
		String yearG;
		
		System.out.println("come servlet");
		    
		String da= (new Date() + "");
		monthG = new Date().getMonth() + 1 + "";
		dateG = new Date().getDate() + "";
		yearG = da.substring(da.length() - 4);
		System.out.println("year: " + yearG);
		if (request.getParameter("date") != null) {
			String d = request.getParameter("date");
////        int idH = (int) session.getAttribute("id");
			monthG = d.replace("month_", "").split("date_")[0];
			dateG = d.replace("month_", "").split("date_")[1];
		}
		String paramDate = dateG + "/" + monthG;

		// PART I 
		// 1. get datesInfo from db
		ArrayList<String> datesInfo = AppointmentProvisionDAO.dateInfo(1, monthG);
		// 2. datePickedInfos db
		String dateModify = yearG + "-" + monthG + "-" + dateG;
		System.out.println(dateModify);
		ArrayList<String> datePickedInfos = AppointmentProvisionDAO.datePickedInfos(1, dateModify);
		// 3. timeRangeList from db
		TimeRangeDAO timeRangeDAO = new TimeRangeDAO();
		ArrayList<String> timeRangeList = timeRangeDAO.getTimeRangeList(); 

		// test
		for (String string : datePickedInfos) {
			System.out.println(string);
		}
		// close test       

		// Create a Gson object
		Gson gson = new GsonBuilder().create();

		// Convert the array lists to JSON
		String datesInfoJson = gson.toJson(datesInfo);
		String datePickedInfosJson = gson.toJson(datePickedInfos);
		String timeRangeListJson = gson.toJson(timeRangeList);
		String paramDateJson = gson.toJson(paramDate);

		// Set the content type to JSON          z       
		response.setContentType("application/json");
                     
		// Send the JSON data as the response
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("datesInfo", datesInfoJson);
		jsonObject.addProperty("datePickedInfos", datePickedInfosJson);
		jsonObject.addProperty("timeRangeList", timeRangeListJson);   
		jsonObject.addProperty("paramDate", paramDateJson);  

		response.getWriter().write(jsonObject.toString());  
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set CORS headers
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8084/Vaccine_testver1/calender.html");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");

		processRequest(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
}
