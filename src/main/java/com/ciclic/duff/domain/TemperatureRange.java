package com.ciclic.duff.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TemperatureRange {

    @Id
    @GeneratedValue
    private Integer id;
    private int min;
    private int max;


    public TemperatureRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public TemperatureRange() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int minT) {
        this.min = minT;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "TemperatureRange{" +
                "id=" + id +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
