package me.rabrg.nasa;

import me.rabrg.nasa.model.neo.NearEarthObject;
import me.rabrg.nasa.model.neo.NearEarthObjectBrowse;
import me.rabrg.nasa.model.neo.NearEarthObjectFeed;
import me.rabrg.nasa.service.NearEarthObjectService;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import java.io.IOException;

public final class NasaApi {

    private final Retrofit retrofit;
    private final NearEarthObjectService nearEarthObjectService;
    private final String apiKey;

    public NasaApi(final String apiKey) {
        retrofit = new Retrofit.Builder().baseUrl("https://api.nasa.gov").addConverterFactory(GsonConverterFactory.create()).build();
        nearEarthObjectService = retrofit.create(NearEarthObjectService.class);
        this.apiKey = apiKey;
    }

    public NearEarthObjectFeed getNearEarthObjectBrowse(final String startDate, final String endDate) throws IOException {
        return nearEarthObjectService.feed(startDate, endDate, apiKey).execute().body();
    }

    public NearEarthObject getNearEarthObject(final int asteroidId) throws IOException {
        return nearEarthObjectService.nearEarthObject(asteroidId, apiKey).execute().body();
    }

    public NearEarthObjectBrowse getNearEarthObjectBrowse() throws IOException {
        return nearEarthObjectService.browse(apiKey).execute().body();
    }
}
