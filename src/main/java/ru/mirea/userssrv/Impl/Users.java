package ru.mirea.userssrv.Impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.mirea.userssrv.*;

public class Users implements ru.mirea.userssrv.Users {

    @Override
    public User logIn(String userName, String password) throws ErrorZloumishlennik, ErrorIncorrectUserData {
        db d = new db();
        String[] val = d.get(userName);

        if(val==null)
            throw new ErrorIncorrectUserData();

        if(Boolean.parseBoolean(val[4]))
            throw new ErrorZloumishlennik();

        if(val[1].equals(userName) && password.equals(val[2])){
            d.set(userName, "isLoggined", true);
            switch (Integer.parseInt(val[3])){
                case 0:
                    return new ru.mirea.userssrv.Impl.Admin(userName, password);
                case 1:
                    return new User(userName, password);
            }
        } else
            throw new ErrorIncorrectUserData();
        return null;
    }

    protected static boolean checkLogin(String in){
        Pattern p = Pattern.compile("\\w{8,20}");
        Matcher m = p.matcher(in);
        return m.matches();
    }
    protected static boolean checkPassword(String in){
        Pattern p = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}");
        Matcher m = p.matcher(in);
        return m.matches();
    }
}