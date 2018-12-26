package com.ciclic.duff.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Beer implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String style;
    @OneToOne
    private TemperatureRange range;

    public Beer(String style, TemperatureRange range) {
        this.style = style;
        this.range = range;
    }

    public Beer() {

    }

    public Beer(String style, int min, int max) {
        this.style = style;
        this.range = new TemperatureRange(min, max);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public TemperatureRange getRange() {
        return range;
    }

    public void setRange(TemperatureRange range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", style='" + style + '\'' +
                ", range=" + range +
                '}';
    }
}