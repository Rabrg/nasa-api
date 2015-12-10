package me.rabrg.nasa.model.neo;

import java.util.List;

public final class NearEarthObjectBrowse {

    private Links links;
    private Page page;
    private List<String> nearEarthObjects;

    public Links getLinks() {
        return links;
    }

    public Page getPage() {
        return page;
    }

    public List<String> getNearEarthObjects() {
        return nearEarthObjects;
    }
}
