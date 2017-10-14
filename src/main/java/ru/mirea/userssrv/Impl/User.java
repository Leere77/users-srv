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
        database d = new database();
        d.out(false, this.name);
        d.close();
    }

    @Override
    public void updateUserData(String Password, String NewPassword, String SecondNewPassword) throws ErrorIncesecurePassword {
        database d = new database();
        Users u = new Users();
        if(!u.checkPassword(NewPassword)){
            d.close();
            throw new ErrorIncesecurePassword();
        }

        if(NewPassword.equals(SecondNewPassword))
            d.updateUser(Password, NewPassword, this.name);
        else throw new ErrorIncesecurePassword();
        d.close();
    }
}