package com.example.shiwu.RecyclerView_item;

import java.util.Objects;

public class HomeF_item {
    int name;
    int data;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeF_item that = (HomeF_item) o;
        return name == that.name &&
                data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, data);
    }

    @Override
    public String toString() {
        return "HomeF_item{" +
                "name=" + name +
                ", data=" + data +
                '}';
    }
}
