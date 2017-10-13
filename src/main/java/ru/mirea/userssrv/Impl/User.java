package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.ErrorIncesecurePassword;

public class User implements ru.mirea.userssrv.User {
    public String name;
    public String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void logOut() {

    }

    @Override
    public void updateUserData(String Password, String NewPassword, String SecondNewPassword) throws ErrorIncesecurePassword {

    }
}