package com.udacity.pricing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
public class Price {

    private String currency;
    private BigDecimal price;
    private Long vehicle;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Price() {
    }

    public Price(String currency, BigDecimal price, Long vehicle) {
        this.currency = currency;
        this.price = price;
        this.vehicle = vehicle;
    }

    public Price(Long id, String currency, BigDecimal price, Long vehicle) {
        this.currency = currency;
        this.price = price;
        this.vehicle = vehicle;
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
