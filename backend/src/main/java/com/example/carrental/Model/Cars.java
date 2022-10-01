package com.example.carrental.Model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cars {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "car_id")
    private long carId;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "license_plates")
    private String licensePlates;
    @Basic
    @Column(name = "main_image")
    private String mainImage;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "rental_price")
    private Double rentalPrice;
    @Basic
    @Column(name = "seat_number")
    private Integer seatNumber;
    @OneToMany(mappedBy = "carId")
    private Set<CarImages> carImages;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return carId == cars.carId && Objects.equals(brand, cars.brand) && Objects.equals(color, cars.color) && Objects.equals(description, cars.description) && Objects.equals(licensePlates, cars.licensePlates) && Objects.equals(mainImage, cars.mainImage) && Objects.equals(name, cars.name) && Objects.equals(rentalPrice, cars.rentalPrice) && Objects.equals(seatNumber, cars.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, brand, color, description, licensePlates, mainImage, name, rentalPrice, seatNumber);
    }
}
