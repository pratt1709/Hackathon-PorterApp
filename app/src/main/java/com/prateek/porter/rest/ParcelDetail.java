package com.prateek.porter.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

class CurrentLocation {


    @SerializedName("lat")
    private double latitude;

    @SerializedName("long")
    private double longitude;

    /**
     * @return The lat
     */
    public Double getLat() {
        return latitude;
    }

    /**
     * @param lat The lat
     */
    public void setLat(Double lat) {
        this.latitude = lat;
    }

    /**
     * @return The _long
     */
    public Double getLong() {
        return longitude;
    }

    /**
     * @param _long The long
     */
    public void setLong(Double _long) {
        this.longitude = _long;
    }
}

public class ParcelDetail {

    private String name;
    private String imageLink;
    private String type;
    private Double weight;
    private Integer quantity;
    private Double value;
    private String color;
    private String datetime;
    private CurrentLocation currentLocation;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The imageLink
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * @param imageLink The image_link
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight The weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The value
     */
    public Double getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * @return The color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return The datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * @param datetime The datetime
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * @return The currentLocation
     */
    public CurrentLocation getCurrentLocation() {
        return currentLocation;
    }

    /**
     * @param currentLocation The current_location
     */
    public void setCurrentLocation(CurrentLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public static class SortByName implements Comparator<ParcelDetail> {

        @Override
        public int compare(ParcelDetail lhs, ParcelDetail rhs) {
            if (lhs.getName().compareTo(rhs.getName()) < 0) {
                return -1;
            } else if (lhs.getName().compareTo(rhs.getName()) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class SortByValue implements Comparator<ParcelDetail> {

        @Override
        public int compare(ParcelDetail lhs, ParcelDetail rhs) {
            if (lhs.getValue() < rhs.getValue()) {
                return -1;
            } else if (lhs.getValue() == rhs.getValue()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class SortByWeight implements Comparator<ParcelDetail> {

        @Override
        public int compare(ParcelDetail lhs, ParcelDetail rhs) {
            if (lhs.getWeight() < rhs.getWeight()) {
                return -1;
            } else if (lhs.getWeight() == rhs.getWeight()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}