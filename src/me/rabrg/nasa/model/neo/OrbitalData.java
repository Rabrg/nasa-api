package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;

final class OrbitalData {

    @SerializedName("orbit_id")
    private String orbitId;
    @SerializedName("orbit_determination_date")
    private String orbitDeterminationDate;
    @SerializedName("orbit_uncertainty")
    private String orbitUncertainty;
    @SerializedName("minimum_orbit_intersection")
    private String minimumOrbitIntersection;
    @SerializedName("jupiter_tisserand_invariant")
    private String jupiterTisserandInvariant;
    @SerializedName("epoch_osculation")
    private String epochOsculation;
    @SerializedName("eccentricity")
    private String eccentricity;
    @SerializedName("semi_major_axis")
    private String semiMajorAxis;
    private String inclination;
    @SerializedName("ascending_node_longitude")
    private String ascendingNodeLongitude;
    @SerializedName("orbital_period")
    private String orbitalPeriod;
    @SerializedName("perihelion_distance")
    private String perihelionDistance;
    @SerializedName("perihelion_argument")
    private String perihelionArgument;
    @SerializedName("aphelion_distance")
    private String aphelionDistance;
    @SerializedName("perihelion_time")
    private String perihelionTime;
    @SerializedName("mean_anomaly")
    private String meanAnomaly;
    @SerializedName("mean_motion")
    private String meanMotion;
    private String equinox;

    public String getOrbitId() {
        return orbitId;
    }

    public String getOrbitDeterminationDate() {
        return orbitDeterminationDate;
    }

    public String getOrbitUncertainty() {
        return orbitUncertainty;
    }

    public String getMinimumOrbitIntersection() {
        return minimumOrbitIntersection;
    }

    public String getJupiterTisserandInvariant() {
        return jupiterTisserandInvariant;
    }

    public String getEpochOsculation() {
        return epochOsculation;
    }

    public String getEccentricity() {
        return eccentricity;
    }

    public String getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public String getInclination() {
        return inclination;
    }

    public String getAscendingNodeLongitude() {
        return ascendingNodeLongitude;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getPerihelionDistance() {
        return perihelionDistance;
    }

    public String getPerihelionArgument() {
        return perihelionArgument;
    }

    public String getAphelionDistance() {
        return aphelionDistance;
    }

    public String getPerihelionTime() {
        return perihelionTime;
    }

    public String getMeanAnomaly() {
        return meanAnomaly;
    }

    public String getMeanMotion() {
        return meanMotion;
    }

    public String getEquinox() {
        return equinox;
    }
}
