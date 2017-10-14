package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.*;

public class Admin extends User implements ru.mirea.userssrv.Admin{
    public String name;
    public String password;

    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public void adminOnlyUserCreate(String userName, String Password, String password, int level) throws ErrorBadData, ErrorCloneUser, ErrorIncesecurePassword, ErrorLevelAccess {
        Users u = new Users();
        database d = new database();
        if(u.checkLogin(userName)){
            if(u.checkPassword(Password)){
                if(d.level(this.name) == 2){
                    if(d.level(this.name)>0){
                        d.register(userName, password, level, false);
                    } else throw new ErrorCloneUser();
                } else throw new ErrorLevelAccess();
            } else throw new ErrorIncesecurePassword();
        } else throw new ErrorBadData();
        d.close();
    }

    @Override
    public void adminOnlyUpdateUserLevel(int userID, int userLevelUpdate) throws ErrorIncorrectUserData {
        database d = new database();
        if(d.level(d.get(userID, "user"))>0)
            d.update(userID, userLevelUpdate);
        else throw new ErrorIncorrectUserData();
        d.close();
    }

}
