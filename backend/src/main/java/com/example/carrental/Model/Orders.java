package com.example.carrental.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private long orderId;
    @Basic
    @Column(name = "car_id")
    private Long carId;
    @Basic
    @Column(name = "rental_purpose")
    private String rentalPurpose;

    public RentalStatus getRentalStatusId() {
        return rentalStatusId;
    }

    //    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rental_status_id")
    private RentalStatus rentalStatusId;
    @Basic
    @Column(name = "total_money")
    private Double totalMoney;
    @Basic
    @Column(name = "rental_day")
    private Integer rentalDay;
    @CreationTimestamp
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Basic
    @Column(name = "customer_name")
    private String customerName;
    @Basic
    @Column(name = "customer_age")
    private Integer customerAge;
    @Basic
    @Column(name = "customer_gender")
    private String customerGender;
    @Basic
    @Column(name = "customer_address")
    private String customerAddress;
    @Basic
    @Column(name = "customer_purpose")
    private String customerPurpose;
    @Basic
    @Column(name = "rental_time")
    private Timestamp rentalTime;
    @Basic
    @Column(name = "return_time")
    private Timestamp returnTime;


    public void setRentalStatusId(RentalStatus rentalStatusId) {
        this.rentalStatusId = rentalStatusId;
    }



    public Integer getRentalDay() {
        return rentalDay;
    }

    public void setRentalDay(Integer rentalDay) {
        this.rentalDay = rentalDay;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getRentalPurpose() {
        return rentalPurpose;
    }

    public void setRentalPurpose(String rentalPurpose) {
        this.rentalPurpose = rentalPurpose;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPurpose() {
        return customerPurpose;
    }

    public void setCustomerPurpose(String customerPurpose) {
        this.customerPurpose = customerPurpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId && Objects.equals(carId, orders.carId) && Objects.equals(rentalPurpose, orders.rentalPurpose) && Objects.equals(rentalStatusId, orders.rentalStatusId) && Objects.equals(totalMoney, orders.totalMoney) && Objects.equals(createdAt, orders.createdAt) && Objects.equals(updatedAt, orders.updatedAt) && Objects.equals(customerName, orders.customerName) && Objects.equals(customerAge, orders.customerAge) && Objects.equals(customerGender, orders.customerGender) && Objects.equals(customerAddress, orders.customerAddress) && Objects.equals(customerPurpose, orders.customerPurpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, carId, rentalPurpose, rentalStatusId, totalMoney, createdAt, updatedAt, customerName, customerAge, customerGender, customerAddress, customerPurpose);
    }

    public Timestamp getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Timestamp rentalTime) {
        this.rentalTime = rentalTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }
}
