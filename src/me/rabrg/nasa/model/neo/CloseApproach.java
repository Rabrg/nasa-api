package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;

final class CloseApproach {

    @SerializedName("close_approach_date")
    private String closeApproachDate;
    @SerializedName("epoch_date_close_approach")
    private long epochDateCloseApproach;
    @SerializedName("relative_velocity")
    private RelativeVelocity relativeVelocity;
    @SerializedName("miss_distance")
    private MissDistance missDistance;
    @SerializedName("orbiting_body")
    private String orbitingBody;

    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    public long getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }

    public RelativeVelocity getRelativeVelocity() {
        return relativeVelocity;
    }

    public MissDistance getMissDistance() {
        return missDistance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }
}
