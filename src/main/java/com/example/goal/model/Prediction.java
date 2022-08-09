package com.example.goal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prediction {
    private int id;
    private String expenses;
    private String income;
    private String intrestRate;

    public Prediction(){}

    public Prediction(@JsonProperty("id") int id,
                      @JsonProperty("expenses") String expenses,
                      @JsonProperty("income") String income,
                      @JsonProperty("intrestRate") String intrestRate) {
        this.id = id;
        this.expenses = expenses;
        this.income = income;
        this.intrestRate = intrestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(String intrestRate) {
        this.intrestRate = intrestRate;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "id=" + id +
                ", expenses='" + expenses + '\'' +
                ", income='" + income + '\'' +
                ", intrestRate='" + intrestRate + '\'' +
                '}';
    }
}
