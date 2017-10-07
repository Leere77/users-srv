package ru.mirea.userssrv.Impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;
import ru.mirea.userssrv.User;

public class Users implements ru.mirea.userssrv.Users {
    private String name;
    private String password;
    private int id;

    @Override
    public Users logIn(String userName, String password) throws ErrorZloumishlennik, ErrorIncorrectUserData {
        Pattern p = Pattern.compile("[a-zA-Z].{8,20}");
        Matcher m = p.matcher(userName);

        if(m.matches()) {
            System.out.print("okay");
            this.name = userName;
            this.password = password;
        }
        return this;
    }
}
