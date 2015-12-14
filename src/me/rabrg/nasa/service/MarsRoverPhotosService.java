package me.rabrg.nasa.service;

import me.rabrg.nasa.model.mars.MarsRoverPhotos;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MarsRoverPhotosService {

    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    Call<MarsRoverPhotos> marsRoverPhotoSol(@Query("sol") int sol, @Query("camera") String camera, @Query("page") int page,
                                            @Query("api_key") String apiKey);

    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    Call<MarsRoverPhotos> marsRoverPhotoEarthDate(@Query("earth_date") String earthDate, @Query("camera") String camera,
            @Query("page") int page, @Query("api_key") String apiKey);
}
