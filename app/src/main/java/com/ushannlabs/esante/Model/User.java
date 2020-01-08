package com.ushannlabs.esante.Model;

public class User {
    //attribus
    private String Name;
    private String Password;

    //constructor

    public User(String name, String nassword) {
        Name = name;
        Password = nassword;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String nassword) {
        Password = nassword;
    }
//default constructor

    public User() {
    }

}
