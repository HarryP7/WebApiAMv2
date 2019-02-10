package ru.harry.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "service", schema = "webapiam"/*, catalog = ""*/)
public class ServiceEntity {
    private int idService;
    private BigDecimal lat;
    private BigDecimal lng;
    private String title;
    private Timestamp datePlace;
    private String imageUrl;

    @Id
    @Column(name = "Id_Service", nullable = false)
    public int getIdService() {
        return idService;
    }
    public void setIdService(int idService) {
        this.idService = idService;
    }

    @Basic
    @Column(name = "Lat", nullable = false, precision = 6)
    public BigDecimal getLat() {
        return lat;
    }
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "Lng", nullable = false, precision = 6)
    public BigDecimal getLng() {
        return lng;
    }
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DatePlace", nullable = false)
    public Timestamp getDatePlace() {
        return datePlace;
    }
    public void setDatePlace(Timestamp datePlace) {
        this.datePlace = datePlace;
    }

    @Basic
    @Column(name = "ImageUrl", length = 100)
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return idService == that.idService &&
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
