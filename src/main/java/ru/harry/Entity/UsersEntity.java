package ru.harry.Entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "webapiam"/*, catalog = ""*/)
public class UsersEntity {
    private int idUser;
    private String uid;
    private String fullName;
    private String email;
    private String phone;
    private String login;
    private int fk_Role;
    private byte[] passwordHash;
    private byte[] passwordSalt;

    @Id
    @Column(name = "Id_User", nullable = false)
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "Uid", nullable = false, length = 100)
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "FullName", nullable = false, length = 100)
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Email", length = 50)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Phone", length = 16)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Login", length = 50)
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Fk_Role", nullable = false)
    public int getFk_Role() {
        return fk_Role;
    }
    public void setFk_Role(int fk_Role) {
        this.fk_Role = fk_Role;
    }

    @Basic
    @Column(name = "PasswordHash", nullable = false)
    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "PasswordSalt", nullable = false)
    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return idUser == that.idUser &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(login, that.login) &&
                Arrays.equals(passwordHash, that.passwordHash) &&
                Arrays.equals(passwordSalt, that.passwordSalt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idUser, uid, fullName, email, phone, login);
        result = 31 * result + Arrays.hashCode(passwordHash);
        result = 31 * result + Arrays.hashCode(passwordSalt);
        return result;
    }
    @Override
    public String toString()
    {    return idUser+ "\t| " + uid + "\t| " + fullName + "\t| " + email + "\t| " + phone +
            "\t| " + login+ "\t| " + fk_Role + "\t| " + Arrays.toString(passwordHash) + "\t| " + Arrays.toString(passwordSalt) +"|";
    }
}
