package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;

public class main {

    public static void main(String[] args) throws ErrorZloumishlennik, ErrorIncorrectUserData {
        Users u = new Users();
        try{
            User u1 = u.logIn("admin", "r3uc3d");
            if(u1 instanceof ru.mirea.userssrv.Impl.Admin) {
                u1 = (ru.mirea.userssrv.Impl.Admin) u1;
                u1.adminOnlyUserCreate("useraaaaa", "aaaaAAAAd3", "aaaaAAAAd3", 1);
            }
            //u1.updateUserData("0000", "aaaaAAAA1", "aaaaAAAA1");
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}