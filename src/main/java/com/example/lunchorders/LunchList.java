package com.example.lunchorders;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LunchList {
    private List<String> lunchOrderList = new ArrayList<>();

    public List<String> getLunchOrderList() {
        return lunchOrderList;
    }

    public void addItem(String item) {
        lunchOrderList.add(item);
    }

    public void removeItem(int num) {
        lunchOrderList.remove(num);
    }

    public LunchList() {
        lunchOrderList.add("Diane - Salad and panini");
    }
}
