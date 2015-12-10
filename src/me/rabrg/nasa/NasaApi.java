package me.rabrg.nasa;

import me.rabrg.nasa.model.neo.NearEarthObject;
import me.rabrg.nasa.model.neo.NearEarthObjectBrowse;
import me.rabrg.nasa.model.neo.NearEarthObjectFeed;
import me.rabrg.nasa.service.NearEarthObjectService;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import java.io.IOException;

/**
 * The core class of the NASA API.
 * @author Ryan Greene
 */
public final class NasaApi {

    /**
     * The Retrofit instance used to submit REST requests.
     */
    private final Retrofit retrofit;

    /**
     * The service instance used to get data regarding near earth objects.
     */
    private final NearEarthObjectService nearEarthObjectService;

    /**
     * The API key which is sent in REST requests.
     */
    private final String apiKey;

    /**
     * Constructs a new NASA API instance without an API key which makes REST requests default to the demo API key.
     * The demo API key can be used for 30 requests per IP address per hour and 50 requests per IP address per day.
     */
    public NasaApi() {
        this("");
    }

    /**
     * Constructs a new NASA API instance with the specified API key.
     * @param apiKey The API key.
     */
    public NasaApi(final String apiKey) {
        retrofit = new Retrofit.Builder().baseUrl("https://api.nasa.gov").addConverterFactory(GsonConverterFactory.create()).build();
        nearEarthObjectService = retrofit.create(NearEarthObjectService.class);
        this.apiKey = apiKey;
    }

    /**
     * Gets a list of asteroids based on their closest approach date to Earth.
     * @param startDate The starting date for asteroid search.
     * @param endDate The ending date for asteroid search.
     * @return The list of asteroids based on their closest approach date to Earth.
     * @throws IOException If the request is unsuccessful.
     */
    public NearEarthObjectFeed getNearEarthObjectBrowse(final String startDate, final String endDate) throws IOException {
        return nearEarthObjectService.feed(startDate, endDate, apiKey).execute().body();
    }

    /**
     * Gets a specific asteroid based on its NASA JPL small body (SPK-ID) ID.
     * @param asteroidId The asteroid SPK-ID correlates to the NASA JPL small body.
     * @return The specific asteroid based on its NASA JPL small body (SPK-ID) ID.
     * @throws IOException If the request is unsuccessful.
     */
    public NearEarthObject getNearEarthObject(final int asteroidId) throws IOException {
        return nearEarthObjectService.nearEarthObject(asteroidId, apiKey).execute().body();
    }

    /**
     * Gets the overall Asteroid data-set.
     * @return The overall Asteroid data-set.
     * @throws IOException If the request is unsuccessful.
     */
    public NearEarthObjectBrowse getNearEarthObjectBrowse() throws IOException {
        return nearEarthObjectService.browse(apiKey).execute().body();
    }
}
