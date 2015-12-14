package me.rabrg.nasa.service;

import me.rabrg.nasa.model.earth.EarthAssets;
import me.rabrg.nasa.model.earth.EarthImage;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface EarthService {

    @GET("/planetary/earth/imagery")
    Call<EarthImage> earthImage(@Query("lat") double lat, @Query("lon") double lon, @Query("dim") double dim,
            @Query("date") String date, @Query("cloud_score") boolean cloudScore, @Query("api_key") String apiKey);

    @GET("/planetary/earth/assets")
    Call<EarthAssets> earthAssets(@Query("lat") double lat, @Query("lon") double lon, @Query("begin") String begin,
            @Query("end") String end, @Query("api_key") String apiKey);
}
