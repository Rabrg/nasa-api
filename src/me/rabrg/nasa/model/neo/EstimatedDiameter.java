package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;

final class EstimatedDiameter {

    private EstimatedDiameterUnit kilometers;
    private EstimatedDiameterUnit meters;
    private EstimatedDiameterUnit miles;
    private EstimatedDiameterUnit feet;

    public EstimatedDiameterUnit getKilometers() {
        return kilometers;
    }

    public EstimatedDiameterUnit getMeters() {
        return meters;
    }

    public EstimatedDiameterUnit getMiles() {
        return miles;
    }

    public EstimatedDiameterUnit getFeet() {
        return feet;
    }

    private static final class EstimatedDiameterUnit {

        @SerializedName("estimated_diameter_min")
        private String estimatedDiameterMin;
        @SerializedName("estimated_diameter_max")
        private String estimatedDiameterMax;

        public String getEstimatedDiameterMin() {
            return estimatedDiameterMin;
        }

        public String getEstimatedDiameterMax() {
            return estimatedDiameterMax;
        }
    }
}
