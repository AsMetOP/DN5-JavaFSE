package com.cognizant.countryquery.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int stId;

    @Column(name = "st_code")
    private String stCode;

    @Column(name = "st_date")
    private LocalDate stDate;

    @Column(name = "st_open")
    private BigDecimal stOpen;

    @Column(name = "st_close")
    private BigDecimal stClose;

    @Column(name = "st_volume")
    private long stVolume;

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public LocalDate getStDate() {
        return stDate;
    }

    public void setStDate(LocalDate stDate) {
        this.stDate = stDate;
    }

    public BigDecimal getStOpen() {
        return stOpen;
    }

    public void setStOpen(BigDecimal stOpen) {
        this.stOpen = stOpen;
    }

    public BigDecimal getStClose() {
        return stClose;
    }

    public void setStClose(BigDecimal stClose) {
        this.stClose = stClose;
    }

    public long getStVolume() {
        return stVolume;
    }

    public void setStVolume(long stVolume) {
        this.stVolume = stVolume;
    }

    @Override
    public String toString() {
        return "Stock [code=" + stCode + ", date=" + stDate + ", open=" + stOpen
                + ", close=" + stClose + ", volume=" + stVolume + "]";
    }
}