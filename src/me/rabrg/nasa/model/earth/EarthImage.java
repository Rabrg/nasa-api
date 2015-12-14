package me.rabrg.nasa.model.earth;

import com.google.gson.annotations.SerializedName;

public final class EarthImage {

    private String date;
    private String url;
    @SerializedName("cloud_score")
    private double cloudScore;
    private String id;

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public double getCloudScore() {
        return cloudScore;
    }

    public String getId() {
        return id;
    }
}
