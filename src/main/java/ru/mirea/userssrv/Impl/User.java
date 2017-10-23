package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.ErrorIncesecurePassword;
import ru.mirea.userssrv.ErrorIncorrectUserData;

public class User implements ru.mirea.userssrv.User {
    protected String name;
    protected String password;

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void logOut() throws ErrorIncorrectUserData{
        db d = new db();
        d.set(this.name, "isLoggined", false);
    }

    @Override
    public void updateUserData(String Password, String NewPassword, String SecondNewPassword) throws ErrorIncesecurePassword{
        if (NewPassword.equals(SecondNewPassword)) {
            if (Users.checkPassword(NewPassword)) {
                db d = new db();
                if(d.get(this.name)[2].equals(Password))
                    d.set(this.name, "password", NewPassword);
            } else
                throw new ErrorIncesecurePassword();
        }
    }
}