package ru.harry.Entity;

import org.springframework.format.annotation.DateTimeFormat;
import ru.harry.Models.EventStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "events", schema = "webapiam"/*, catalog = ""*/)
public class EventsEntity {
    private int idEvent;
    private String uid;
    private Timestamp evDate;
    private BigDecimal cost;
    private int fk_user;
    private String comment;
    private int status;
    private int fk_Service;

    @Id
    @Column(name = "Id_Event", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdEvent() {
        return idEvent;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
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
    @Column(name = "EvDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    public Timestamp getEvDate() {
        return evDate;
    }
    public void setEvDate(Timestamp evDate) {
        this.evDate = evDate;
    }

    @Basic
    @Column(name = "Cost", nullable = false, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "Fk_user", nullable = false)
    public int getFk_user() {
        return fk_user;
    }
    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    @Basic
    @Column(name = "Fk_Service", nullable = false)
    public int getFk_Service() {
        return fk_Service;
    }
    public void setFk_Service(int fk_Service) {
        this.fk_Service = fk_Service;
    }
    @Basic
    @Column(name = "Comment", length = 100)
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "Status", nullable = false)
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsEntity that = (EventsEntity) o;
        return idEvent == that.idEvent &&
                status == that.status &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(evDate, that.evDate) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, uid, evDate, cost, comment, status);
    }

    @Override
    public String toString()
    {    return idEvent+ "\t| " + uid + "\t| " + evDate + "\t| " + cost + "\t| " + fk_user + "\t| " + comment +
            "\t| " + status + "\t| " + fk_Service +"\n";
    }
}
