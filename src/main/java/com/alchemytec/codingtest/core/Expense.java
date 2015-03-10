package com.alchemytec.codingtest.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

public class Expense {
    private long id;
    private Date date;
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
    public long getId() { return id; }

    @JsonProperty
    public Date getDate() { return date; }

    @JsonProperty
    public BigDecimal getAmount() { return amount; }

    @JsonProperty
    public String getReason() { return reason; }
}
