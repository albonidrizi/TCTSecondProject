package com.tct.SecondProject.model;

import java.util.List;

public class AllRooms {

    private List<Room> items;
    private int total;
    private int page ;


    public List<Room> getItems() {
        return items;
    }
    public void setItems(List<Room> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }



}
