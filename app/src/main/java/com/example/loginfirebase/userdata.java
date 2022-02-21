package com.example.loginfirebase;

public class userdata {
    String name;
    String Password;
    String email;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return email;
    }

    public userdata(String name, String password, String email) {
        this.name = name;
        this.Password = password;
        this.email = email;
    }
}
