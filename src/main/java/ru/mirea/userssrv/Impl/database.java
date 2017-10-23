package ru.mirea.userssrv.Impl;

import java.sql.*;
import java.security.*;

public class database {

    public Connection connect() {
        Connection co = null;

        try {
            co = DriverManager.getConnection("jdbc:sqlite:c:/Users/LeereChan/Documents/db/users.s3db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return co;
    }

    public String get(int id, String what){
        String que = "SELECT "+ what +" FROM user WHERE ID="+id;
        try (Connection conn = this.connect();
             Statement q = conn.createStatement();
             ResultSet rs = q.executeQuery(que))
        {
            String result = (String) rs.getObject(what);
            return rs.wasNull() ? "" : result;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean check(String name, String pass){
        String que = "SELECT ID, user, password, level, isLoggined FROM user";
        try (Connection conn = this.connect();
             Statement q = conn.createStatement();
             ResultSet rs = q.executeQuery(que))
        {
            while (rs.next()){
                if(rs.getString("user").equals(name) && rs.getString("password").equals(pass))
                    return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int level(String name){
        String que = "SELECT level FROM user WHERE user = '" + name + "'";
        try (Connection conn = this.connect();
             Statement q = conn.createStatement();
             ResultSet rs = q.executeQuery(que)) {
            int result = rs.getInt("level");
            return rs.wasNull() ? 0 : result;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void update(int id, int level){
        String que = "UPDATE user SET level = "+ level + " WHERE id ="+id;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(que);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUser(String p0, String p1, String name){
        String que = "SELECT password FROM user WHERE user='"+name+"'";
        String que1 = "UPDATE user SET password = '"+ p1 + "' WHERE user='"+name+"'";
        try {
            Connection conn = this.connect();
            Statement q = conn.createStatement();
            ResultSet rs = q.executeQuery(que);
            String result = rs.getString("password");
            if(result.equals(p0)){
                PreparedStatement pstmt = conn.prepareStatement(que1);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void register(String user, String password, int level, boolean isLoggined){
        String que = "INSERT INTO user (user, password, level, isLoggined) VALUES(?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(que)) {
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            pstmt.setInt(3, level);
            pstmt.setBoolean(4, isLoggined);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void out(boolean cond, String name){
        String que = "UPDATE user SET isLoggined = '"+ cond + "' WHERE user ='"+name+"'";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(que);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        try {
            this.connect().close();
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }
}
