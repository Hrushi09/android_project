package com.example.hra.models;

public class Accounts {

    private  String Username;
    private String Email;
    private String CreatePassword;
private String ID;

    public Accounts() {
    }

    public Accounts( String username, String createpassword, String email, String ID) {

        Username = username;
        CreatePassword = createpassword;
        Email = email;
        this.ID =ID;

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
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}

