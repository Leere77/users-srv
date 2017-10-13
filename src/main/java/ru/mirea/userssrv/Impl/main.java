package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;

public class main {

    public static void main(String[] args) throws ErrorZloumishlennik, ErrorIncorrectUserData {
//        Users u = new Users();
//        u.logIn("usernameaa", "smth3");
        database db = new database();
        db.connect();
    }
}
