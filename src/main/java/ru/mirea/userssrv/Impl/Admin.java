package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.*;

public class Admin extends User implements ru.mirea.userssrv.Admin{

    Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public void adminOnlyUserCreate(String userName, String Password, String password, int level) throws ErrorBadData, ErrorCloneUser, ErrorIncesecurePassword, ErrorLevelAccess {
        db d = new db();
        if(d.get(userName)!=null)
            throw new ErrorCloneUser();
        if(!password.equals(Password))
            return;
        if(!Users.checkLogin(userName))
            throw new ErrorBadData();
        if(!Users.checkPassword(Password))
            throw new ErrorIncesecurePassword();

        if(Integer.parseInt(d.get(this.name)[3])==0){
            d.query("INSERT INTO user (user, password, level, isLoggined) VALUES('"+
                    userName + "', '"+
                    password + "', "+
                    level + ", "+
                    "'FALSE')");
        } else
            throw new ErrorLevelAccess();
    }

    @Override
    public void adminOnlyUpdateUserLevel(int userID, int userLevelUpdate) throws ErrorIncorrectUserData {
        db d = new db();
        if(d.get(userID)==null)
            throw new ErrorIncorrectUserData();

        d.set(d.get(userID)[0], "level", userLevelUpdate);
    }
}
