 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

public class Comment {
    private String commentID;
    private String useID;
    private String epID;
    private String commentContent;
    private Date time;
    private String avatar;
    private String userName;
    private int role;

    public Comment() {
    }

    public Comment(String commentID, String useID, String epID, String commentContent, Date time, String avatar, String userName, int role) {
        this.commentID = commentID;
        this.useID = useID;
        this.epID = epID;
        this.commentContent = commentContent;
        this.time = time;
        this.avatar = avatar;
        this.userName = userName;
        this.role = role;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getUseID() {
        return useID;
    }

    public void setUseID(String useID) {
        this.useID = useID;
    }

    public String getEpID() {
        return epID;
    }

    public void setEpID(String epID) {
        this.epID = epID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", useID=" + useID + ", epID=" + epID + ", commentContent=" + commentContent + ", time=" + time + ", avatar=" + avatar + ", userName=" + userName + ", role=" + role + '}';
    }

    
    
    
    
    
}
