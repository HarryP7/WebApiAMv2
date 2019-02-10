package ru.harry.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "webapiam"/*, catalog = ""*/)
public class RolesEntity {
    private int id;
    private String name;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
    public String toString()
    {    return id+ "\t| " + name + "|";
    }
}
