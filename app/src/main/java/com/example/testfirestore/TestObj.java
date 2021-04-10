package com.example.testfirestore;

import java.util.List;

public class TestObj {
    private int id, number;
    private String name;
    private List<String> listUrl;

    public TestObj(int id, int number, String name, List<String> listUrl) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.listUrl = listUrl;
    }

    public TestObj() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListUrl() {
        return listUrl;
    }

    public void setListUrl(List<String> listUrl) {
        this.listUrl = listUrl;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", listUrl0=" + listUrl.get(0) +
                ", listUrl1=" + listUrl.get(1)+
                '}';
    }
}
