package org.katas.refactoring;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<LineItem> list;

    public Order(String name, String address, List<LineItem> list) {
        this.name = name;
        this.address = address;
        this.list = list;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return list;
    }
}
