package ru.harry.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status", schema = "webapiam"/*, catalog = ""*/)
public class StatusEntity {
    private int idStatus;
    private String sName;

    @Id
    @Column(name = "Id_Status", nullable = false)
    public int getIdStatus() {
        return idStatus;
    }
    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Basic
    @Column(name = "sName", nullable = false, length = 50)
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return idStatus == that.idStatus &&
                Objects.equals(sName, that.sName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStatus, sName);
    }

    @Override
    public String toString() {
        return idStatus + "\t| " + sName+"|";
    }
}
