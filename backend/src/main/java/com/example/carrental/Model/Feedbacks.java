package com.example.carrental.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Feedbacks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "feedback_id")
    private long feedbackId;
    @Basic
    @Column(name = "car_id")
    private Long carId;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "user_id")
    private Long userId;

    public long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedbacks feedbacks = (Feedbacks) o;
        return feedbackId == feedbacks.feedbackId && Objects.equals(carId, feedbacks.carId) && Objects.equals(content, feedbacks.content) && Objects.equals(userId, feedbacks.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId, carId, content, userId);
    }
}
