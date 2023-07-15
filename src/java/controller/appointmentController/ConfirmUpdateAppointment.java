package controller.appointmentController;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import dal.AppointmentProvisionDAO;

/**
 * Servlet implementation class ConfirmUpdateAppointment
 */
@WebServlet("/ConfirmUpdateAppointment")
public class ConfirmUpdateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmUpdateAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read the request body
		BufferedReader reader = request.getReader();
		StringBuilder requestBody = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			requestBody.append(line);
		}           

		// Parse the request body back into an array
		Gson gson = new Gson();             
//		for (String s : gson.fromJson(requestBody.toString(), String[].class)) {
//			System.out.println(s);
//		}
		String[] databaseAsset = gson.fromJson(requestBody.toString(), String[].class);
		String dateMain = databaseAsset[(databaseAsset.length-1)];
		System.out.println("dateMain: " + dateMain);
		System.out.println("old length: " + databaseAsset.length);
		// Process the databaseAsset array as needed
		System.out.println("we start here");

		AppointmentProvisionDAO.handleChangesList(databaseAsset, "1", dateMain);
         
	}                                            

}
