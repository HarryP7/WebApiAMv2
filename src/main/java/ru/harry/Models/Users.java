package ru.harry.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
public abstract class Users {
    @Id
    @Column(name = "Id_User")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Uid")
    private String uId;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Login")
    private String login;
    @Column(name = "Fk_Role")
    private int fk_Role;
    @Column(name = "PasswordHash")
    private String passwordHash;
    @Column(name = "PasswordSalt")
    private String passwordSalt;
    private Collection<Events> events;
    public Users(){}
    public Users(int id){
        this.id = id;
    }
    public Users(int id, String uId, String fullName, String email, String phone, String login, int fk_Role, String passwordHash, String passwordSalt) {
        this.id = id;
        this.uId = uId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.fk_Role = fk_Role;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }
    Users(String uId, String fullName, String email, String phone, String login, int fk_Role) {
        this.uId = uId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.fk_Role = fk_Role;
    }
    public Users( String passwordHash, String passwordSalt) {
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }
    public int getId() {
        return id;
    }
    public String getUid() {
        return uId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() { return phone; }
    public String getLogin() {
        return login;
    }
    public int getFk_Role() {
        return fk_Role;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setId(int id) {this.id = id;}
    public void setUid(String uId) {
        this.uId = uId;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setFk_Role(int fk_Role) { this.fk_Role = fk_Role; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setPasswordSalt(String passwordSalt) { this.passwordSalt = passwordSalt; }

    @Override
    public String toString()
    {    return id+ "\t| " + uId + "\t| " + fullName + "\t| " + email + "\t| " + phone +
            "\t| " + login+ "\t| " + fk_Role + "\t| " + passwordHash + "\t| " + passwordSalt +"\n";
    }
    public Collection<Events> getEvents()
    {   List<Events> list = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            list.add(new Events());
        }
        return list;
    }
}
