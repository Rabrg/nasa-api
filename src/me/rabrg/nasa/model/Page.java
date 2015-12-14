package me.rabrg.nasa.model;

import com.google.gson.annotations.SerializedName;

public final class Page {

    private int size;
    @SerializedName("total_elements")
    private int totalElements;
    @SerializedName("total_pages")
    private int totalPages;
    private int number;

    public int getSize() {
        return size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getNumber() {
        return number;
    }
}
