package com.zsz.model;

public abstract class ERPSystem {
    String name;

    public ERPSystem(String name) {
        this.name = name;
    }

    protected String getLink() {
        return String.format("https://www.softwareadvice.com/erp/%s-profile/", name).replace(" ", "-");
    }
}
