package com.zsz.model;

public class TopERPSystem extends ERPSystem implements Comparable<TopERPSystem> {
    private Double easeOfUse;
    private Double valueForMoney;
    private Double customerSupport;
    private Double functionality;
    private Double totalScore;

    public TopERPSystem(String name, Double easeOfUse, Double valueForMoney, Double customerSupport, Double functionality) {
        super(name);
        this.easeOfUse = easeOfUse;
        this.valueForMoney = valueForMoney;
        this.customerSupport = customerSupport;
        this.functionality = functionality;
    }

    @Override
    public int compareTo(TopERPSystem o) {
        if(getTotalScore() == null || o.getTotalScore() == null){
            return 0;
        }

        return getTotalScore().compareTo(o.getTotalScore());
    }

    @Override
    public String toString() {
        return  super.name +
                ", total score=" + totalScore +
                " " + getLink();
    }

    public Double getEaseOfUse() {
        return easeOfUse;
    }

    public Double getValueForMoney() {
        return valueForMoney;
    }

    public Double getCustomerSupport() {
        return customerSupport;
    }

    public Double getFunctionality() {
        return functionality;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
}
