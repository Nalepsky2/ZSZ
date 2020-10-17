package com.zsz.model;

public class ERPSystem {
    private String name;
    private Integer reviewCount;
    private Double rating;
    private Boolean mac;
    private Boolean win;
    private Boolean lin;
    private Integer price;
    private Boolean small;
    private Boolean medium;
    private Boolean large;

    public ERPSystem(String name, Integer reviewCount, Double rating, Boolean mac, Boolean win, Boolean lin, Integer price, Boolean small, Boolean medium, Boolean large) {
        this.name = name;
        this.reviewCount = reviewCount;
        this.rating = rating;
        this.mac = mac;
        this.win = win;
        this.lin = lin;
        this.price = price;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    @Override
    public String toString() {
        return  name +
                ", reviews" + reviewCount +
                ", rating=" + rating +
                ", price=" + price;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public Double getRating() {
        return rating;
    }

    public Boolean getMac() {
        return mac;
    }

    public Boolean getWin() {
        return win;
    }

    public Boolean getLin() {
        return lin;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean getSmall() {
        return small;
    }

    public Boolean getMedium() {
        return medium;
    }

    public Boolean getLarge() {
        return large;
    }
}
