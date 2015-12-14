package me.rabrg.nasa.model.mars;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class MarsRoverPhotos {

    private List<MarsRoverPhoto> photos;

    public List<MarsRoverPhoto> getPhotos() {
        return photos;
    }

    private static final class MarsRoverPhoto {

        private int id;
        private int sol;
        private Camera camera;
        @SerializedName("img_src")
        private String imageSource;
        @SerializedName("earth_date")
        private String earthDate;
        private Rover rover;
    }

    private static final class Camera {

        private int id = -1;
        private String name;
        @SerializedName("rover_id")
        private int roverId = -1;
        @SerializedName("full_name")
        private String fullName;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getRoverId() {
            return roverId;
        }

        public String getFullName() {
            return fullName;
        }
    }

    private static final class Rover {

        private int id;
        private String name;
        @SerializedName("landing_date")
        private String landingDate;
        @SerializedName("max_sol")
        private int maxSol;
        @SerializedName("max_date")
        private String maxDate;
        @SerializedName("total_photos")
        private int totalPhotos;
        private List<Camera> cameras;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLandingDate() {
            return landingDate;
        }

        public int getMaxSol() {
            return maxSol;
        }

        public String getMaxDate() {
            return maxDate;
        }

        public int getTotalPhotos() {
            return totalPhotos;
        }

        public List<Camera> getCameras() {
            return cameras;
        }
    }
}
