package com.example.jaz27454nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id of currency rate record.", required = true)
    private Integer id;

    @Schema(description = "Symbol of currency", required = true)
    private String currency;

    @Schema(description = "Start of interval used to calculate rate", required = true)
    private Instant startDate;

    @Schema(description = "End of interval used to calculate rate", required = true)
    private Instant endDate;

    @Schema(description = "Sum of rates divided by amount of days", required = true)
    private Double rate;

    @Schema(description = "Date and time of request", required = true)
    private Instant created;

    public Currency() {}

    public Currency(Integer id, String currency, Instant startDate, Instant endDate, Double rate, Instant created) {
        this.id = id;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
