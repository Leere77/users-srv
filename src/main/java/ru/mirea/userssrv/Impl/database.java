package ru.mirea.userssrv.Impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:c:\\Users\\LeereChan\\Documents\\db\\users.s3db");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
