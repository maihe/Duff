package com.ciclic.duff.model;

public class TemperatureRange {
    int minT;
    int maxT;

    public TemperatureRange(int min, int max) {
        minT = min;
        maxT = max;
    }

    public int getMinT() {
        return minT;
    }

    public void setMinT(int minT) {
        this.minT = minT;
    }

    public int getMaxT() {
        return maxT;
    }

    public void setMaxT(int maxT) {
        this.maxT = maxT;
    }
}
