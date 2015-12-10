package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class NearEarthObject {

    private Links links;
    @SerializedName("neo_reference_id")
    private String neoReferenceid;
    private String name;
    @SerializedName("nasa_jpl_url")
    private String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    private double absoluteMagnitudeH;
    @SerializedName("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;
    @SerializedName("is_potentially_hazardous_asteroid")
    private boolean potentiallyHazardousAsteroid;
    @SerializedName("close_approach_data")
    private List<CloseApproach> closeApproachData;
    @SerializedName("orbital_data")
    private OrbitalData orbitalData;

    public Links getLinks() {
        return links;
    }

    public String getNeoReferenceid() {
        return neoReferenceid;
    }

    public String getName() {
        return name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return potentiallyHazardousAsteroid;
    }

    public List<CloseApproach> getCloseApproachData() {
        return closeApproachData;
    }

    public OrbitalData getOrbitalData() {
        return orbitalData;
    }
}
