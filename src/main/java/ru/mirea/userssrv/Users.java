package ru.mirea.userssrv;

import ru.mirea.userssrv.Impl.User;

public interface Users {


    /**
     * Вход в учетную запись.
     * userName проверка на существование.
     * password проверка на соответствие с именем пользователя, проверка на существование, сравнение с паролем в базе данных для данного пользователя.
     * level проверка на 0 или 1 у соответствующего пользователя в базе данных.
     * @param userName /Имя пользователя.
     * @param password /Пароль пользователя.
     * @return Users
     * @throws ErrorZloumishlennik /Ограничение ввода пароля (10 попыток)
     * @throws ErrorIncorrectUserData /Проверка на существование данного пользователя с данным паролем.
     * @version 1.0
     * @author Markin T. M.<tixomark@mail.ru>
     */
    User logIn (String userName, String password)
    throws ErrorZloumishlennik, ErrorIncorrectUserData;
}
