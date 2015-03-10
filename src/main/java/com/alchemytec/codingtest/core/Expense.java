package com.alchemytec.codingtest.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Date;

public class Expense {
    private Long id;
    private Date date;
    @DecimalMin(value = "0")
    @DecimalMax(value = "99999999")
    private BigDecimal amount;
    @Length(max = 255)
    private String reason;

    public Expense() {}

    public Expense(long id, Date date, BigDecimal amount, String reason) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.reason = reason;
    }

    @JsonProperty
    public Long getId() { return id; }
    @JsonProperty
    public void setId(Long id) { this.id = id; }

    @JsonProperty
    public Date getDate() { return date; }
    @JsonProperty
    public void setDate(Date date) { this.date = date; }

    @JsonProperty
    public BigDecimal getAmount() { return amount; }
    @JsonProperty
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
        this.amount.setScale(2, BigDecimal.ROUND_FLOOR);
    }

    @JsonProperty
    public String getReason() { return reason; }
    @JsonProperty
    public void setReason(String reason) { this.reason = reason; }
}
