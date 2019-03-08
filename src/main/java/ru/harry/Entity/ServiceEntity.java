package ru.harry.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "service", schema = "webapiam"/*, catalog = ""*/)
@Getter
@Setter
public class ServiceEntity {
    @Id
    @Column(name = "Id_Service", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    @Basic
    @Column(name = "Lat", nullable = false, precision = 6)
    private BigDecimal lat;
    @Basic
    @Column(name = "Lng", nullable = false, precision = 6)
    private BigDecimal lng;
    @Basic
    @Column(name = "Title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "DatePlace", nullable = false)
    private Timestamp datePlace;
    @Basic
    @Column(name = "ImageUrl", length = 100)
    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return idService.equals(that.idService) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lng, that.lng) &&
                Objects.equals(title, that.title) &&
                Objects.equals(datePlace, that.datePlace) &&
                Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService, lat, lng, title, datePlace, imageUrl);
    }
    @Override
    public String toString()
    {    return idService+ "\t| " + lat + "\t| " + lng + "\t| " + datePlace + "\t| " + imageUrl +"|";
    }
}
