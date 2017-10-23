package ru.mirea.userssrv.Impl;

import java.sql.*;

public class db<T> {
    private Connection co = null;

    public String[] get(int id) {
        try (Connection co = DriverManager.getConnection("jdbc:sqlite:c:/Users/LeereChan/Documents/db/users.s3db");){
            String que = "SELECT user, password, level, isLoggined FROM user WHERE id="+id;
            try (Connection conn = co;
                 Statement q = conn.createStatement();
                 ResultSet rs = q.executeQuery(que))
            {
                if (!rs.isBeforeFirst() ) {
                    return null;
                } else {
                    rs.next();
                    String[] result = {rs.getString("user"),
                            rs.getString("password"),
                            rs.getString("level"),
                            rs.getString("isLoggined")};
                    return result;
                }
            }
            catch (SQLException e){
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] get(String name) {
        try (Connection co = DriverManager.getConnection("jdbc:sqlite:c:/Users/LeereChan/Documents/db/users.s3db");){
            String que = "SELECT ID, password, level, isLoggined FROM user WHERE user='"+name+"'";
            try (Connection conn = co;
                 Statement q = conn.createStatement();
                 ResultSet rs = q.executeQuery(que))
            {
                if (!rs.isBeforeFirst()) {
                    return null;
                } else {
                    rs.next();
                    String[] result = {rs.getString("id"),
                            name,
                            rs.getString("password"),
                            rs.getString("level"),
                            rs.getString("isLoggined")};
                    return result;
                }
            }
            catch (SQLException e){
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void set(String name, String par, T what) {
        try (Connection co = DriverManager.getConnection("jdbc:sqlite:c:/Users/LeereChan/Documents/db/users.s3db");){
            String que = "UPDATE user SET '"+ par +"' = '"+what+"' WHERE user = '"+ name +"'";
            try (Connection conn = co;
                 PreparedStatement pstmt = conn.prepareStatement(que))
            {
                pstmt.executeUpdate();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void query(String que){
        try (Connection co = DriverManager.getConnection("jdbc:sqlite:c:/Users/LeereChan/Documents/db/users.s3db");){
            try (Connection conn = co;
                 PreparedStatement pstmt = conn.prepareStatement(que))
            {
                pstmt.executeUpdate();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String x) throws Exception {
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(x.getBytes());
        return d.digest();
    }
}
