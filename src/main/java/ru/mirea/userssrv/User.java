package ru.mirea.userssrv;


public interface User {

    /**
     * Выход
     */
    void logOut() throws ErrorIncorrectUserData;

    /**
     * Изменение пароля ползователя.
     * Password проверка на совпадение с паролем в базе данных для данного пользователя.
     * NewPassword проверка на количество символов (не менее 8, неболее 20), проверка на наличие цифр, строчных и прописных букв (должен быть хотя бы 1 символ каждого типа из перечисленных), проверка на совпадение паролей из двух полей.
     * SecondNewPassword проверка на количество символов (не менее 8, неболее 20), проверка на наличие цифр, строчных и прописных букв (должен быть хотя бы 1 символ каждого типа из перечисленных), проверка на совпадение паролей из двух полей
     * @param Password /Старый пароль пользователя.
     * @param NewPassword /Новый пароль пользователя.
     * @param SecondNewPassword /Новый пароль пользователя.
     * @throws ErrorIncesecurePassword /Проверка на наличие цифр, строчных и прописных букв(хотя бы 1 символ каждого типа из перечисленных), проверка на количество символов (не менее 8, неболее 20).
     * @version 1.0
     * @author Markin T. M.<tixomark@mail.ru>
     */
    void updateUserData(String Password, String NewPassword, String SecondNewPassword)
    throws ErrorIncesecurePassword;

}
