package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;

final class RelativeVelocity {

    @SerializedName("kilometers_per_second")
    private String kilometersPerSecond;
    @SerializedName("kilometers_per_hour")
    private String kilometersPerHour;
    @SerializedName("miles_per_hour")
    private String milesPerHour;

    public String getKilometersPerSecond() {
        return kilometersPerSecond;
    }

    public String getKilometersPerHour() {
        return kilometersPerHour;
    }

    public String getMilesPerHour() {
        return milesPerHour;
    }
}
