package ru.harry.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Events")
public class Events extends Service{
    @Id
    @Column(name = "Id_Event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Uid")
    private String uId;
    @Column(name = "EvDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date evDate;
    @Column(name = "Cost")
    private BigDecimal cost;
    @Column(name = "Fk_user")
    private int fk_user;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Status")
    private int status;
    @Column(name = "Fk_Service")
    private int fk_Service;
    Events(){}
    public Events(int id){
        this.id = id;
    }
    public Events(int id, String uId, Date evDate, BigDecimal cost, int fk_user, String comment, int status, int fk_Service,
                  BigDecimal lat, BigDecimal lng, String title, Date datePlace, String imageUrl) {
        super(lat, lng, title, datePlace, imageUrl);
        this.id = id;
        this.uId = uId;
        this.evDate = evDate;
        this.cost = cost;
        this.fk_user = fk_user;
        this.comment = comment;
        this.status = status;
        this.fk_Service = fk_Service;
    }
    public Events(String uId, Date evDate, BigDecimal cost, int fk_user, String comment, int status, int fk_Service) {
        this.uId = uId;
        this.evDate = evDate;
        this.cost = cost;
        this.fk_user = fk_user;
        this.comment = comment;
        this.status = status;
        this.fk_Service = fk_Service;
    }
    public int getId() {
        return id;
    }
    public String getUid() {
        return uId;
    }
    public Date getEvDate() {
        return evDate;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public int getFk_user() { return fk_user; }
    public String getComment() {
        return comment;
    }
    public int getStatus() { return status; }
    public int getFk_Service() { return fk_Service; }

    public void setId(int id) {this.id = id;}
    public void setUid(String uId) {
        this.uId = uId;
    }
    public void setEvDate(Date evDate) {
        this.evDate = evDate;
    }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setFk_Service(int fk_Service) {
        this.fk_Service = fk_Service;
    }

    @Override
    public String toString()
    {    return id+ "\t| " + uId + "\t| " + evDate + "\t| " + cost + "\t| " + fk_user + "\t| " + comment +
            "\t| " + status + "\t| " + fk_Service +"\n";
    }
}
