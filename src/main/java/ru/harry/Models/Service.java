package ru.harry.Models;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Service")
public abstract class Service {
    @Id
    @Column(name = "Id_Service")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "Lat")
    private BigDecimal lat;
    @Column(name = "Lng")
    private BigDecimal lng;
    @Column(name = "Title")
    private String title;
    @Column(name = "DatePlace")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date datePlace;
    @Column(name = "ImageUrl")
    private String imageUrl;
    Service(){}
    public Service(int id){
        this.id = id;
    }
    public Service(int id, BigDecimal lat, BigDecimal lng, String title, Date datePlace, String imageUrl) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.title = title;
        this.datePlace = datePlace;
        this.imageUrl = imageUrl;
    }
    Service(BigDecimal lat, BigDecimal lng, String title, Date datePlace, String imageUrl) {
        this.lat = lat;
        this.lng = lng;
        this.title = title;
        this.datePlace = datePlace;
        this.imageUrl = imageUrl;
    }
    public int getId() {
        return id;
    }
    public BigDecimal getLat() {
        return lat;
    }
    public BigDecimal getLng() {
        return lng;
    }
    public String getTitle() { return title; }
    public Date getDatePlace() {
        return datePlace;
    }
    public String getImageUrl() { return imageUrl; }

    public void setId(int id) {this.id = id;}
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDatePlace(Date datePlace) { this.datePlace = datePlace; }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString()
    {    return id+ "\t| " + lat + "\t| " + lng + "\t| " + datePlace + "\t| " + imageUrl +"\n";
    }
}
