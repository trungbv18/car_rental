package com.example.carrental.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_images")
public class CarImages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "image_id")
    private long imageId;
//    @Basic
//    @Column(name = "car_id")
//    private Long carId;
    @Basic
    @Column(name = "sub_image")
    private String subImage;


    public Cars getCarId() {
        return carId;
    }

    public void setCarId(Cars carId) {
        this.carId = carId;
    }

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Cars carId;

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }



    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarImages carImages = (CarImages) o;
        return imageId == carImages.imageId && Objects.equals(carId, carImages.carId) && Objects.equals(subImage, carImages.subImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, carId, subImage);
    }
}
