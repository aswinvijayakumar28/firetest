package com.example.firetest;

public class Listdata {

    public long count;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
   String x = toString().valueOf(count);
        return x;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
