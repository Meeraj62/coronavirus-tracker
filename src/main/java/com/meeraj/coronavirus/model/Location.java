package com.meeraj.coronavirus.model;

import java.time.LocalDate;

public class Location {
    private String date;
    private String state;
    private Integer cases;
    private Integer deaths;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "Location{" +
                "date=" + date +
                ", state='" + state + '\'' +
                ", cases=" + cases +
                ", deaths=" + deaths +
                '}';
    }
}
