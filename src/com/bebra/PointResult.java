package com.bebra;

import java.util.Objects;

public class PointResult{
    private double x;
    private double y;
    private double r;
    private String time;
    private boolean valid;
    private boolean hit;

    public PointResult(double x, double y, double r, String time, boolean valid, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = time;
        this.valid = valid;
        this.hit = hit;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointResult that = (PointResult) o;
        return Double.compare(that.x, x) == 0 && y == that.y && Double.compare(that.r, r) == 0 && valid == that.valid && hit == that.hit && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, time, valid, hit);
    }

    @Override
    public String toString() {
        return "PointResult{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", hit=" + hit +
                "}";
    }
}