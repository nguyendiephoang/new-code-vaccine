/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL VOSTRO 5510
 */
public class Comment {
    private int idComment;
    private String userName;
    private String comment;
    private int likeCount;
    private String dateTime;

    public Comment() {
    }

    public Comment(int idComment, String userName, String comment, int likeCount, String dateTime) {
        this.idComment = idComment;
        this.userName = userName;
        this.comment = comment;
        this.likeCount = likeCount;
        this.dateTime = dateTime;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Comment{" + "idComment=" + idComment + ", userName=" + userName + ", comment=" + comment + ", likeCount=" + likeCount + ", dateTime=" + dateTime + '}';
    }

}
