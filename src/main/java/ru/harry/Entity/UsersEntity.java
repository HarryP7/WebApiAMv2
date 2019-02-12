package ru.harry.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "webapiam"/*, catalog = ""*/)
@Getter
@Setter
public class UsersEntity {
    @Id
    @Column(name = "Id_User", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Basic
    @Column(name = "Uid", nullable = false, length = 100)
    private String uid;
    @Basic
    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;
    @Basic
    @Column(name = "Email", length = 50)
    private String email;
    @Basic
    @Column(name = "Phone", length = 16)
    private String phone;
    @Basic
    @Column(name = "Login", length = 50)
    private String login;
    @Basic
    @Column(name = "Fk_Role", nullable = false)
    private int fk_Role;
    @Basic
    @Column(name = "PasswordHash", nullable = false)
    private byte[] passwordHash;
    @Basic
    @Column(name = "PasswordSalt", nullable = false)
    private byte[] passwordSalt;

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
