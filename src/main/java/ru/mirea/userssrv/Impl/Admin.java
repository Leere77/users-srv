package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.*;

public class Admin extends User implements ru.mirea.userssrv.Admin{
    public String name;
    public String password;

    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public void adminOnlyUserCreate(String userName, String Password, String password, int userID) throws ErrorBadData, ErrorCloneUser, ErrorIncesecurePassword, ErrorLevelAccess {

    }

    @Override
    public void adminOnlyUpdateUserLevel(int userID, int userLevelUpdate) throws ErrorIncorrectUserData {

    }

    @Override
    public void logOut() {

    }

    @Override
    public void updateUserData(String Password, String NewPassword, String SecondNewPassword) throws ErrorIncesecurePassword {

    }
}
