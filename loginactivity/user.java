package com.example.loginactivity;

public class user {
    private String emailId;
    private String password;
    private String idToken;

    public user(){ }

        public String getIdToken(){return idToken;}

        public void setIdToken(String idToken){this.idToken=idToken;}

        public String getEmailId(){return emailId;}

        public void setEmailId(String emailId){this.emailId=emailId;}

        public String getPassword(){return password;}

        public void setPassword(String password){this.password=password;}

}
