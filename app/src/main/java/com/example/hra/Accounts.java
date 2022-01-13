package com.example.hra;

public class Accounts {

    private  String Username;
    private String Email;
    private String CreatePassword;


    public Accounts() {
    }

    public Accounts( String username, String createpassword, String email) {

        Username = username;

        CreatePassword = createpassword;
        Email = email;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCreatePassword() {
        return CreatePassword;
    }

    public void setCreatePassword(String createPassword) {
        CreatePassword = createPassword;
    }

}
