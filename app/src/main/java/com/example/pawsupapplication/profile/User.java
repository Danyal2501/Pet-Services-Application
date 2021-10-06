package com.example.features_dream_14;

public class User {
    private String name;
    private String username;
    private String birthday;
    private String location;
    private String email;
    private String phone;
    private String password;

    public User(){
        name = "John Smith";
        username = "johnsmith";
        birthday = "03/18/1997";
        location = "Toronto, Ontario";
        email = "sample@sample.com";
        phone = "416-000-0000";
        password = "password";
    }
    public void setName(String s){
        name = changeString(s);
    }

    public void setUsername(String s){
        username = changeString(s);
    }

    public void setBirthday(String s){ birthday = changeString(s); }

    public void setLocation(String l){
        location = changeString(l);
    }

    public void setEmail(String e){
        email = changeString(e);
    }

    public void setPhone(String p){
        phone = changeString(p);
    }

    public void setPassword(String p){
        password = changeString(p);
    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    public String getBirthday(){
        return birthday;
    }

    public String getLocation(){
        return location;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getPassword(){
        return password;
    }

    private static String changeString(String s){
        return s;
    }
}
