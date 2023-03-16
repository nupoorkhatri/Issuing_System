package com.example.issuing_system;

public class HelperClass {
    String name , sapid , password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSapid() {
        return sapid;
    }

    public void setSapid(String sapid) {
        this.sapid = sapid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass(String name, String sapid, String password) {
        this.name = name;
        this.sapid = sapid;
        this.password = password;
    }

    public HelperClass () {

    }
}
