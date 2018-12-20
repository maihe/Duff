package com.ciclic.duff.model;

public class Beer {

    String style;
    TemperatureRange range;

    public Beer(String style, TemperatureRange range) {
        this.style = style;
        this.range = range;
    }

    public Beer() {

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
}