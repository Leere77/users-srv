package ru.mirea.userssrv.Impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;
//import ru.mirea.userssrv.User;

public class Users implements ru.mirea.userssrv.Users {

    @Override
    public User logIn(String userName, String password) throws ErrorZloumishlennik, ErrorIncorrectUserData {
        database db = new database();
        db.connect();
        int level = db.level(userName);
        if(level != 0){
            if(db.check(userName, password)){
                db.out(true, userName);
                switch (level) {
                    case 1: User u =  new User(userName, password);
                            System.out.print("You've signed in as an regular user\n");
                            db.close();
                            return u;
                    case 2: Admin u1 = new ru.mirea.userssrv.Impl.Admin(userName, password);
                            db.close();
                            System.out.print("You've signed in as an admin\n");
                            return u1;
                }
            } else {
                throw new ErrorZloumishlennik();
            }
        } else
            throw new ErrorIncorrectUserData();
        db.close();
        return null;
    }

    protected boolean checkLogin(String in) {
        Pattern p = Pattern.compile("\\w{8,20}");
        Matcher m = p.matcher(in);
        return m.matches();
    }
    protected boolean checkPassword(String in) {
        Pattern p = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}");
        Matcher m = p.matcher(in);
        return m.matches();
    }
}
