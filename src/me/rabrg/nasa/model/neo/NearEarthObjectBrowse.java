package me.rabrg.nasa.model.neo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class NearEarthObjectBrowse {

    private Links links;
    private Page page;
    @SerializedName("near_earth_objects")
    private List<NearEarthObject> nearEarthObjects;

    public Links getLinks() {
        return links;
    }

    public Page getPage() {
        return page;
    }

    public List<NearEarthObject> getNearEarthObjects() {
        return nearEarthObjects;
    }
}
