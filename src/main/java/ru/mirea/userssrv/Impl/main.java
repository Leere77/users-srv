package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;

public class main {
    public void main() throws ErrorZloumishlennik, ErrorIncorrectUserData {
        Users u = new Users();
        u.logIn("Username", "smth3");
    }
}
