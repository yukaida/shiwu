package com.example.shiwu.RecyclerView_item;

import java.util.Objects;

public class HomeF_item {
    private String name;
    private int image;
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeF_item item = (HomeF_item) o;
        return name == item.name &&
                image == item.image &&
                Objects.equals(describe, item.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, describe);
    }

    @Override
    public String toString() {
        return "HomeF_item{" +
                "name=" + name +
                ", image=" + image +
                ", describe='" + describe + '\'' +
                '}';
    }
}
