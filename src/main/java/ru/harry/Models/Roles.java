package ru.harry.Models;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    public Roles(){}
    public Roles(int id){
        this.id = id;
    }
    public Roles(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Roles(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {this.id = id;}
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {    return id+ "\t| " + name + "\t| " +"\n";
    }
}
