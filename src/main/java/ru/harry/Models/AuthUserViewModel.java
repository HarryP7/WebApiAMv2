package ru.harry.Models;

public class AuthUserViewModel {
    private String email;
    private String password;
    public AuthUserViewModel(String email, String password){
        this.email = email;
        this.password = password;
    }
}
