package ru.mirea.userssrv.Impl;

import ru.mirea.userssrv.*;

public class main {
    public static void main(String[] args){
        Users u = new Users();
        User u1;
        try {
            u1 = u.logIn("AnotherUser", "qwertyQWERTY1");
            if(u1 instanceof ru.mirea.userssrv.Admin) {
                /*try {
                    ((Admin) u1).adminOnlyUserCreate("AnotherAdmin", "qwertyQWERTY1", "qwertyQWERTY1", 0);
                } catch (ErrorBadData errorBadData) {
                    System.out.print("Invalid login"); // неверный логин
                } catch (ErrorCloneUser errorCloneUser) {
                    System.out.print("Clone user"); // если пользователь уже существует
                } catch (ErrorIncesecurePassword errorIncesecurePassword) {
                    System.out.print("Invalid password"); // неверный пароль
                } catch (ErrorLevelAccess errorLevelAccess) {
                    System.out.print("errorLevelAccess"); // нет прав администратора
                }*/

                /*try {
                    ((Admin) u1).adminOnlyUpdateUserLevel(4,0); // ставим пользователю с id = 4 уровень доступа 0 (администратор)
                } catch (ErrorIncorrectUserData e){
                    System.out.print("user is not exists");// неправильный id
                }*/
            }

            /*try {
                u1.updateUserData("asdfghjSdf3","aaaaaaaaAA3", "aaaaaaaaAA3");
            } catch (ErrorIncesecurePassword errorIncesecurePassword) {
                System.out.print("Invalid password"); // если пароль не соотв. требованиям
            }*/
            u1.logOut(); // выход из учётной записи
        }
        catch (ErrorIncorrectUserData e){
            System.out.print("wrong data"); // действие на случай, если данные пользователя не верны
        }
        catch (ErrorZloumishlennik e){
            System.out.print("Is logged"); // действие на случай, если пользователь в данный момент авторизован
        }
    }
}