package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;
import me.rabrg.nasa.model.Links;

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

    private static final class MissDistance {

        private String astronomical;
        private String lunar;
        private String kilometers;
        private String miles;

        public String getAstronomical() {
            return astronomical;
        }

        public String getLunar() {
            return lunar;
        }

        public String getKilometers() {
            return kilometers;
        }

        public String getMiles() {
            return miles;
        }
    }

    private static final class CloseApproach {

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

    private static final class EstimatedDiameter {

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

    private static final class OrbitalData {

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

    private static final class RelativeVelocity {

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
}
