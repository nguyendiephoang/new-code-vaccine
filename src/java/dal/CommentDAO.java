/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Comment;
import model.Vaccine;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class CommentDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Comment> getComment(String idVaccineCmt) {
        List<Comment> list = new ArrayList<>();
        String query = "SELECT cmt.idComment, us.userName, cmt.comment, cmt.likeCount, cmt.dateTime "
                + "FROM [comment] cmt "
                + "JOIN [user] us "
                + "ON cmt.idUser = us.idUser "
                + "WHERE cmt.idVaccine = ?";
        try {
            conn = new DBCon().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, idVaccineCmt);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idComment = rs.getInt("idComment");
                String userName = rs.getString("userName");
                String comment = rs.getString("comment");
                int likeCount = rs.getInt("likeCount");
                String dateTime = rs.getString("dateTime");

                list.add(new Comment(idComment, userName, comment, likeCount, dateTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertComment(String comment, String idUser, String idVaccine, String dateTime) {
        String query = "INSERT INTO [comment] (comment, idUser, idVaccine, dateTime) VALUES (?,?,?,?);";
        try {
            conn = new DBCon().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, comment);
            ps.setString(2, idUser);
            ps.setString(3, idVaccine);
            ps.setString(4, dateTime);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteComment(String idUser, String idComment) {
        boolean success = false;
        String query = "DELETE FROM [comment] WHERE idUser = ? AND idComment = ?";
        try {
            conn = new DBCon().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            ps.setString(2, idComment);
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void main(String[] args) {
        CommentDAO dao = new CommentDAO();
//        List<Vaccine> listVc = dao.getVaccine();
//        for (Vaccine o : listVc) {
//            System.out.println(o);
//        }

        String idVaccine = "2";

        String comment = "Hello. I want help";
        String idUser = "1003";
        
        dao.insertComment(comment, idUser, idVaccine, "09:17:20");

//        List<Vaccine> listDetailVc = dao.getVaccineById(idVaccine);
//        for (Vaccine o : listDetailVc) {
//            System.out.println(o);
//        } 

//        String idCommentToDelete = "40";
//        boolean isDeleted = dao.deleteComment(idCommentToDelete);
//        if (isDeleted) {
//            System.out.println("Comment with ID " + idCommentToDelete + " has been deleted.");
//        } else {
//            System.out.println("Failed to delete comment with ID " + idCommentToDelete + ".");
//        }

        List<Comment> list = dao.getComment(idVaccine);
        for (Comment o : list) {
            System.out.println(o);
        }

    }
}
