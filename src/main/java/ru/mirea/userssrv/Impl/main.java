package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.Admin;
import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;

public class main {

    public static void main(String[] args) throws ErrorZloumishlennik, ErrorIncorrectUserData {
        Users u = new Users();
        try{
            User u1 = u.logIn("admin", "r3uc3d");
            if(u1 instanceof ru.mirea.userssrv.Admin) {
                ((Admin) u1).adminOnlyUserCreate("userUser", "qwertyQWERTY1", "qwertyQWERTY1", 1);
                //System.out.print(u1.name);
            }
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}