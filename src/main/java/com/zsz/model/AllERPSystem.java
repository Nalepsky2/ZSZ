package com.zsz.model;

public class AllERPSystem extends ERPSystem{
    private Integer reviewCount;
    private Double rating;
    private Boolean mac;
    private Boolean win;
    private Boolean lin;
    private Integer price;
    private Boolean small;
    private Boolean medium;
    private Boolean large;

    public AllERPSystem(String name, Integer reviewCount, Double rating, Boolean mac, Boolean win, Boolean lin, Integer price, Boolean small, Boolean medium, Boolean large) {
        super(name);
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
        return  super.name +
                ", reviews=" + reviewCount +
                ", rating=" + rating +
                ", price=" + price +
                " " + getLink();
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
