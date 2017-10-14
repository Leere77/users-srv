package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.ErrorIncorrectUserData;
import ru.mirea.userssrv.ErrorZloumishlennik;

public class main {

    public static void main(String[] args) throws ErrorZloumishlennik, ErrorIncorrectUserData {
        //db.register("user2", "0000", 1, false);
        //db.check("admin", "r3uc3d");
        //System.out.print(db.level("admin"));
        //db.close();
        //Users u = new Users();
        //Admin u1 = (Admin)u.logIn("admin", "r3uc3d");
        //System.out.print("\n" + u1.name + "\n");
        /*try {
            u1.adminOnlyUserCreate("testuser", "1111aaaaA", "1111aaa", 1);
        } catch (Exception e){
            System.out.print(e);
        }*/
        database db = new database();
        //db.updateUser("r3uc3d", "1111", "admin");
        db.out(true, "admin");
    }
}
