///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller.bookingController;
//
//import dal.CommentDAO;
//import dal.VaccineDAO;
//import model.Comment;
//import model.Vaccine;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import javax.servlet.annotation.WebServlet;
//
//@WebServlet(urlPatterns = {"/CommentController"})
//public class CommentController extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String idVaccine = request.getParameter("idVaccine");
//
//        CommentDAO dao = new CommentDAO();
//        VaccineDAO daoVc = new VaccineDAO();
//        List<Vaccine> listDetailVc = daoVc.getVaccineById(idVaccine);
//        List<Comment> listCmt = dao.getComment(idVaccine);
//
//        request.setAttribute("listDetailVc", listDetailVc);
//        request.setAttribute("listCmt", listCmt);
//        request.getRequestDispatcher("/Booking/detailVaccine.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if (action != null && action.equals("delete")) {
//            deleteComment(request, response);
//        } else {
//            addComment(request, response);
//        }
//    }
//
//    private void addComment(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String idUser = "1008";
//        String idVaccine = request.getParameter("idVaccine");
//        String comment = request.getParameter("comment");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.now();
//        String formattedDateTime = dateTime.format(formatter);
//
//        CommentDAO dao = new CommentDAO();
//        dao.insertComment(comment, idUser, idVaccine, formattedDateTime);
//
//        // Get the updated comment list
//        List<Comment> updatedCommentList = dao.getComment(idVaccine);
//
//        // Create a JSON array for the updated comment list
//        JSONArray updatedCommentArray = new JSONArray();
//        for (Comment cmt : updatedCommentList) {
//            JSONObject commentObj = new JSONObject();
//            commentObj.put("idComment", cmt.getIdComment());
//            commentObj.put("userName", cmt.getUserName());
//            commentObj.put("comment", cmt.getComment());
//            commentObj.put("dateTime", cmt.getDateTime());
//            updatedCommentArray.add(commentObj);
//        }
//
//        // Set the response content type
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        // Send the JSON response
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("updatedCommentList", updatedCommentArray);
//        response.getWriter().write(jsonResponse.toJSONString());
//    }
//
//    private void deleteComment(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String idUser = "1008"; // Lấy idUser từ nguồn dữ liệu phù hợp
//        String idComment = request.getParameter("idComment");
//
//        CommentDAO dao = new CommentDAO();
//        boolean success = dao.deleteComment(idUser, idComment);
//
//        // Set the response content type
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        // Send the JSON response
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("success", success);
//        response.getWriter().write(jsonResponse.toJSONString());
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}
