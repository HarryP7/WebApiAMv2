package ru.harry.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
/**
 * Simple JavaBean domain object that represents Events.
 *
 * @author HarryPC
 * @version 1.0
 */
@Entity
@Table(name = "events", schema = "webapiam"/*, catalog = ""*/)
@Getter
@Setter
public class EventsEntity {
    @Id
    @Column(name = "Id_Event", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    @Basic
    @Column(name = "Uid", nullable = false, length = 100)
    private String uid;
    @Basic
    @Column(name = "Datev", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Timestamp evDate;
    @Basic
    @Column(name = "Cost", nullable = false, precision = 2)
    private BigDecimal cost;
    @Basic
    @Column(name = "Fk_user", nullable = false)
    private int fk_user;
    @Basic
    @Column(name = "Fk_Service", nullable = false)
    private int fk_Service;
    @Basic
    @Column(name = "Comment", length = 100)
    private String comment;
    @Basic
    @Column(name = "Status", nullable = false)
    private int status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsEntity that = (EventsEntity) o;
        return idEvent.equals(that.idEvent) &&
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
            "\t| " + status + "\t| " + fk_Service +"|";
    }
}
